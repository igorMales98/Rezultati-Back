package com.scores.service.impl;

import com.scores.model.FudbalskiRezultat;
import com.scores.repository.FudbalskiRezultatRepository;
import com.scores.service.FudbalskiRezultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FudbalskiRezultatServiceImpl implements FudbalskiRezultatService {

    private FudbalskiRezultatRepository fudbalskiRezultatRepository;

    @Autowired
    public FudbalskiRezultatServiceImpl(FudbalskiRezultatRepository fudbalskiRezultatRepository) {
        this.fudbalskiRezultatRepository = fudbalskiRezultatRepository;
    }

    @Override
    public List<FudbalskiRezultat> getAll() {
        return fudbalskiRezultatRepository.findAll();
    }
}
