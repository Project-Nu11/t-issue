package com.toiletissue.declaration.model.dto;

public class DeclarationDTO {

    private int no;
    private String id;

    public DeclarationDTO(){}

    public DeclarationDTO(int no, String id) {
        this.no = no;
        this.id = id;
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

    @Override
    public String toString() {
        return "DeclarationDTO{" +
                "no=" + no +
                ", id='" + id + '\'' +
                '}';
    }
}
