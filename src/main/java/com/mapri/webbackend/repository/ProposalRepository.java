package com.mapri.webbackend.repository;

import com.mapri.webbackend.domain.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProposalRepository extends JpaRepository<Proposal,Long> {

}
