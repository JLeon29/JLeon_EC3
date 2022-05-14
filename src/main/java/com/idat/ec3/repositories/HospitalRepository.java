package com.idat.ec3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ec3.models.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
