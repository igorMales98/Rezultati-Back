package com.scores.service.impl;

import com.scores.model.Zemlja;
import com.scores.repository.ZemljaRepository;
import com.scores.service.ZemljaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZemljaServiceImpl implements ZemljaService {

    private ZemljaRepository zemljaRepository;

    @Autowired
    public ZemljaServiceImpl(ZemljaRepository zemljaRepository) {
        this.zemljaRepository = zemljaRepository;
    }

    @Override
    public List<Zemlja> getAll() {
        return zemljaRepository.findAll();
    }
}
