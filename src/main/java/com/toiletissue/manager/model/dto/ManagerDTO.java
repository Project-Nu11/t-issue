package com.toiletissue.manager.model.dto;

public class ManagerDTO {

    public String id;
    public String pwd;

    public ManagerDTO(){}

    public ManagerDTO(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "ManagerDTO{" +
                "id='" + id + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}
