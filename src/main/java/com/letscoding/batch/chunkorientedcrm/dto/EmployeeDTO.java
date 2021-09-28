package com.letscoding.batch.chunkorientedcrm.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {



    private Integer id;
    private String empname;
    private String username;
    private String status;

}
