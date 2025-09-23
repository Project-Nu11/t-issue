package com.toiletissue.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @RequestMapping(value = {"/","/main"})
    public void main() {
    }


    @Value("${api.kakao.key}")
    private String kakaoKey;

    @Value("${api.data.serviceKey}")
    private String serviceKey;

    @GetMapping("/main")
    public String mainPage(Model model) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.odcloud.kr/api/15044453/v1/uddi:4189de50-12db-4ae2-a9ca-dfb4d2e25101?page=1&perPage=200&serviceKey=" + serviceKey;

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> body = response.getBody();

        List<Map<String, Object>> dataList = (List<Map<String, Object>>) body.get("data");

        ObjectMapper mapper = new ObjectMapper();

        // 모든 화장실 가져오기 (필터링 필요시 추가)
        List<ToiletDTO> toilets = dataList.stream()
                .map(m -> {
                    try {
                        String json = mapper.writeValueAsString(m); // Map → JSON 문자열
                        return mapper.readValue(json, ToiletDTO.class); // JSON → DTO (여기서 @JsonProperty 적용됨)
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        String toiletJson = mapper.writeValueAsString(toilets);

        model.addAttribute("toiletJson", toiletJson);

        model.addAttribute("kakaoKey", kakaoKey);
        return "main";
    }


}