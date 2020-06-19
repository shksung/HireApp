package com.ezhire.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name="users_id")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="user_id_gen")
    @SequenceGenerator(name="user_id_gen", sequenceName="USER_ID_GEN")
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "resumeUser")
    private Resume resume;

    @OneToMany(mappedBy = "jobUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<JobStatusInfo> jobStatusInfos;
}
