package com.danielqueiroz.BeanValidation.test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.danielqueiroz.BeanValidation.model.ItemVenda;

public class Main {
	
	public static void main(String ... args) {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator =  factory.getValidator();
		
		ItemVenda item = new ItemVenda();
		
		Set<ConstraintViolation<ItemVenda>> violation = validator.validate(item);
		
		violation.stream().map(constraint -> "Erro: " + constraint.getMessage() + " "
				+ constraint.getRootBeanClass().getSimpleName() + " "
				+ constraint.getPropertyPath())
			.forEachOrdered(System.out::println);
		
	}

	
}
