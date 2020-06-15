package com.ezhire.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="resume")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Resume {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="res_id_gen")
    @SequenceGenerator(name="res_id_gen", sequenceName="RES_ID_GEN")
    private Integer id;

    @Column(name="submissiondate")
    private Date submissionDate;
}
