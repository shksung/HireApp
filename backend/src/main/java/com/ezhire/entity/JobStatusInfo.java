package com.ezhire.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_status_info")
public class JobStatusInfo {
    @Id
    @Column(name="job_status_id")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="job_status_id_gen")
    @SequenceGenerator(name="job_status_id_gen", sequenceName="JOB_STATUS_ID_GEN")
    private Integer id;

    @Column(name="review_date")
    private Date reviewDate;

    @Column(name="initial_status")
    private String initialStatus;

    @Column(name="phone_screen_date")
    private Date phoneScreenDate;

    @Column(name="phone_screen_status")
    private String phoneScreenStatus;

    @Column(name="in_person_date")
    private Date inPersonDate;

    @Column(name="feedback")
    private String feedBack;

    @Column(name="outcome")
    private String outCome;

    @Column(name="master_status")
    private String masterStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User jobUser;

    @ManyToOne
    @JoinColumn(name="job_id")
    private Job job;

}
