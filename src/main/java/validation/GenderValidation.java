package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidation implements ConstraintValidator<Gender,Character> {

    private char gender;

    @Override
    public void initialize(Gender gender) {

        this.gender = gender.value();
    }

    @Override
    public boolean isValid(Character character, ConstraintValidatorContext constraintValidatorContext) {

        if(gender == 'M' || gender == 'F') return true;

        return false;
    }
}
