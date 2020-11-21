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
public @interface Gender {

    public char value() default 'M';

    public String message() default "You must choose your gender";

    public Class<?>[] groups() default {};

    public Class<? extends Payload> [] payload() default {};
}
