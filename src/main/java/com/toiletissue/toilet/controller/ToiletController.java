package com.toiletissue.toilet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toiletissue.member.model.dto.MemberDTO;
import com.toiletissue.member.model.service.MemberService;
import com.toiletissue.notice.model.dto.NoticeDTO;
import com.toiletissue.review.model.dto.ReviewDTO;
import com.toiletissue.review.model.service.ReviewService;
import com.toiletissue.toilet.model.dto.ToiletDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/toilet")
public class ToiletController {

    @GetMapping("/manager")
    public void toiletManager() {}

    @Value("${api.data.serviceKey}")
    private String serviceKey;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MemberService memberService;

    public char getInitial(char ch) {
        if (ch < 0xAC00 || ch > 0xD7A3) return ch; // 한글이 아니면 그대로 반환

        char[] CHO = {'ㄱ','ㄲ','ㄴ','ㄷ','ㄸ','ㄹ','ㅁ','ㅂ','ㅃ','ㅅ','ㅆ','ㅇ','ㅈ','ㅉ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
        int base = ch - 0xAC00;
        int chosungIndex = base / 588;
        return CHO[chosungIndex];
    }

    @GetMapping("/stationList")
    public String stationList(Model model,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "initial", required = false) String initial) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.odcloud.kr/api/15044453/v1/uddi:4189de50-12db-4ae2-a9ca-dfb4d2e25101?page=1&perPage=200&serviceKey=" + serviceKey;

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> body = response.getBody();

        List<Map<String, Object>> dataList = (List<Map<String, Object>>) body.get("data");

        ObjectMapper mapper = new ObjectMapper();

        List<ToiletDTO> allToilets = dataList.stream()
                .map(m -> mapper.convertValue(m, ToiletDTO.class))
                .collect(Collectors.toList());

        // 5호선
        List<ToiletDTO> line5Toilets=allToilets.stream()
                .filter(t->"5호선".equals(t.getLines()))
                .collect(Collectors.toList());

//        // 초성 필터링
//        if (initial != null && !initial.isEmpty()) {
//            List<String> initials = Arrays.asList(initial.split(","));
//            line5Toilets = line5Toilets.stream()
//                    .filter(t -> t.getName() != null && initials.contains(String.valueOf(getInitial(t.getName().charAt(0)))))
//                    .collect(Collectors.toList());
//        }
//        // 필터링 후 역이름으로 리스트
//        List<String> stationNames = line5Toilets.stream()
//                .map(ToiletDTO::getName)
//                .distinct()
//                .collect(Collectors.toList());
//
//        // 페이징
//        int pageSize = 8;
//        int totalStations = stationNames.size();
//        int totalPages = (int) Math.ceil((double) totalStations/pageSize);
//
//        if (totalPages == 0) totalPages = 1;
//
//        if (page < 1) page = 1;
//        if (page > totalPages) page = totalPages;
//
//        int start = (page -1)*pageSize;
//        int end = Math.min(start+pageSize, totalStations);
//
//        List<String> pagedStations = (start < totalStations) ? stationNames.subList(start, end) : new ArrayList<>();
//
//        // 번호 510부터 시작, 전체 기준으로 계산
//        int startNumber = 510;
//        List<Map<String, String>> stationsWithNumber = new ArrayList<>();
//        for (int i = 0; i < pagedStations.size(); i++) {
//            Map<String, String> map = new HashMap<>();
//            map.put("name", pagedStations.get(i));
//
//            String numberStr;
//
//            int globalIndex = start + i; // 전체 역에서의 인덱스
//            if (globalIndex >= totalStations - 7) {
//                numberStr = "P" + (549 + (globalIndex - (totalStations - 7)));
//            } else if (globalIndex <= 26) { // 510~536
//                numberStr = String.valueOf(startNumber + globalIndex);
//            } else { // 나머지 역 538~
//                numberStr = String.valueOf(538 + (globalIndex - 27));
//            }
//
//            map.put("number", String.valueOf(numberStr));
//            stationsWithNumber.add(map);
//        }

        // 전체 5호선 역 이름 (중복 제거, 순서 유지)
        List<String> allStationNames = line5Toilets.stream()
                .map(ToiletDTO::getName)
                .distinct()
                .toList();

        // 번호 매핑 (전체 역 기준)
        Map<String, String> stationNumberMap = new HashMap<>();
        int startNumber = 510;
        for (int i = 0; i < allStationNames.size(); i++) {
            String name = allStationNames.get(i);
            String numberStr;

            if (i >= allStationNames.size() - 7) {
                numberStr = "P" + (549 + (i - (allStationNames.size() - 7)));
            } else if (i <= 26) {
                numberStr = String.valueOf(startNumber + i);
            } else {
                numberStr = String.valueOf(538 + (i - 27));
            }
            stationNumberMap.put(name, numberStr);
        }

        // 초성 필터링
        List<String> filteredStations = allStationNames;
        if (initial != null && !initial.isEmpty()) {
            List<String> initials = Arrays.asList(initial.split(","));
            filteredStations = allStationNames.stream()
                    .filter(name -> initials.contains(String.valueOf(getInitial(name.charAt(0)))))
                    .toList();
        }

        // 페이징
        int pageSize = 8;
        int totalStations = filteredStations.size();
        int totalPages = (int) Math.ceil((double) totalStations / pageSize);

