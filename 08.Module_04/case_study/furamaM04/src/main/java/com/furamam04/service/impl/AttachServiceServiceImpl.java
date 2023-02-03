package com.furamam04.service.impl;

import com.furamam04.entity.AttachService;
import com.furamam04.repository.IAttachServiceRepository;
import com.furamam04.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements IAttachServiceService {
    @Autowired
    private IAttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return (List<AttachService>) attachServiceRepository.findAll();
    }
}
