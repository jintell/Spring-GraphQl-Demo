package com.jade.platform.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author: Josiah Adetayo
 * @Email: josleke@gmail.com, josiah.adetayo@meld-tech.com
 * @Date: 4/13/24
 */
public record PatientRequest(String firstName, String lastName, String gender, String phoneNumber, String email,
                             String address, LocalDate visitDate, String diagnosis, String drugCode,
                             AdditionalInformation additionalInformation) {
}
