package com.ezhire.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="job")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="job_id_gen")
    @SequenceGenerator(name="job_id_gen", sequenceName="JOB_ID_GEN")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="minwage")
    private Long minWage;

    @Column(name="maxwage")
    private Long maxWage;

}
