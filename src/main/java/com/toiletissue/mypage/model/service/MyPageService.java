package com.toiletissue.mypage.model.service;

import com.toiletissue.member.model.dto.MemberDTO;
import com.toiletissue.mypage.model.dao.MyPageMapper;
import com.toiletissue.review.model.dao.ReviewMapper;
import com.toiletissue.review.model.dto.ReviewDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
public class MyPageService {

    private final MyPageMapper myPageMapper;
    private final PasswordEncoder passwordEncoder;
    private final ReviewMapper reviewMapper;

    public MyPageService(MyPageMapper myPageMapper, PasswordEncoder passwordEncoder, ReviewMapper reviewMapper) {
        this.myPageMapper = myPageMapper;
        this.passwordEncoder = passwordEncoder;
        this.reviewMapper = reviewMapper;
    }

    @Transactional(readOnly = true)
    public MemberDTO getProfile(String memberId) {
        return myPageMapper.findById(memberId);
    }

    @Transactional
    public void changePwd(String memberId, String currentPwd, String newPwd, String confirmPwd) {
        MemberDTO member = myPageMapper.findById(memberId);
        if (member == null) throw new IllegalArgumentException("회원 정보를 찾을 수 없습니다.");

        if (currentPwd == null || !passwordEncoder.matches(currentPwd, member.getMemberPwd())) {
            throw new IllegalArgumentException("현재 비밀번호가 올바르지 않습니다.");
        }
        if (newPwd == null || newPwd.isBlank() || confirmPwd == null) {
            throw new IllegalArgumentException("새 비밀번호를 입력해 주세요.");
        }
        if (!newPwd.equals(confirmPwd)) {
            throw new IllegalArgumentException("새 비밀번호가 일치하지 않습니다.");
        }
        // 영문 + 숫자 포함 8자 이상
        if (!newPwd.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            throw new IllegalArgumentException("비밀번호는 영문과 숫자를 포함해 8자 이상이어야 합니다.");
        }
        // 기존 비번과 동일 금지
        if (passwordEncoder.matches(newPwd, member.getMemberPwd())) {
            throw new IllegalArgumentException("이전 비밀번호와 동일할 수 없습니다.");
        }

        int updated = myPageMapper.updatePasswordByMemberId(memberId, passwordEncoder.encode(newPwd));
        if (updated == 0) throw new IllegalStateException("비밀번호 변경에 실패했습니다.");
    }

    @Transactional
    public void withdraw(String memberId, String currentPwd) {
        MemberDTO memberDTO = myPageMapper.findById(memberId);
        if (memberDTO == null) {
            throw new IllegalArgumentException("회원 정보를 찾을 수 없습니다.");
        }
        if (!passwordEncoder.matches(currentPwd, memberDTO.getMemberPwd())) {
            throw new IllegalArgumentException("비밀번호가 올바르지 않습니다.");
        }
        int rows = myPageMapper.softDelete(memberId);
        if (rows == 0) {
            throw new IllegalStateException("탈퇴 처리에 실패했습니다.");
        }
    }
/* ================= 마이페이지 - 내 리뷰 ================= */
    // 내 리뷰 총 개수
    public int countMyReviews(String memberId) {
        return reviewMapper.countReviewById(memberId);
}

    public java.util.List<ReviewDTO> findMyReviews(String memberId, int page, int size) {
        int p = Math.max(1, page);
        int s = Math.max(1, size > 0 ? size : 10);
        int offset = (p - 1) * s;
        return reviewMapper.selectReviewByIdPaged(memberId, offset, s);
    }

    @Transactional
    //수정
    public void updateMyReview(int no, String memberId, String content, int score){
        if (content == null || content.trim().isEmpty())
            throw new IllegalArgumentException("내용을 입력하세요.");
        String trimmed = content.trim();
        if (trimmed.length() > 255)
            throw new IllegalArgumentException("내용은 255자 이하여야 합니다.");
        if (score < 1 || score > 5)
            throw new IllegalArgumentException("별점은 1~5 사이여야 합니다.");

        int n = reviewMapper.updateReviewByOwner(no, memberId, trimmed, score);
        if (n == 0) throw new IllegalStateException("본인 리뷰만 수정할 수 있습니다.");
    }

    @Transactional
    //삭제
    public void deleteMyReview(int reviewNo, String memberId) {
        int affected = reviewMapper.deleteReviewByOwner(reviewNo, memberId);
        if (affected == 0) throw new IllegalStateException("본인 리뷰만 삭제할 수 있습니다.");
    }


}
