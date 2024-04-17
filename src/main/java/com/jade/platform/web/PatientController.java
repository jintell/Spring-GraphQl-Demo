package com.jade.platform.web;

import com.jade.platform.converter.PatientConverter;
import com.jade.platform.domain.Patient;
import com.jade.platform.model.AdditionalInformation;
import com.jade.platform.model.PatientDto;
import com.jade.platform.model.PatientRequest;
import com.jade.platform.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
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
@Controller
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @QueryMapping
    public Mono<PatientDto> patientById(@Argument Long id) {
        return patientService.getPatientById(id);
    }

    @QueryMapping
    public Flux<PatientDto> allPatient(@Argument int page, @Argument int size) {
        return patientService.getPatients(page, size);
    }
    @QueryMapping
    public Flux<PatientDto> patientsByVisitDate(@Argument int page,
                                             @Argument int size,
                                             @Argument String from,
                                             @Argument String to) {
        log.info("search by page: {}, size: {}, from: {}, to: {}", page, size, from, to);
        LocalDate startDate = LocalDate.parse(from);
        LocalDate endDate = LocalDate.parse(to);
        return patientService.getPatientByVisitDate(page, size, startDate, endDate);
    }

    @MutationMapping
    public Mono<PatientDto> createPatient(@Argument PatientRequest patientRequest) {
        return patientService.addPatient(patientRequest);
    }

    @MutationMapping
    public Mono<PatientDto> updatePatient(@Argument Long id, @Argument PatientRequest patientRequest) {
        return patientService.updatePatient(id, patientRequest);
    }

    @MutationMapping
    public Mono<String> removePatient(@Argument Long id) {
        return patientService.deletePatient(id);
    }

    @SchemaMapping
    public Mono<List<AdditionalInformation>> additionalInformation(PatientDto patientDto) {
        return Mono.just(patientDto.additionalInformation());
    }
}
