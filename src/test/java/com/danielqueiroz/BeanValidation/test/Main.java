package com.danielqueiroz.BeanValidation.test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.danielqueiroz.BeanValidation.model.ItemVenda;
import com.danielqueiroz.BeanValidation.model.TipoVenda;
import com.danielqueiroz.BeanValidation.model.Venda;

public class Main {
	
	public static void main(String ... args) {
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator =  factory.getValidator();
		
		ItemVenda item = new ItemVenda();
		item.setDescricao("Camisa Infantil P");
		item.setPreco(12F);
		item.setQuantidade(2);
		
		Venda venda = new Venda();
		venda.setData(Calendar.getInstance().getTime());
		venda.setTipo(TipoVenda.VendaPadrao);
		venda.setTotal(1);
		venda.setItens(Arrays.asList(item));
		
		Set<ConstraintViolation<Venda>> violation = validator.validate(venda);
		
		violation.stream().map(constraint -> "Erro: " + constraint.getMessage() + " "
				+ constraint.getRootBeanClass().getSimpleName() + " "
				+ constraint.getPropertyPath())
			.forEachOrdered(System.out::println);
		
	}

	
}
