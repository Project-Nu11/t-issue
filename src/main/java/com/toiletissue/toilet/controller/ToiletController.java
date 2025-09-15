package com.toiletissue.toilet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toiletissue.toilet.model.dto.ToiletDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/toilet")
public class ToiletController {

    @GetMapping("/manager")
    public void toiletManager(){}

//    @Value("${api.data.serviceKey}")
//    private String serviceKey;

//    @GetMapping("/subway")
//    public String stationToiletList(Model model) {
//
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://api.odcloud.kr/api/15044453/v1/uddi:4189de50-12db-4ae2-a9ca-dfb4d2e25101?page=1&perPage=1&serviceKey=" + serviceKey;
//
//        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
//        Map<String, Object> body = response.getBody();
//
//        List<Map<String, Object>> dataList = (List<Map<String, Object>>) body.get("data");
//
//        ObjectMapper mapper = new ObjectMapper();
//        List<ToiletDTO> allToilets = dataList.stream()
//                .map(m -> mapper.convertValue(m, ToiletDTO.class))
//                .collect(Collectors.toList());
//
//        List<String> stationNames = allToilets.stream()
//                .map(ToiletDTO::get역명)
//                .distinct()
//                .collect(Collectors.toList());
//
//        model.addAttribute("stations", stationNames);
//
//        return "toilet/subway";
//    }

    @GetMapping("/station")
    public void stationNameToiletList() {}

//    @GetMapping("/station")
//    public String toiletDetails(Model model, Map map) {
//
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://api.odcloud.kr/api/15044453/v1/uddi:4189de50-12db-4ae2-a9ca-dfb4d2e25101?page=1&perPage=1&serviceKey="+serviceKey;
//
//        // Map으로 response 받기
//        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
//        Map<String, Object> body = response.getBody();
//
//        // data 배열 추출??
//        List<Map<String, Object>> dataList = (List<Map<String, Object>>) body.get("data");
//
//        ObjectMapper mapper = new ObjectMapper();
////        ToiletDTO toilet = mapper.convertValue(dataList.get(0), ToiletDTO.class);
//        List<ToiletDTO> toilets = dataList.stream()
//                        .map(m->mapper.convertValue(m, ToiletDTO.class))
//                                .toList();
//
//        model.addAttribute("toilets", toilets);
//
//        return "toilet/toilet-name";
//    }



}
