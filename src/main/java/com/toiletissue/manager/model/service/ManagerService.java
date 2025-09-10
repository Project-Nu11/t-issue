package com.toiletissue.manager.model.service;

import com.toiletissue.manager.model.dto.ManagerDTO;
import com.toiletissue.manager.model.dao.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    public void managerLogin(ManagerDTO managerDTO) {



        managerMapper.managerLogin(managerDTO);
    }
}
