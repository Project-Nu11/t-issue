package com.toiletissue.notice.model.dto;

import java.util.Date;

public class NoticeDTO {

    private int no;
    private String title;
    private String content;
    private Date date;

    public NoticeDTO(){}

    public NoticeDTO(int no, String title, String content, Date date) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
