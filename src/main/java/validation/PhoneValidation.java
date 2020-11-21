package validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhoneNumberFormatPrefix.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneValidation {

    public String value() default "04";

    public String message() default "Number must start with \"04\" with 7 following digits";

    public Class<?>[] groups() default {};

    public Class<? extends Payload> [] payload() default {};

}
