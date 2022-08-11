package com.example.employeescontrollar;

import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class employee {
    @NotNull(message ="id can't be null")
    @Size(min = 2,max = 10,message = "id must be more than 2 and less than 10")
    private int ID;
    @NotNull(message ="name can't be null")
    @Size(min = 2,max = 10,message = "name must be more than 4 and less than 10")
    private String name;
    @Max(value = 25,message = "age should be more than 25")
    private int age;
    private boolean onLeave=false;
    @NotNull(message ="id can't be null")
    @Digits(message = "number should contain 4 digits ",fraction =0, integer = 4)
    private int employeeYear;
    @NotNull(message ="id can't be null")
    private int annualLeave;


}
