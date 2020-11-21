package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberFormatPrefix implements ConstraintValidator<PhoneValidation, String> {

    private String numberPrefix;

    @Override
    public void initialize(PhoneValidation phoneNumber) {
        numberPrefix = phoneNumber.value();
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {

        boolean result = false;

        if(phoneNumber != null)
             result = phoneNumber.startsWith(numberPrefix) && phoneNumber.length() == 9 ;

        return result;
    }
}