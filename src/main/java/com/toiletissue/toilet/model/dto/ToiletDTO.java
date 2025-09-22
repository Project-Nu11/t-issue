package com.toiletissue.toilet.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToiletDTO {

    @JsonProperty("(근접) 출입구 번호")
    private String exit;

    @JsonProperty("개방시간")
    private String openingTime;

    @JsonProperty("게이트 내외 구분")
    private String gateInOut;

    @JsonProperty("경도")
    private Double longitude;

    @JsonProperty("관리기관명")
    private String management;

    @JsonProperty("구분")
    private String division;

    @JsonProperty("기저귀교환대설치유무-남자장애인화장실")
    private String diaperDeckYnDmt;

    @JsonProperty("기저귀교환대설치유무-남자화장실")
    private String diaperDeckYnMt;

    @JsonProperty("기저귀교환대설치유무-여자장애인화장실")
    private String diaperDeckYnDwt;

    @JsonProperty("기저귀교환대설치유무-여자화장실")
    private String diaperDeckYnWt;

    @JsonProperty("남녀공용화장실여부")
    private String unisexToiletYn;

    @JsonProperty("남성용-대변기수")
    private Integer menToilet;

    @JsonProperty("남성용-소변기수")
    private String menUrinal;

    @JsonProperty("남성용-어린이용대변기수")
    private Integer boyToilet;

    @JsonProperty("남성용-어린이용소변기수")
    private Integer boyUrinal;

    @JsonProperty("남성용-장애인용대변기수")
    private Integer disabledMenToilet;

    @JsonProperty("남성용-장애인용소변기수")
    private Integer disabledMenUrinal;

    @JsonProperty("데이터기준일자")
    private String dbDate;

    @JsonProperty("리모델링 연도")
    private String remodeling;

    @JsonProperty("비상벨 설치유무")
    private String emergencyBellYn;

    @JsonProperty("상세위치")
    private String toiletLocation;

    @JsonProperty("소재지도로명주소")
    private String address;

    @JsonProperty("소재지지번주소")
    private String streetAddress;

    @JsonProperty("여성용-대변기수")
    private Integer womenToilet;

    @JsonProperty("여성용-어린이용대변기수")
    private Integer girlToilet;

    @JsonProperty("여성용-장애인용대변기수")
    private Integer disabledWomenToilet;

    @JsonProperty("역명")
    private String name;

    @JsonProperty("역층")
    private Integer floor;

    @JsonProperty("연번")
    private Integer serialNumber;

    @JsonProperty("오물처리방식")
    private String wasteDisposalMethod;

    @JsonProperty("운영노선명")
    private String lines;

    @JsonProperty("위도")
    private Double latitude;

    @JsonProperty("전화번호")
    private String phone;

    @JsonProperty("지상 또는 지하 구분")
    private String ground;

    @JsonProperty("화장실 설치장소 유형")
    private String locationType;

    @JsonProperty("화장실입구cctv설치유무")
    private String cctvYn;

    public ToiletDTO() {}

    public ToiletDTO(String exit, String openingTime, String gateInOut, Double longitude, String management, String division, String diaperDeckYnDmt, String diaperDeckYnMt, String diaperDeckYnDwt, String diaperDeckYnWt, String unisexToiletYn, Integer menToilet, String menUrinal, Integer boyToilet, Integer boyUrinal, Integer disabledMenToilet, Integer disabledMenUrinal, String dbDate, String remodeling, String emergencyBellYn, String toiletLocation, String address, String streetAddress, Integer womenToilet, Integer girlToilet, Integer disabledWomenToilet, String name, Integer floor, Integer serialNumber, String wasteDisposalMethod, String lines, Double latitude, String phone, String ground, String locationType, String cctvYn) {
        this.exit = exit;
        this.openingTime = openingTime;
        this.gateInOut = gateInOut;
        this.longitude = longitude;
        this.management = management;
        this.division = division;
        this.diaperDeckYnDmt = diaperDeckYnDmt;
        this.diaperDeckYnMt = diaperDeckYnMt;
        this.diaperDeckYnDwt = diaperDeckYnDwt;
        this.diaperDeckYnWt = diaperDeckYnWt;
        this.unisexToiletYn = unisexToiletYn;
        this.menToilet = menToilet;
        this.menUrinal = menUrinal;
        this.boyToilet = boyToilet;
        this.boyUrinal = boyUrinal;
        this.disabledMenToilet = disabledMenToilet;
        this.disabledMenUrinal = disabledMenUrinal;
        this.dbDate = dbDate;
        this.remodeling = remodeling;
        this.emergencyBellYn = emergencyBellYn;
        this.toiletLocation = toiletLocation;
        this.address = address;
        this.streetAddress = streetAddress;
        this.womenToilet = womenToilet;
        this.girlToilet = girlToilet;
        this.disabledWomenToilet = disabledWomenToilet;
        this.name = name;
        this.floor = floor;
        this.serialNumber = serialNumber;
        this.wasteDisposalMethod = wasteDisposalMethod;
        this.lines = lines;
        this.latitude = latitude;
        this.phone = phone;
        this.ground = ground;
        this.locationType = locationType;
        this.cctvYn = cctvYn;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getManagement() {
        return management;
    }

    public void setManagement(String management) {
        this.management = management;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDiaperDeckYnDmt() {
        return diaperDeckYnDmt;
    }

    public void setDiaperDeckYnDmt(String diaperDeckYnDmt) {
        this.diaperDeckYnDmt = diaperDeckYnDmt;
    }

    public String getDiaperDeckYnMt() {
        return diaperDeckYnMt;
    }

    public void setDiaperDeckYnMt(String diaperDeckYnMt) {
        this.diaperDeckYnMt = diaperDeckYnMt;
    }

    public String getDiaperDeckYnDwt() {
        return diaperDeckYnDwt;
    }

    public void setDiaperDeckYnDwt(String diaperDeckYnDwt) {
        this.diaperDeckYnDwt = diaperDeckYnDwt;
    }

    public String getDiaperDeckYnWt() {
        return diaperDeckYnWt;
    }

    public void setDiaperDeckYnWt(String diaperDeckYnWt) {
        this.diaperDeckYnWt = diaperDeckYnWt;
    }

    public String getUnisexToiletYn() {
        return unisexToiletYn;
    }

    public void setUnisexToiletYn(String unisexToiletYn) {
        this.unisexToiletYn = unisexToiletYn;
    }

    public Integer getMenToilet() {
        return menToilet;
    }

    public void setMenToilet(Integer menToilet) {
        this.menToilet = menToilet;
    }

    public String getMenUrinal() {
        return menUrinal;
    }

    public void setMenUrinal(String menUrinal) {
        this.menUrinal = menUrinal;
    }

    public Integer getBoyToilet() {
        return boyToilet;
    }

    public void setBoyToilet(Integer boyToilet) {
        this.boyToilet = boyToilet;
    }

    public Integer getBoyUrinal() {
        return boyUrinal;
    }

    public void setBoyUrinal(Integer boyUrinal) {
        this.boyUrinal = boyUrinal;
    }

    public Integer getDisabledMenToilet() {
        return disabledMenToilet;
    }

    public void setDisabledMenToilet(Integer disabledMenToilet) {
        this.disabledMenToilet = disabledMenToilet;
    }

    public Integer getDisabledMenUrinal() {
        return disabledMenUrinal;
    }

    public void setDisabledMenUrinal(Integer disabledMenUrinal) {
        this.disabledMenUrinal = disabledMenUrinal;
    }

    public String getDbDate() {
        return dbDate;
    }

    public void setDbDate(String dbDate) {
        this.dbDate = dbDate;
    }

    public String getRemodeling() {
        return remodeling;
    }

    public void setRemodeling(String remodeling) {
        this.remodeling = remodeling;
    }

    public String getEmergencyBellYn() {
        return emergencyBellYn;
    }

    public void setEmergencyBellYn(String emergencyBellYn) {
        this.emergencyBellYn = emergencyBellYn;
    }

    public String getToiletLocation() {
        return toiletLocation;
    }

    public void setToiletLocation(String toiletLocation) {
        this.toiletLocation = toiletLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Integer getWomenToilet() {
        return womenToilet;
    }

    public void setWomenToilet(Integer womenToilet) {
        this.womenToilet = womenToilet;
    }

    public Integer getGirlToilet() {
        return girlToilet;
    }

    public void setGirlToilet(Integer girlToilet) {
        this.girlToilet = girlToilet;
    }

    public Integer getDisabledWomenToilet() {
        return disabledWomenToilet;
    }

    public void setDisabledWomenToilet(Integer disabledWomenToilet) {
        this.disabledWomenToilet = disabledWomenToilet;
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

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getWasteDisposalMethod() {
        return wasteDisposalMethod;
    }

    public void setWasteDisposalMethod(String wasteDisposalMethod) {
        this.wasteDisposalMethod = wasteDisposalMethod;
    }

    public String getLines() {
        return lines;
    }

    public void setLines(String lines) {
        this.lines = lines;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getCctvYn() {
        return cctvYn;
    }

    public void setCctvYn(String cctvYn) {
        this.cctvYn = cctvYn;
    }

    @Override
    public String toString() {
        return "ToiletDTO{" +
                "exit='" + exit + '\'' +
                ", openingTime='" + openingTime + '\'' +
                ", gateInOut='" + gateInOut + '\'' +
                ", longitude=" + longitude +
                ", management='" + management + '\'' +
                ", division='" + division + '\'' +
                ", diaperDeckYnDmt='" + diaperDeckYnDmt + '\'' +
                ", diaperDeckYnMt='" + diaperDeckYnMt + '\'' +
                ", diaperDeckYnDwt='" + diaperDeckYnDwt + '\'' +
                ", diaperDeckYnWt='" + diaperDeckYnWt + '\'' +
                ", unisexToiletYn='" + unisexToiletYn + '\'' +
                ", menToilet=" + menToilet +
                ", menUrinal='" + menUrinal + '\'' +
                ", boyToilet=" + boyToilet +
                ", boyUrinal=" + boyUrinal +
                ", disabledMenToilet=" + disabledMenToilet +
                ", disabledMenUrinal=" + disabledMenUrinal +
                ", dbDate='" + dbDate + '\'' +
                ", remodeling='" + remodeling + '\'' +
                ", emergencyBellYn='" + emergencyBellYn + '\'' +
                ", toiletLocation='" + toiletLocation + '\'' +
                ", address='" + address + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", womenToilet=" + womenToilet +
                ", girlToilet=" + girlToilet +
                ", disabledWomenToilet=" + disabledWomenToilet +
                ", name='" + name + '\'' +
                ", floor=" + floor +
                ", serialNumber=" + serialNumber +
                ", wasteDisposalMethod='" + wasteDisposalMethod + '\'' +
                ", lines='" + lines + '\'' +
                ", latitude=" + latitude +
                ", phone='" + phone + '\'' +
                ", ground='" + ground + '\'' +
                ", locationType='" + locationType + '\'' +
                ", cctvYn='" + cctvYn + '\'' +
                '}';
    }
}
