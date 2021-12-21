package com.msn.codeexam.controller;

import com.msn.codeexam.model.dto.PartyDto;
import com.msn.codeexam.service.impl.PartyServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/party-management")
public class PartyRestController {

    private final Logger log = LoggerFactory.getLogger(PartyRestController.class);

    private PartyServiceImpl partyService;

    @Autowired
    public PartyRestController(PartyServiceImpl partyService) {
        this.partyService = partyService;
    }

    @GetMapping("/parties/{id}")
    public ResponseEntity<PartyDto> getParty(@PathVariable Long id) {
        log.info("Request to get Party by id: {}", id);
        PartyDto result = partyService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/parties")
    public ResponseEntity<List<PartyDto>> getParties() {
        log.info("Request to get Parties");
        List<PartyDto> result = partyService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/party-names")
    public ResponseEntity<List<PartyDto>> getPartiesOnlyWithName() {
        log.info("Request to get Parties only with name");
        List<PartyDto> result = partyService.getPartiesOnlyWithName();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/parties/party-by-name")
    public ResponseEntity<PartyDto> getPartyByName(@RequestParam(value="party-name") String partyName) {
        log.info("Request to get Party by name: {}", partyName);
        PartyDto result = partyService.findPartyByName(partyName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
