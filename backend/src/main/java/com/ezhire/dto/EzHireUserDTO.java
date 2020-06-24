package com.ezhire.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EzHireUserDTO implements Serializable {
    private Integer id;
    private String userName;
    private String passWord;
    private String name;
    private String role;
}
