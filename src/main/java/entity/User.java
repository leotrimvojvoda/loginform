package entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Pattern(regexp = "[a-zA-Z]", message = "Must contain only letters")
    @Size(min = 3, max = 25, message = "Must be between 3 and 25 characters")
    private String firstName;
    @Size(min = 3, max = 25, message = "Must be between 3 and 25 characters")
    @Pattern(regexp = "[a-zA-Z]", message = "Must contain only letters")
    private String lastName;
    @Email @NotNull @NotBlank
    private String email;
    @Size(min = 8, max = 50, message = "Must be between 8 and 25 characters long")
    private String userPassword;
    private String country;
    @Min(18) @Max(110)
    private int age;
    private char gender;
    @NotNull(message = "Choose at least one of the options")
    private String languages;
}