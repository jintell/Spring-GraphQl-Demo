package com.jade.platform.repository;

import com.jade.platform.domain.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

/**
 * @Author: Josiah Adetayo
 * @Email: josleke@gmail.com, josiah.adetayo@meld-tech.com
 * @Date: 4/13/24
 */

public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {
    Flux<Patient> findAllBy(Pageable pageable);
    Flux<Patient> findByVisitDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);
}