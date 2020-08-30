package com.scores.controller;

import com.scores.dto.FudbalskiKlubDTO;
import com.scores.dto.ZemljaDTO;
import com.scores.mapper.FudbalskiKlubDTOMapper;
import com.scores.service.FudbalskiKlubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/fudbalski-klub", produces = MediaType.APPLICATION_JSON_VALUE)
public class FudbalskiKlubController {

    private FudbalskiKlubService fudbalskiKlubService;
    private FudbalskiKlubDTOMapper fudbalskiKlubDTOMapper;

    @Autowired
    public FudbalskiKlubController(FudbalskiKlubService fudbalskiKlubService, FudbalskiKlubDTOMapper fudbalskiKlubDTOMapper) {
        this.fudbalskiKlubService = fudbalskiKlubService;
        this.fudbalskiKlubDTOMapper = fudbalskiKlubDTOMapper;
    }

    @GetMapping(value = "/{ligaId}/{sezonaId}")
    public ResponseEntity<List<FudbalskiKlubDTO>> getKluboviFromLiga(@PathVariable("ligaId") Long id, @PathVariable("sezonaId") Long sezonaId) {
        try {
            List<FudbalskiKlubDTO> kluboviDtos = this.fudbalskiKlubService.getKluboviFromLigaAndSezona(id, sezonaId).stream()
                    .map(fudbalskiKlubDTOMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(kluboviDtos, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
