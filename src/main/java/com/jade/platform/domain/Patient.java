package com.jade.platform.domain;

import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @Author: Josiah Adetayo
 * @Email: josleke@gmail.com, josiah.adetayo@meld-tech.com
 * @Date: 4/13/24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("patient")
public class Patient implements Serializable, Persistable<Long> {
    @Id
    private Long id;
    private Instant createdAt;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private LocalDate visitDate;
    private String diagnosis;
    private String drugCode;
    private String additionalInformation;


    @Override
    public boolean isNew() {
        boolean newRecord = Objects.isNull(id);
        if(newRecord) {
            createdAt = Instant.now();
        }
        return newRecord;
    }
}
