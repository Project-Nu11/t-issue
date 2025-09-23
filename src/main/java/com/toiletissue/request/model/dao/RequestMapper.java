package com.toiletissue.request.model.dao;

import com.toiletissue.request.model.dto.RequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RequestMapper {
    List<RequestDTO> selectAllRequest(String value);

    void requestReject(RequestDTO requestDTO);

    void requestAnswer(RequestDTO requestDTO);

    List<RequestDTO> selectRequestsByCriteria();

    List<RequestDTO> selectPaging(String value, int offset,int size);

    int getTotalRequest(String value);

    void requestInsert(RequestDTO requestDTO);

    List<RequestDTO> selectAllRequestById(String value, String name);
}
