package com.toiletissue.request.model.dto;

import org.springframework.lang.NonNull;

public class RequestDTO {

    private int no;
    private String id;
    private String title;
    private String content;
    private String type;
    private String datetime;
    private String status;
    private String answer;
    private String reject;

    public RequestDTO(){}

    public RequestDTO(int no, String id, String title, String content, String type, String datetime, String status, String answer, String reject) {
        this.no = no;
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.datetime = datetime;
        this.status = status;
        this.answer = answer;
        this.reject = reject;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getReject() {
        return reject;
    }

    public void setReject(String reject) {
        this.reject = reject;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", datetime='" + datetime + '\'' +
                ", status='" + status + '\'' +
                ", answer='" + answer + '\'' +
                ", reject='" + reject + '\'' +
                '}';
    }
}
