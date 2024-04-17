package com.jade.platform.model;

import lombok.Builder;

/**
 * @Author: Josiah Adetayo
 * @Email: josleke@gmail.com, josiah.adetayo@meld-tech.com
 * @Date: 4/14/24
 */
@Builder
public record AdditionalInformation(String ssn, String race, String notes, boolean newPatient) {}
