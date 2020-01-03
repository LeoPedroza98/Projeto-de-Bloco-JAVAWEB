package com.mapri.webbackend.controller;

import com.mapri.webbackend.domain.Proposal;
import com.mapri.webbackend.repository.ProposalRepository;
import com.mapri.webbackend.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("proposal")
public class ProposalController {
    @Autowired
    ProposalRepository proposalRepository;

    @Autowired
    ProposalService proposalService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Proposal> findAll(){
        Iterable<Proposal> all = proposalRepository.findAll();
        return all;
    }

    @RequestMapping (value = "{requestId}", method = RequestMethod.POST)
    public Proposal save (@RequestBody Proposal proposal, @PathVariable Long requestId){
        Proposal p = proposalRepository.save(proposal);
        proposalService.addToRequest(proposal, requestId);
        return p;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Proposal update (@RequestBody Proposal proposal){
        Proposal p = proposalRepository.save(proposal);
        return p;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete (@RequestBody Proposal proposal){
        proposalRepository.deleteById(proposal.getId());
    }
}
