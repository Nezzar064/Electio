package com.msn.codeexam.controller;

import com.msn.codeexam.model.dto.CandidateDto;
import com.msn.codeexam.payload.request.CandidateAddEditRequest;
import com.msn.codeexam.payload.response.CandidateListResponse;
import com.msn.codeexam.service.impl.CandidateServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/api/candidate-management")
public class CandidateRestController {

    private final Logger log = LoggerFactory.getLogger(CandidateRestController.class);

    private CandidateServiceImpl candidateService;

    @Autowired
    public CandidateRestController(CandidateServiceImpl candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/candidates/{id}")
    public ResponseEntity<CandidateDto> getCandidate(@PathVariable Long id) {
        log.info("Request to get Candidate by id: {}", id);
        CandidateDto result = candidateService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/candidates")
    public ResponseEntity<List<CandidateListResponse>> getCandidates() {
        log.info("Request to get Candidates");
        List<CandidateListResponse> result = candidateService.findCandidatesWithOnlyPartyName();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/candidates-by-name")
    public ResponseEntity<List<CandidateDto>> getCandidatesByParty(@RequestParam(value="party-name") String partyName) {
        log.info("Request to get Candidates by Party name: {}", partyName);
        List<CandidateDto> result = candidateService.findPartyMembersByParty(partyName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/candidates/add")
    public ResponseEntity<CandidateDto> addCandidate(@Valid @RequestBody CandidateAddEditRequest candidateAddEditRequest) {
        log.info("Request to create Candidate: {}", candidateAddEditRequest);
        CandidateDto result = candidateService.save(candidateAddEditRequest);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/candidates/{id}")
    public ResponseEntity<CandidateDto> updateCandidate(@PathVariable Long id, @Valid @RequestBody CandidateAddEditRequest candidateAddEditRequest) {
        log.info("Request to update Candidate: {}", candidateAddEditRequest);
        CandidateDto result = candidateService.edit(candidateAddEditRequest, id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/candidates/{id}")
    public ResponseEntity<?> deleteAttendance(@PathVariable Long id) {
        log.info("Request to delete Candidate by id: {}", id);
        candidateService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
