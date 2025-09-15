//package com.toiletissue.auth.model;
//
//import com.toiletissue.member.model.dto.MemberLoginDTO;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import java.util.ArrayList;
//import java.util.Collection;
//
//
//public class AuthDetails implements UserDetails {
//
//    private MemberLoginDTO memberLoginDTO;
//
//    public AuthDetails() {}
//
//    public AuthDetails(MemberLoginDTO memberLoginDTO) {
//        this.memberLoginDTO = memberLoginDTO;
//    }
//
//    public MemberLoginDTO getMemberLoginDTO() {
//        return memberLoginDTO;
//    }
//
//    public void setMemberLoginDTO(MemberLoginDTO memberLoginDTO) {
//        this.memberLoginDTO = memberLoginDTO;
//    }
//
//    /* 권한 정보를 반환하는 메소드이다.
//     *  UsernamePasswordAuthenticationToken에 사용자의 권한 정보를 넣을 때 사용된다.
//     * */
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        memberLoginDTO.getRole().forEach(role -> authorities.add(() -> role));
//
//        return authorities;
//    }
//
//    /* 사용자의 비밀번호를 반환하는 메소드이다.
//     *  UsernamePasswordAuthenticationToken과 사용자의 비밀번호를 비교할 때 사용한다.
//     * */
//    @Override
//    public String getUsername() {
//        return memberLoginDTO.getMemberId();
//    }
//
//    /* 사용자의 아이디를 반환하는 메소드이다.
//     *  UsernamePasswordAuthenticationToken과 사용자의 아이디를 비교할 때 사용한다.
//     * */
//    @Override
//    public String getPassword() {
//        return memberLoginDTO.getMemberPwd();
//    }
//
//    /* 계정 만료 여부를 표현하는 메소드로 false이면 해당 계정을 사용할 수 없다. */
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    /* 잠겨있는 계정을 확인하는 메소드로 false이면 해당 계정을 사용할 수 없다. */
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    /* 탈퇴 계정 여부를 표현하는 메소드로 false이면 해당 계정을 사용할 수 없다. */
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    /* 계정 비활성화 여부로 사용자가 사용할 수 없는 상태, false이면 해당 계정을 사용할 수 없다. */
//    @Override
//    public boolean isEnabled() {
//        return  memberLoginDTO.isEndStatus();
//    }
//
//}
