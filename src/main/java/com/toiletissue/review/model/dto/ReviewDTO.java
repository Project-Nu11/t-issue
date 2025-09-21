package com.toiletissue.review.model.dto;

public class ReviewDTO {

    private String content;
    private int score;
    private int no;
    private String memberId;
    private String stationName;
    private String toiletLocation;
    private String date;
    private int decNum;

    private int penalty;

    public ReviewDTO(){}

    public ReviewDTO(String content, int score, int no, String memberId, String stationName, String toiletLocation, String date, int decNum) {
        this.content = content;
        this.score = score;
        this.no = no;
        this.memberId = memberId;
        this.stationName = stationName;
        this.toiletLocation = toiletLocation;
        this.date = date;
        this.decNum = decNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getToiletLocation() {
        return toiletLocation;
    }

    public void setToiletLocation(String toiletLocation) {
        this.toiletLocation = toiletLocation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDecNum() {
        return decNum;
    }

    public void setDecNum(int decNum) {
        this.decNum = decNum;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "content='" + content + '\'' +
                ", score=" + score +
                ", no=" + no +
                ", memberId='" + memberId + '\'' +
                ", stationName='" + stationName + '\'' +
                ", toiletLocation='" + toiletLocation + '\'' +
                ", date='" + date + '\'' +
                ", decNum=" + decNum +
                '}';
    }
}
