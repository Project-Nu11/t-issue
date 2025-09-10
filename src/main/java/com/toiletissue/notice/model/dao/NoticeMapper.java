package com.toiletissue.notice.model.dao;

import com.toiletissue.notice.model.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    int insertNotice(NoticeDTO noticeDTO);

    void deleteNotice(NoticeDTO noticeDTO);

    List<NoticeDTO> selectAllNotice();
}
