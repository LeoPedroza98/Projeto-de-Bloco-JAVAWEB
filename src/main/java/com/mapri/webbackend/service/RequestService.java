package com.mapri.webbackend.service;

import com.mapri.webbackend.domain.Proposal;
import com.mapri.webbackend.domain.Request;
import com.mapri.webbackend.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RequestService {

    @Autowired
    RequestRepository repository;

    public Request save (Request request) {
        request.setCreatedDate(new Date());
        request.setProposalList(new ArrayList<Proposal>());
        request.setClosed(false);
        return repository.save(request);
    }

    public List<Request> getRequest(int min, int max) {
        List<Request> requests =  repository.findAllByOrderByCreatedDateDesc();
        return requests.subList(min, max);
    }

}
