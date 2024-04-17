package com.jade.platform.model;


import lombok.Builder;

import java.time.Instant;
import java.util.List;

@Builder
public record PatientDto(Long id, String firstName, String lastName, String gender, String phoneNumber, String email,
                         String address, String visitDate, String diagnosis, String drugCode,
                         List<AdditionalInformation> additionalInformation, Instant createdAt) {
}
