package com.ezhire.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="resume")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Resume {
    @Id
    @Column(name="resume_id")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="res_id_gen")
    @SequenceGenerator(name="res_id_gen", sequenceName="RES_ID_GEN")
    private Integer id;

    @Column(name="vendor")
    private String vendor;

    @Column(name="vendor_contact")
    private String vendorContact;

    @Column(name= "vendor_email")
    private String vendorEmail;

    @Column(name="submissiondate")
    private Date submissionDate;

    @Column(name="yrs_experience")
    private String experience;

    @OneToOne
    @JoinColumn(name="users_id")
    private User resumeUser;

    @ManyToMany(mappedBy = "resumes")
    private List<Job> jobs;


}
