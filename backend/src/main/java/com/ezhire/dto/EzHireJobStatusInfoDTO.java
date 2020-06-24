package com.ezhire.dto;

import com.ezhire.entity.Job;
import com.ezhire.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EzHireJobStatusInfoDTO {
    private Integer id;

    private Date reviewDate;

    private String initialStatus;

    private Date phoneScreenDate;

    private String phoneScreenStatus;

    private Date inPersonDate;

    private String feedBack;

    private String outCome;

    private String masterStatus;

    private String name;

    private String title;

}
