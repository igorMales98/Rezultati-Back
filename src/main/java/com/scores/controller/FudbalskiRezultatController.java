package com.scores.controller;

import com.scores.dto.FudbalskiRezultatDTO;
import com.scores.mapper.FudbalskiRezultatDTOMapper;
import com.scores.model.FudbalskiRezultat;
import com.scores.service.FudbalskiRezultatService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/fudbalski-rezultat", produces = MediaType.APPLICATION_JSON_VALUE)
public class FudbalskiRezultatController {

    private FudbalskiRezultatDTOMapper fudbalskiRezultatDTOMapper;
    private FudbalskiRezultatService fudbalskiRezultatService;

    @Autowired
    public FudbalskiRezultatController(FudbalskiRezultatDTOMapper fudbalskiRezultatDTOMapper, FudbalskiRezultatService fudbalskiRezultatService) {
        this.fudbalskiRezultatDTOMapper = fudbalskiRezultatDTOMapper;
        this.fudbalskiRezultatService = fudbalskiRezultatService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<FudbalskiRezultatDTO>> getAllForToday() {
        try {
            List<FudbalskiRezultatDTO> fudbalskiRezultati = this.fudbalskiRezultatService.getAllForToday().stream().
                    map(fudbalskiRezultatDTOMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(fudbalskiRezultati, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{date}")
    public ResponseEntity<List<FudbalskiRezultatDTO>> getAllForTheDate(@PathVariable("date") Date date) {
        System.out.println(date);
        try {
            List<FudbalskiRezultatDTO> fudbalskiRezultati = this.fudbalskiRezultatService.getAllForTheDate(date).stream().
                    map(fudbalskiRezultatDTOMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(fudbalskiRezultati, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/bodovi/{ligaId}/{sezonaId}/{klubId}")
    public ResponseEntity<Integer> getBodovi(@PathVariable("ligaId") Long ligaId, @PathVariable("sezonaId") Long sezonaId,
                                             @PathVariable("klubId") Long klubId) {
        try {
            Integer bodovi = this.fudbalskiRezultatService.getBodovi(ligaId, sezonaId, klubId);
            return new ResponseEntity<>(bodovi, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{ligaId}/{sezonaId}/{klubId}")
    public ResponseEntity<List<FudbalskiRezultatDTO>> getRezultatiForKlub(@PathVariable("ligaId") Long ligaId, @PathVariable("sezonaId") Long sezonaId,
                                                                          @PathVariable("klubId") Long klubId) {
        try {
            List<FudbalskiRezultatDTO> fudbalskiRezultati = this.fudbalskiRezultatService.getRezultatiForKlub(ligaId, sezonaId, klubId).stream().
                    map(fudbalskiRezultatDTOMapper::toDto).collect(Collectors.toList());
            return new ResponseEntity<>(fudbalskiRezultati, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
