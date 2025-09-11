package com.toiletissue.member.model.dto;

import com.toiletissue.common.MemberRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemberLoginDTO {

    private String memberId;
    private String memberPwd;
    private MemberRole memberRole;
    private boolean endStatus;

    public MemberLoginDTO() {}

    public MemberLoginDTO(String memberId, String memberPwd, MemberRole memberRole, boolean endStatus) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberRole = memberRole;
        this.endStatus = endStatus;
    }

    public List<String> getRole() {
        if(this.memberRole.getRole().length() > 0) {
            return Arrays.asList(this.memberRole.getRole().split(","));
        }
        return new ArrayList<>();
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

    public MemberRole getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(MemberRole memberRole) {
        this.memberRole = memberRole;
    }

    public boolean isEndStatus() {
        return endStatus;
    }

    public void setEndStatus(boolean endStatus) {
        this.endStatus = endStatus;
    }

    @Override
    public String toString() {
        return "MemberLoginDTO{" +
                "memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberRole=" + memberRole + '\'' +
                ", endStatus=" + endStatus +
                '}';
    }
}
