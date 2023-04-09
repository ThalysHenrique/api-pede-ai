package com.api.pedeai.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Verificado em tempo de execução
@Target(ElementType.FIELD) // Onde será colocada a Annotation (FIELD -> Acima)
@Constraint(validatedBy = NotEmptyListValidator.class)
public @interface NotEmptyList {

    String mensagem() default "A lista não pode ser vazia.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
