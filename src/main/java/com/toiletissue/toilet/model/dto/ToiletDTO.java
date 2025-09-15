package com.toiletissue.toilet.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToiletDTO {

    @JsonProperty("(근접) 출입구 번호")
    private String 근접출입구번호;

    @JsonProperty("개방시간")
    private String 개방시간;

    @JsonProperty("게이트 내외 구분")
    private String 게이트내외구분;

    private String 경도;

    private String 관리기관명;

    private String 구분;

    @JsonProperty("기저귀교환대설치유무-남자장애인화장실")
    private String 기저귀교환대설치유무남자장애인화장실;

    @JsonProperty("기저귀교환대설치유무-남자화장실")
    private String 기저귀교환대설치유무남자화장실;

    @JsonProperty("기저귀교환대설치유무-여자장애인화장실")
    private String 기저귀교환대설치유무여자장애인화장실;

    @JsonProperty("기저귀교환대설치유무-여자화장실")
    private String 기저귀교환대설치유무여자화장실;

    @JsonProperty("남녀공용화장실여부")
    private String 남녀공용화장실여부;

    @JsonProperty("남성용-대변기수")
    private Integer 남성용대변기수;

    @JsonProperty("남성용-소변기수")
    private String 남성용소변기수;

    @JsonProperty("남성용-어린이용대변기수")
    private Integer 남성용어린이용대변기수;

    @JsonProperty("남성용-어린이용소변기수")
    private Integer 남성용어린이용소변기수;

    @JsonProperty("남성용-장애인용대변기수")
    private Integer 남성용장애인용대변기수;

    @JsonProperty("남성용-장애인용소변기수")
    private Integer 남성용장애인용소변기수;

    @JsonProperty("데이터기준일자")
    private String 데이터기준일자;

    @JsonProperty("리모델링 연도")
    private String 리모델링연도;

    @JsonProperty("비상벨 설치유무")
    private String 비상벨설치유무;

    @JsonProperty("상세위치")
    private String 상세위치;

    @JsonProperty("소재지도로명주소")
    private String 소재지도로명주소;

    @JsonProperty("소재지지번주소")
    private String 소재지지번주소;

    @JsonProperty("여성용-대변기수")
    private Integer 여성용대변기수;

    @JsonProperty("여성용-어린이용대변기수")
    private Integer 여성용어린이용대변기수;

    @JsonProperty("여성용-장애인용대변기수")
    private Integer 여성용장애인용대변기수;

    @JsonProperty("역명")
    private String 역명;

    @JsonProperty("역층")
    private Integer 역층;

    @JsonProperty("연번")
    private Integer 연번;

    private String 오물처리방식;
    private String 운영노선명;
    private String 위도;
    private String 전화번호;

    @JsonProperty("지상 또는 지하 구분")
    private String 지상또는지하구분;

    @JsonProperty("화장실 설치장소 유형")
    private String 화장실설치장소유형;

    @JsonProperty("화장실입구cctv설치유무")
    private String 화장실입구cctv설치유무;

    private ToiletDTO() {}

    public ToiletDTO(String 근접출입구번호, String 개방시간, String 게이트내외구분, String 경도, String 관리기관명, String 구분, String 기저귀교환대설치유무남자장애인화장실, String 기저귀교환대설치유무남자화장실, String 기저귀교환대설치유무여자장애인화장실, String 기저귀교환대설치유무여자화장실, String 남녀공용화장실여부, Integer 남성용대변기수, String 남성용소변기수, Integer 남성용어린이용대변기수, Integer 남성용어린이용소변기수, Integer 남성용장애인용대변기수, Integer 남성용장애인용소변기수, String 데이터기준일자, String 리모델링연도, String 비상벨설치유무, String 상세위치, String 소재지도로명주소, String 소재지지번주소, Integer 여성용대변기수, Integer 여성용어린이용대변기수, Integer 여성용장애인용대변기수, String 역명, Integer 역층, Integer 연번, String 오물처리방식, String 운영노선명, String 위도, String 전화번호, String 지상또는지하구분, String 화장실설치장소유형, String 화장실입구cctv설치유무) {
        this.근접출입구번호 = 근접출입구번호;
        this.개방시간 = 개방시간;
        this.게이트내외구분 = 게이트내외구분;
        this.경도 = 경도;
        this.관리기관명 = 관리기관명;
        this.구분 = 구분;
        this.기저귀교환대설치유무남자장애인화장실 = 기저귀교환대설치유무남자장애인화장실;
        this.기저귀교환대설치유무남자화장실 = 기저귀교환대설치유무남자화장실;
        this.기저귀교환대설치유무여자장애인화장실 = 기저귀교환대설치유무여자장애인화장실;
        this.기저귀교환대설치유무여자화장실 = 기저귀교환대설치유무여자화장실;
        this.남녀공용화장실여부 = 남녀공용화장실여부;
        this.남성용대변기수 = 남성용대변기수;
        this.남성용소변기수 = 남성용소변기수;
        this.남성용어린이용대변기수 = 남성용어린이용대변기수;
        this.남성용어린이용소변기수 = 남성용어린이용소변기수;
        this.남성용장애인용대변기수 = 남성용장애인용대변기수;
        this.남성용장애인용소변기수 = 남성용장애인용소변기수;
        this.데이터기준일자 = 데이터기준일자;
        this.리모델링연도 = 리모델링연도;
        this.비상벨설치유무 = 비상벨설치유무;
        this.상세위치 = 상세위치;
        this.소재지도로명주소 = 소재지도로명주소;
        this.소재지지번주소 = 소재지지번주소;
        this.여성용대변기수 = 여성용대변기수;
        this.여성용어린이용대변기수 = 여성용어린이용대변기수;
        this.여성용장애인용대변기수 = 여성용장애인용대변기수;
        this.역명 = 역명;
        this.역층 = 역층;
        this.연번 = 연번;
        this.오물처리방식 = 오물처리방식;
        this.운영노선명 = 운영노선명;
        this.위도 = 위도;
        this.전화번호 = 전화번호;
        this.지상또는지하구분 = 지상또는지하구분;
        this.화장실설치장소유형 = 화장실설치장소유형;
        this.화장실입구cctv설치유무 = 화장실입구cctv설치유무;
    }

    public String get근접출입구번호() {
        return 근접출입구번호;
    }

    public void set근접출입구번호(String 근접출입구번호) {
        this.근접출입구번호 = 근접출입구번호;
    }

    public String get개방시간() {
        return 개방시간;
    }

    public void set개방시간(String 개방시간) {
        this.개방시간 = 개방시간;
    }

    public String get게이트내외구분() {
        return 게이트내외구분;
    }

    public void set게이트내외구분(String 게이트내외구분) {
        this.게이트내외구분 = 게이트내외구분;
    }

    public String get경도() {
        return 경도;
    }

    public void set경도(String 경도) {
        this.경도 = 경도;
    }

    public String get관리기관명() {
        return 관리기관명;
    }

    public void set관리기관명(String 관리기관명) {
        this.관리기관명 = 관리기관명;
    }

    public String get구분() {
        return 구분;
    }

    public void set구분(String 구분) {
        this.구분 = 구분;
    }

    public String get기저귀교환대설치유무남자장애인화장실() {
        return 기저귀교환대설치유무남자장애인화장실;
    }

    public void set기저귀교환대설치유무남자장애인화장실(String 기저귀교환대설치유무남자장애인화장실) {
        this.기저귀교환대설치유무남자장애인화장실 = 기저귀교환대설치유무남자장애인화장실;
    }

    public String get기저귀교환대설치유무남자화장실() {
        return 기저귀교환대설치유무남자화장실;
    }

    public void set기저귀교환대설치유무남자화장실(String 기저귀교환대설치유무남자화장실) {
        this.기저귀교환대설치유무남자화장실 = 기저귀교환대설치유무남자화장실;
    }

    public String get기저귀교환대설치유무여자장애인화장실() {
        return 기저귀교환대설치유무여자장애인화장실;
    }

    public void set기저귀교환대설치유무여자장애인화장실(String 기저귀교환대설치유무여자장애인화장실) {
        this.기저귀교환대설치유무여자장애인화장실 = 기저귀교환대설치유무여자장애인화장실;
    }

    public String get기저귀교환대설치유무여자화장실() {
        return 기저귀교환대설치유무여자화장실;
    }

    public void set기저귀교환대설치유무여자화장실(String 기저귀교환대설치유무여자화장실) {
        this.기저귀교환대설치유무여자화장실 = 기저귀교환대설치유무여자화장실;
    }

    public String get남녀공용화장실여부() {
        return 남녀공용화장실여부;
    }

    public void set남녀공용화장실여부(String 남녀공용화장실여부) {
        this.남녀공용화장실여부 = 남녀공용화장실여부;
    }

    public Integer get남성용대변기수() {
        return 남성용대변기수;
    }

    public void set남성용대변기수(Integer 남성용대변기수) {
        this.남성용대변기수 = 남성용대변기수;
    }

    public String get남성용소변기수() {
        return 남성용소변기수;
    }

    public void set남성용소변기수(String 남성용소변기수) {
        this.남성용소변기수 = 남성용소변기수;
    }

    public Integer get남성용어린이용대변기수() {
        return 남성용어린이용대변기수;
    }

    public void set남성용어린이용대변기수(Integer 남성용어린이용대변기수) {
        this.남성용어린이용대변기수 = 남성용어린이용대변기수;
    }

    public Integer get남성용어린이용소변기수() {
        return 남성용어린이용소변기수;
    }

    public void set남성용어린이용소변기수(Integer 남성용어린이용소변기수) {
        this.남성용어린이용소변기수 = 남성용어린이용소변기수;
    }

    public Integer get남성용장애인용대변기수() {
        return 남성용장애인용대변기수;
    }

    public void set남성용장애인용대변기수(Integer 남성용장애인용대변기수) {
        this.남성용장애인용대변기수 = 남성용장애인용대변기수;
    }

    public Integer get남성용장애인용소변기수() {
        return 남성용장애인용소변기수;
    }

    public void set남성용장애인용소변기수(Integer 남성용장애인용소변기수) {
        this.남성용장애인용소변기수 = 남성용장애인용소변기수;
    }

    public String get데이터기준일자() {
        return 데이터기준일자;
    }

    public void set데이터기준일자(String 데이터기준일자) {
        this.데이터기준일자 = 데이터기준일자;
    }

    public String get리모델링연도() {
        return 리모델링연도;
    }

    public void set리모델링연도(String 리모델링연도) {
        this.리모델링연도 = 리모델링연도;
    }

    public String get비상벨설치유무() {
        return 비상벨설치유무;
    }

    public void set비상벨설치유무(String 비상벨설치유무) {
        this.비상벨설치유무 = 비상벨설치유무;
    }

    public String get상세위치() {
        return 상세위치;
    }

    public void set상세위치(String 상세위치) {
        this.상세위치 = 상세위치;
    }

    public String get소재지도로명주소() {
        return 소재지도로명주소;
    }

    public void set소재지도로명주소(String 소재지도로명주소) {
        this.소재지도로명주소 = 소재지도로명주소;
    }

    public String get소재지지번주소() {
        return 소재지지번주소;
    }

    public void set소재지지번주소(String 소재지지번주소) {
        this.소재지지번주소 = 소재지지번주소;
    }

    public Integer get여성용대변기수() {
        return 여성용대변기수;
    }

    public void set여성용대변기수(Integer 여성용대변기수) {
        this.여성용대변기수 = 여성용대변기수;
    }

    public Integer get여성용어린이용대변기수() {
        return 여성용어린이용대변기수;
    }

    public void set여성용어린이용대변기수(Integer 여성용어린이용대변기수) {
        this.여성용어린이용대변기수 = 여성용어린이용대변기수;
    }

    public Integer get여성용장애인용대변기수() {
        return 여성용장애인용대변기수;
    }

    public void set여성용장애인용대변기수(Integer 여성용장애인용대변기수) {
        this.여성용장애인용대변기수 = 여성용장애인용대변기수;
    }

    public String get역명() {
        return 역명;
    }

    public void set역명(String 역명) {
        this.역명 = 역명;
    }

    public Integer get역층() {
        return 역층;
    }

    public void set역층(Integer 역층) {
        this.역층 = 역층;
    }

    public Integer get연번() {
        return 연번;
    }

    public void set연번(Integer 연번) {
        this.연번 = 연번;
    }

    public String get오물처리방식() {
        return 오물처리방식;
    }

    public void set오물처리방식(String 오물처리방식) {
        this.오물처리방식 = 오물처리방식;
    }

    public String get운영노선명() {
        return 운영노선명;
    }

    public void set운영노선명(String 운영노선명) {
        this.운영노선명 = 운영노선명;
    }

    public String get위도() {
        return 위도;
    }

    public void set위도(String 위도) {
        this.위도 = 위도;
    }

    public String get전화번호() {
        return 전화번호;
    }

    public void set전화번호(String 전화번호) {
        this.전화번호 = 전화번호;
    }

    public String get지상또는지하구분() {
        return 지상또는지하구분;
    }

    public void set지상또는지하구분(String 지상또는지하구분) {
        this.지상또는지하구분 = 지상또는지하구분;
    }

    public String get화장실설치장소유형() {
        return 화장실설치장소유형;
    }

    public void set화장실설치장소유형(String 화장실설치장소유형) {
        this.화장실설치장소유형 = 화장실설치장소유형;
    }

    public String get화장실입구cctv설치유무() {
        return 화장실입구cctv설치유무;
    }

    public void set화장실입구cctv설치유무(String 화장실입구cctv설치유무) {
        this.화장실입구cctv설치유무 = 화장실입구cctv설치유무;
    }

    @Override
    public String toString() {
        return "ToiletDTO{" +
                "근접출입구번호='" + 근접출입구번호 + '\'' +
                ", 개방시간='" + 개방시간 + '\'' +
                ", 게이트내외구분='" + 게이트내외구분 + '\'' +
                ", 경도='" + 경도 + '\'' +
                ", 관리기관명='" + 관리기관명 + '\'' +
                ", 구분='" + 구분 + '\'' +
                ", 기저귀교환대설치유무남자장애인화장실='" + 기저귀교환대설치유무남자장애인화장실 + '\'' +
                ", 기저귀교환대설치유무남자화장실='" + 기저귀교환대설치유무남자화장실 + '\'' +
                ", 기저귀교환대설치유무여자장애인화장실='" + 기저귀교환대설치유무여자장애인화장실 + '\'' +
                ", 기저귀교환대설치유무여자화장실='" + 기저귀교환대설치유무여자화장실 + '\'' +
                ", 남녀공용화장실여부='" + 남녀공용화장실여부 + '\'' +
                ", 남성용대변기수=" + 남성용대변기수 +
                ", 남성용소변기수='" + 남성용소변기수 + '\'' +
                ", 남성용어린이용대변기수=" + 남성용어린이용대변기수 +
                ", 남성용어린이용소변기수=" + 남성용어린이용소변기수 +
                ", 남성용장애인용대변기수=" + 남성용장애인용대변기수 +
                ", 남성용장애인용소변기수=" + 남성용장애인용소변기수 +
                ", 데이터기준일자='" + 데이터기준일자 + '\'' +
                ", 리모델링연도='" + 리모델링연도 + '\'' +
                ", 비상벨설치유무='" + 비상벨설치유무 + '\'' +
                ", 상세위치='" + 상세위치 + '\'' +
                ", 소재지도로명주소='" + 소재지도로명주소 + '\'' +
                ", 소재지지번주소='" + 소재지지번주소 + '\'' +
                ", 여성용대변기수=" + 여성용대변기수 +
                ", 여성용어린이용대변기수=" + 여성용어린이용대변기수 +
                ", 여성용장애인용대변기수=" + 여성용장애인용대변기수 +
                ", 역명='" + 역명 + '\'' +
                ", 역층=" + 역층 +
                ", 연번=" + 연번 +
                ", 오물처리방식='" + 오물처리방식 + '\'' +
                ", 운영노선명='" + 운영노선명 + '\'' +
                ", 위도='" + 위도 + '\'' +
                ", 전화번호='" + 전화번호 + '\'' +
                ", 지상또는지하구분='" + 지상또는지하구분 + '\'' +
                ", 화장실설치장소유형='" + 화장실설치장소유형 + '\'' +
                ", 화장실입구cctv설치유무='" + 화장실입구cctv설치유무 + '\'' +
                '}';
    }
}
