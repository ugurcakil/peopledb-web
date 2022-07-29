package com.ugrckl.peoplwdbweb.biz.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;



@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email mast be valid")
    private String mailAddress;


    @NotNull(message = "Date of birth must be selected")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;


    @NotNull(message = "Salary cannot be empty")
    @DecimalMin(value = "1200",message = "Salary must be at least $ 1200")
    private BigDecimal salary;

    private String photoFileName;


    public Person(Long id, String firstName, String lastName, String mailAddress, LocalDate dob, BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAddress = mailAddress;
        this.dob = dob;
        this.salary = salary;
        this.photoFileName = photoFileName;
    }

}
