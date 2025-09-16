package com.toiletissue.toilet.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToiletDTO {

    @JsonProperty("(근접) 출입구 번호")
    private String 근접출입구번호;

    @JsonProperty("개방시간")
    private String openingTime;

    @JsonProperty("게이트 내외 구분")
    private String gateInOut;

    @JsonProperty("경도")
    private String 경도;

    @JsonProperty("관리기관명")
    private String 관리기관명;

    @JsonProperty("구분")
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
    private String location;

    @JsonProperty("소재지도로명주소")
    private String address;

    @JsonProperty("소재지지번주소")
    private String 소재지지번주소;

    @JsonProperty("여성용-대변기수")
    private Integer 여성용대변기수;

    @JsonProperty("여성용-어린이용대변기수")
    private Integer 여성용어린이용대변기수;

    @JsonProperty("여성용-장애인용대변기수")
    private Integer 여성용장애인용대변기수;

    @JsonProperty("역명")
    private String name;

    @JsonProperty("역층")
    private Integer floor;

    @JsonProperty("연번")
    private Integer 연번;

    @JsonProperty("오물처리방식")
    private String 오물처리방식;

    @JsonProperty("운영노선명")
    private String lines;

    @JsonProperty("위도")
    private String 위도;

    @JsonProperty("전화번호")
    private String 전화번호;

    @JsonProperty("지상 또는 지하 구분")
    private String ground;

    @JsonProperty("화장실 설치장소 유형")
    private String 화장실설치장소유형;

    @JsonProperty("화장실입구cctv설치유무")
    private String 화장실입구cctv설치유무;

    private ToiletDTO() {
    }

    public ToiletDTO(String 근접출입구번호, String openingTime, String gateInOut, String 경도, String 관리기관명, String 구분, String 기저귀교환대설치유무남자장애인화장실, String 기저귀교환대설치유무남자화장실, String 기저귀교환대설치유무여자장애인화장실, String 기저귀교환대설치유무여자화장실, String 남녀공용화장실여부, Integer 남성용대변기수, String 남성용소변기수, Integer 남성용어린이용대변기수, Integer 남성용어린이용소변기수, Integer 남성용장애인용대변기수, Integer 남성용장애인용소변기수, String 데이터기준일자, String 리모델링연도, String 비상벨설치유무, String location, String address, String 소재지지번주소, Integer 여성용대변기수, Integer 여성용어린이용대변기수, Integer 여성용장애인용대변기수, String name, Integer floor, Integer 연번, String 오물처리방식, String lines, String 위도, String 전화번호, String ground, String 화장실설치장소유형, String 화장실입구cctv설치유무) {
        this.근접출입구번호 = 근접출입구번호;
        this.openingTime = openingTime;
        this.gateInOut = gateInOut;
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
        this.location = location;
        this.address = address;
        this.소재지지번주소 = 소재지지번주소;
        this.여성용대변기수 = 여성용대변기수;
        this.여성용어린이용대변기수 = 여성용어린이용대변기수;
        this.여성용장애인용대변기수 = 여성용장애인용대변기수;
        this.name = name;
        this.floor = floor;
        this.연번 = 연번;
        this.오물처리방식 = 오물처리방식;
        this.lines = lines;
        this.위도 = 위도;
        this.전화번호 = 전화번호;
        this.ground = ground;
        this.화장실설치장소유형 = 화장실설치장소유형;
        this.화장실입구cctv설치유무 = 화장실입구cctv설치유무;
    }

    public String get근접출입구번호() {
        return 근접출입구번호;
    }

    public void set근접출입구번호(String 근접출입구번호) {
        this.근접출입구번호 = 근접출입구번호;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getGateInOut() {
        return gateInOut;
    }

    public void setGateInOut(String gateInOut) {
        this.gateInOut = gateInOut;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
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

    public String getLines() {
        return lines;
    }

    public void setLines(String lines) {
        this.lines = lines;
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

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
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
                ", openingTime='" + openingTime + '\'' +
                ", gateInOut='" + gateInOut + '\'' +
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
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", 소재지지번주소='" + 소재지지번주소 + '\'' +
                ", 여성용대변기수=" + 여성용대변기수 +
                ", 여성용어린이용대변기수=" + 여성용어린이용대변기수 +
                ", 여성용장애인용대변기수=" + 여성용장애인용대변기수 +
                ", name='" + name + '\'' +
                ", floor=" + floor +
                ", 연번=" + 연번 +
                ", 오물처리방식='" + 오물처리방식 + '\'' +
                ", lines='" + lines + '\'' +
                ", 위도='" + 위도 + '\'' +
                ", 전화번호='" + 전화번호 + '\'' +
                ", ground='" + ground + '\'' +
                ", 화장실설치장소유형='" + 화장실설치장소유형 + '\'' +
                ", 화장실입구cctv설치유무='" + 화장실입구cctv설치유무 + '\'' +
                '}';
    }
}
