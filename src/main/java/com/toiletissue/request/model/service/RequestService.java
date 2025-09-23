package com.toiletissue.request.model.service;

import com.toiletissue.request.model.dao.RequestMapper;
import com.toiletissue.request.model.dto.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RequestService {

    @Autowired
    private RequestMapper requestMapper;

    public List<RequestDTO> selectAllRequest(String value) {
        return requestMapper.selectAllRequest(value);
    }

    public void requestReject(RequestDTO requestDTO) {
        requestMapper.requestReject(requestDTO);
    }

    public void requestAnswer(RequestDTO requestDTO) {
        requestMapper.requestAnswer(requestDTO);
    }

    public List<RequestDTO> selectRequestsByCriteria() {
        return requestMapper.selectRequestsByCriteria();
    }

    public List<RequestDTO> getListWithPaging(String value, int offset, int size) {
        return requestMapper.selectPaging(value,offset,size);
    }

    public int getTotalRequest(String value) {
        return requestMapper.getTotalRequest(value);
    }

    public void requestInsert(RequestDTO requestDTO) {
        requestMapper.requestInsert(requestDTO);
    }

//    public List<RequestDTO> selectAllRequest(String value, String name) {


    public List<RequestDTO> selectAllRequestById(String value, String name) {
        return requestMapper.selectAllRequestById(value,name);

    }
}
