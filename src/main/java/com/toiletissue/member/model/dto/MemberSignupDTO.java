package com.toiletissue.member.model.dto;

public class MemberSignupDTO {



    private String memberId;
    private String memberPwd;
    private String memberName;
    private String email;
    private String memberBdate;
    private String memberGender;
    private String role;

    public MemberSignupDTO() {}

    public MemberSignupDTO(String memberId, String memberPwd, String memberName, String email, String memberGender, String memberBdate, String role) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.email = email;
        this.memberGender = memberGender;
        this.memberBdate = memberBdate;
        this.role = role;
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

    @Override
    public String toString() {
        return "MemberSignupDTO{" +
                "memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberName='" + memberName + '\'' +
                ", email='" + email + '\'' +
                ", memberBdate='" + memberBdate + '\'' +
                ", memberGender='" + memberGender + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
