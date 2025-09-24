package com.toiletissue.notice.model.dao;

import com.toiletissue.notice.model.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeDTO> selectAllNotice();

    int insertNotice(NoticeDTO noticeDTO);

    int deleteNotice(int no);

    int updateNotice(NoticeDTO noticeDTO);
}
