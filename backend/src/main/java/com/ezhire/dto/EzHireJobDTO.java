package com.ezhire.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EzHireJobDTO implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private Long minWage;
    private Long maxWage;

}
