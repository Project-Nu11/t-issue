package com.toiletissue.common;

public enum MemberRole {

    member("member"),
    manager("manager");

    private String role;

    MemberRole(String role) {
        this.role = role;
    }

    public String getRole() {

        return role;
    }

    @Override
    public String toString() {
        return "MemberRole{" +
                "role='" + role + '\'' +
                '}';
    }
}
