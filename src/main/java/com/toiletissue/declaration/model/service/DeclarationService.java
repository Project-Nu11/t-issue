package com.toiletissue.declaration.model.service;

import com.toiletissue.declaration.model.dao.DeclarationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeclarationService {


    @Autowired
    private DeclarationMapper declarationMapper;

    public int declareReview(int no, String id) {
        return declarationMapper.declareReview(no,id);


    }
}
