package com.toiletissue.member.model.dto;

public class MemberDTO {

    private String memberId;
    private String memberPwd;
    private String memberName;
    private String email;
    private String memberBdate;   // DB DATE → String 처리 (변환은 Service/Mapper에서)
    private String memberGender;
    private String role;          // 기본: ROLE_USER
    private boolean endStatus;    // 0=활동, 1=탈퇴
    private String endDate;       // DB DATE → String 처리

    public MemberDTO() {}

    public MemberDTO(String memberId, String memberPwd, String memberName, String email, String memberBdate, String memberGender, String role, boolean endStatus, String endDate) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.email = email;
        this.memberBdate = memberBdate;
        this.memberGender = memberGender;
        this.role = role;
        this.endStatus = endStatus;
        this.endDate = endDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemberBdate() {
        return memberBdate;
    }

    public void setMemberBdate(String memberBdate) {
        this.memberBdate = memberBdate;
    }

    public String getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEndStatus() {
        return endStatus;
    }

    public void setEndStatus(boolean endStatus) {
        this.endStatus = endStatus;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

//    @Override
//    public String toString() {
//        return "MemberDTO{" +
//                "memberId='" + memberId + '\'' +
//                ", memberPwd='" + memberPwd + '\'' +
//                ", memberName='" + memberName + '\'' +
//                ", email='" + email + '\'' +
//                ", memberBdate='" + memberBdate + '\'' +
//                ", memberGender='" + memberGender + '\'' +
//                ", role='" + role + '\'' +
//                ", endStatus=" + endStatus +
//                ", endDate='" + endDate + '\'' +
//                '}';
//    }
}