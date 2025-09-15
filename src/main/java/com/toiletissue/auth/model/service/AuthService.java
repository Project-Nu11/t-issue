
package com.toiletissue.auth.model.service;

import com.toiletissue.auth.model.AuthDetails;
import com.toiletissue.member.model.dao.MemberMapper;
import com.toiletissue.member.model.dto.MemberLoginDTO;
import com.toiletissue.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberLoginDTO login = memberService.findByMemberId(username);

        if(Objects.isNull(login)) {
            throw new UsernameNotFoundException("해당하는 회원 정보가 존재하지 않습니다.");
        }

        return new AuthDetails(login);
    }

    public void login(MemberLoginDTO memberLoginDTO) {

        memberMapper.login(memberLoginDTO);
    }
}

