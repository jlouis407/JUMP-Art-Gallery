package com.cognixia.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Art;

@Repository
public interface ArtRepository extends JpaRepository<Art, Long> {

}
