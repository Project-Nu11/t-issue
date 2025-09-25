package com.toiletissue.review.model.dao;

import com.toiletissue.review.model.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ReviewMapper {

    List<ReviewDTO> selectDeclaredReview(String status);

    int cancelDeclaration(ReviewDTO reviewDTO);

    List<ReviewDTO> selectAllReview(String criteria, String search);

   
    int insertReview(ReviewDTO reviewDTO);

    List<ReviewDTO> selectReviewListByStation(String stationName);
    

    int penalizeReview(int no);

    int penalizeMember(String id);

    int deleteReview(int no);

    List<ReviewDTO> selectReviewById(String id);

    List<ReviewDTO> selectDeclaredReviewById(String id);


 /* ========= 마이페이지 ======== */
    /* 내 리뷰 총 개수  */
    int countReviewById(@Param("id") String id);

    /* 내 리뷰 페이징 조회 */
    List<ReviewDTO> selectReviewByIdPaged(@Param("id") String id,
                                          @Param("offset") int offset,
                                          @Param("limit") int limit);

    /* 내 리뷰 수정 */
    int updateReviewByOwner(@Param("no") int no,
                            @Param("id") String memberId,
                            @Param("content") String content,
                            @Param("score") int score);

    /* 내 리뷰 삭제 (본인 것만) */
    int deleteReviewByOwner(@Param("no") int no,
                            @Param("id") String id);

    void declareReview(int no);
}
