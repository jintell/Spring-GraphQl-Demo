package com.jade.platform.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jade.platform.domain.Patient;
import com.jade.platform.model.AdditionalInformation;
import com.jade.platform.model.PatientDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: Josiah Adetayo
 * @Email: josleke@gmail.com, josiah.adetayo@meld-tech.com
 * @Date: 4/14/24
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PatientConverter {
    public static PatientDto mapToRecord(Patient patient) {
        return PatientDto.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .email(patient.getEmail())
                .phoneNumber(patient.getPhoneNumber())
                .address(patient.getAddress())
                .gender(patient.getGender())
                .visitDate(patient.getVisitDate().toString())
                .diagnosis(patient.getDiagnosis())
                .drugCode(patient.getDrugCode())
                .additionalInformation(mapToType(patient.getAdditionalInformation()))
                .createdAt(patient.getCreatedAt())
                .build();
    }

    public static Patient mapToEntity(PatientDto patient) {
        return Patient.builder()
                .firstName(patient.firstName())
                .lastName(patient.lastName())
                .email(patient.email())
                .phoneNumber(patient.phoneNumber())
                .address(patient.address())
                .gender(patient.gender())
                .visitDate(LocalDate.parse(patient.visitDate()))
                .diagnosis(patient.diagnosis())
                .drugCode(patient.drugCode())
                .additionalInformation(mapToType(patient.additionalInformation()))
                .build();
    }
    public static List<AdditionalInformation> mapToType(Patient patient) {
        return new Gson().fromJson(patient.getAdditionalInformation(), new TypeToken<List<AdditionalInformation>>(){}.getType());
    }

    public static List<AdditionalInformation> mapToType(String patientDto) {
        return new Gson().fromJson(patientDto, new TypeToken<List<AdditionalInformation>>(){}.getType());
    }

    public static String mapToType(List<AdditionalInformation> additionalInformation) {
        return new Gson().toJson(additionalInformation);
    }
}
