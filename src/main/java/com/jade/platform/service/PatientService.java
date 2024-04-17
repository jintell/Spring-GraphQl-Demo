package com.jade.platform.service;

import com.jade.platform.converter.PatientConverter;
import com.jade.platform.domain.Patient;
import com.jade.platform.model.PatientDto;
import com.jade.platform.model.PatientRequest;
import com.jade.platform.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: Josiah Adetayo
 * @Email: josleke@gmail.com, josiah.adetayo@meld-tech.com
 * @Date: 4/13/24
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Mono<PatientDto> getPatientById(Long id) {
        log.info("search in service by  Id: {}", id);
        return patientRepository.findById(id)
                .map(PatientConverter::mapToRecord);
    }

    public Flux<PatientDto> getPatients(int page, int size) {
        log.info("search in service by page: {} and size: {}", page, size);
        Pageable pageRequest = PageRequest.of(page, size);
        return patientRepository.findAllBy(pageRequest)
                .map(PatientConverter::mapToRecord);
    }

    public Flux<PatientDto> getPatientByVisitDate(int page, int size, LocalDate from, LocalDate to) {
        Pageable pageRequest = PageRequest.of(page, size);
        return patientRepository.findByVisitDateBetween(from, to, pageRequest)
                .map(PatientConverter::mapToRecord);
    }

    public Mono<PatientDto> addPatient(PatientRequest patientRequest) {
        Patient patient = Patient.builder()
                .firstName(patientRequest.firstName())
                .lastName(patientRequest.lastName())
                .email(patientRequest.email())
                .gender(patientRequest.gender())
                .phoneNumber(patientRequest.phoneNumber())
                .address(patientRequest.address())
                .diagnosis(patientRequest.diagnosis())
                .visitDate(patientRequest.visitDate())
                .drugCode(patientRequest.drugCode())
                .additionalInformation(PatientConverter.mapToType(List.of(patientRequest.additionalInformation())))
                .build();
        return patientRepository.save(patient)
                .map(PatientConverter::mapToRecord);
    }

    public Mono<PatientDto> updatePatient(Long id, PatientRequest patientRequest) {
        return patientRepository.findById(id)
                .flatMap(patient -> {
                    patient.setEmail(patientRequest.email());
                    patient.setFirstName(patientRequest.firstName());
                    patient.setLastName(patientRequest.lastName());
                    patient.setGender(patientRequest.gender());
                    patient.setAddress(patientRequest.address());
                    patient.setDrugCode(patientRequest.drugCode());
                    patient.setPhoneNumber(patientRequest.phoneNumber());
                    patient.setVisitDate(patientRequest.visitDate());
                    patient.setDiagnosis(patientRequest.diagnosis());
                    patient.setAdditionalInformation(PatientConverter.mapToType(List.of(patientRequest.additionalInformation())));
                    return patientRepository.save(patient)
                            .map(PatientConverter::mapToRecord);
                });
    }
    public Mono<String> deletePatient(Long id) {
        return patientRepository.deleteById(id)
                .thenReturn("Patient with Id "+id+" removed from records");

    }
}
