package com.mapri.webbackend.service;

import com.mapri.webbackend.controller.RequestController;
import com.mapri.webbackend.domain.Proposal;
import com.mapri.webbackend.domain.Request;
import com.mapri.webbackend.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalService {
    @Autowired
    RequestRepository requestRepository;

    public void addToRequest(Proposal proposal, Long requestId) {
        Request request = requestRepository.getOne(requestId);
        if(request != null) {
            request.getProposalList().add(proposal);
            requestRepository.save(request);
        }
    }
}
