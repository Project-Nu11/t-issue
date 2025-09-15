package com.toiletissue.notice.model.service;

import com.toiletissue.notice.model.dao.NoticeMapper;
import com.toiletissue.notice.model.dto.NoticeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.ExportException;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    public int insertNotice(NoticeDTO noticeDTO) {
        int result = 0;

        try {
            result = noticeMapper.insertNotice(noticeDTO);
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public void deleteNotice(int no) {

        noticeMapper.deleteNotice(no);
    }


    public List<NoticeDTO> selectAllNotice() {

        return noticeMapper.selectAllNotice();
    }

}
