package com.scores.service;

import com.scores.model.FudblaskiKlub;

import java.util.List;

public interface FudbalskiKlubService {
    List<FudblaskiKlub> getKluboviFromLigaAndSezona(Long ligaId, Long sezonaId);
}
