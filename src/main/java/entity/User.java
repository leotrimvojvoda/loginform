package entity;

import lombok.Data;
import validation.Gender;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Pattern(regexp = "[A-Z]", message = "must be only letters and numbers and only 5 characters long")
    @Size(min = 4, max = 25, message = "Must be between 4 and 25 characters")
    private String firstName;
    @Size(min = 4, max = 25, message = "Must be between 4 and 25 characters")
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @Size(min = 8, max = 25, message = "Must be between 8 and 25 characters long")
    private String userPassword;
    private String country;
    @Min(18) @Max(110)
    private int age;
    private char gender;
    @NotNull(message = "Choose at least one of the options")
    private String languages;
}