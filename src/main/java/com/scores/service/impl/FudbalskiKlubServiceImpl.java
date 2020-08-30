package com.scores.service.impl;

import com.scores.model.FudblaskiKlub;
import com.scores.repository.FudbalskiKlubRepository;
import com.scores.service.FudbalskiKlubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FudbalskiKlubServiceImpl implements FudbalskiKlubService {

    private FudbalskiKlubRepository fudbalskiKlubRepository;

    @Autowired
    public FudbalskiKlubServiceImpl(FudbalskiKlubRepository fudbalskiKlubRepository) {
        this.fudbalskiKlubRepository = fudbalskiKlubRepository;
    }

    @Override
    public List<FudblaskiKlub> getKluboviFromLigaAndSezona(Long ligaId, Long sezonaId) {
        return fudbalskiKlubRepository.findByLigaIdAndSezonaId(ligaId, sezonaId);
    }
}
