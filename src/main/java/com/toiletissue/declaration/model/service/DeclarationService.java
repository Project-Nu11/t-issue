package com.toiletissue.declaration.model.service;

import com.toiletissue.declaration.model.dao.DeclarationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeclarationService {

    private final DeclarationMapper declarationMapper;

    @Autowired
    public DeclarationService(DeclarationMapper declarationMapper) {
        this.declarationMapper = declarationMapper;
    }

    public void insertDeclaration(int reviewNo, String memberId) {
        declarationMapper.insertDeclaration(reviewNo, memberId);
    }

    public boolean existsDeclaration(int reviewNo, String memberId) {
        return declarationMapper.existsDeclaration(reviewNo, memberId) > 0;
    }
}