        if (totalPages == 0) totalPages = 1;
        if (page < 1) page = 1;
        if (page > totalPages) page = totalPages;

        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, totalStations);

        List<String> pagedStations = (start < totalStations) ? filteredStations.subList(start, end) : new ArrayList<>();

        // 이름 + 번호 묶기
        List<Map<String, String>> stationsWithNumber = new ArrayList<>();
        for (String station : pagedStations) {
            Map<String, String> map = new HashMap<>();
            map.put("name", station);
            map.put("number", stationNumberMap.get(station)); // ★ 전체 기준 번호 사용
            stationsWithNumber.add(map);
        }

        model.addAttribute("stations", stationsWithNumber);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        model.addAttribute("selectedInitial", initial);

        return "toilet/stationList";
    }

    @GetMapping("/station")
    public String toiletListByStation(@RequestParam("stationName") String name, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.odcloud.kr/api/15044453/v1/uddi:4189de50-12db-4ae2-a9ca-dfb4d2e25101?page=1&perPage=200&serviceKey="+serviceKey;

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> body = response.getBody();

        // data 배열 추출
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) body.get("data");

        ObjectMapper mapper = new ObjectMapper();

        List<ToiletDTO> toilets = dataList.stream()
                .map(m -> mapper.convertValue(m, ToiletDTO.class))
//                .filter(t -> t.getName() != null && t.getName().contains(name))
                .filter(t-> name.equals(t.getName()) && "5호선".equals(t.getLines()))
                .collect(Collectors.toMap(
                        t -> t.getGround() + "_" + t.getFloor() + "_" + t.getGateInOut(), // 고유키
                        t -> t,
                        (existing, replacement) -> existing
                ))
                .values()
                .stream()
                .toList();

        model.addAttribute("stationName", name);
        model.addAttribute("toilets", toilets);

        return "toilet/station";
    }

    @PostMapping("/details")
    public String submitReview(ReviewDTO reviewDTO, RedirectAttributes redirectAttributes) {

        System.out.println("post에서 받은 stationName : " + reviewDTO.getStationName());
        System.out.println("post에서 받은 toiletLocation: " + reviewDTO.getToiletLocation());
        // 리뷰 저장
        reviewService.insertReview(reviewDTO);

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.odcloud.kr/api/15044453/v1/uddi:4189de50-12db-4ae2-a9ca-dfb4d2e25101?page=1&perPage=200&serviceKey=" + serviceKey;
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> body = response.getBody();

        List<Map<String, Object>> dataList = (List<Map<String, Object>>) body.get("data");
        ObjectMapper mapper = new ObjectMapper();

        // stationName 기준으로 ToiletDTO 찾기
        ToiletDTO toilet = dataList.stream()
                .map(m -> mapper.convertValue(m, ToiletDTO.class))
                .filter(t -> t.getName().equals(reviewDTO.getStationName()))
                .findFirst()
                .orElse(null);

        // toiletName 생성
        String toiletName = "";
        if (toilet != null) {
            toiletName = toilet.getName() + "역 " + toilet.getGround() + " " + toilet.getFloor() + " " + toilet.getGateInOut() + " 화장실";
        }

        redirectAttributes.addAttribute("stationName", reviewDTO.getStationName());
        redirectAttributes.addAttribute("toiletName", toiletName);
        redirectAttributes.addAttribute("toiletLocation", reviewDTO.getToiletLocation());
        return "redirect:/toilet/details";
    }

    @GetMapping("/details")
    public String toiletDetails(
            @RequestParam(value = "stationName", required = false) String stationName,
            @RequestParam(value = "toiletName", required = false) String toiletName,
//            @RequestParam(value = "toiletLocation", required = false) String toiletLocation,
            Model model, Principal principal) {

//        System.out.println("==== get /details 호출 ====");
//        System.out.println("받은 stationName: " + stationName);
//        System.out.println("받은 toiletName: " + toiletName);

        // api 호출
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.odcloud.kr/api/15044453/v1/uddi:4189de50-12db-4ae2-a9ca-dfb4d2e25101?page=1&perPage=200&serviceKey=" + serviceKey;

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> body = response.getBody();

        List<Map<String, Object>> dataList = (List<Map<String, Object>>) body.get("data");
        ObjectMapper mapper = new ObjectMapper();

        // stationName과 toiletName으로 필터링
        ToiletDTO toilet = dataList.stream()
                .map(m -> mapper.convertValue(m, ToiletDTO.class))
                .filter(t -> {
                    String composedName = t.getName() + "역 " + t.getGround() + " " + t.getFloor() + " " + t.getGateInOut() + " 화장실";
                    boolean matches = t.getName().equals(stationName) && composedName.equals(toiletName);
                    if (matches) {
                        System.out.println("일치하는 화장실 찾음: " + composedName);
                    }
                    return matches;
                })
                .findFirst()
                .orElse(null);

        if (toilet == null) {
            System.out.println("일치하는 화장실 없음");
            toilet = new ToiletDTO();
        }

        // 리뷰
        List<ReviewDTO> reviewList = reviewService.selectReviewListByStation(stationName);
        model.addAttribute("reviewList", reviewList != null ? reviewList : Collections.emptyList());

        // 로그인 회우ㅝㄴ 정보
        boolean isLoggedIn = (principal != null);
        model.addAttribute("isLoggedIn", principal != null);

        if (isLoggedIn) { // 로그인 상태일 때만
            MemberDTO member = memberService.findById(principal.getName());
            model.addAttribute("member", member);
        }

        model.addAttribute("toilet", toilet);
        model.addAttribute("stationName", stationName);
        model.addAttribute("toiletName", toiletName);
//        model.addAttribute("toiletLocation", toiletLocation);

        System.out.println("stationName: " + stationName);
//        System.out.println("toiletLocation: " + toiletLocation);

        System.out.println("끝");

        return "toilet/details";
    }





    @GetMapping("/toilet-sos")
    public void toiletSOS() {}

}