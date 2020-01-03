package com.mapri.webbackend.repository;

import com.mapri.webbackend.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {
    List<Request> findAllByOrderByCreatedDateDesc();
}
