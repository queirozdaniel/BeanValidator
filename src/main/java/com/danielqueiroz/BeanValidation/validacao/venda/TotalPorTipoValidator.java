package com.danielqueiroz.BeanValidation.validacao.venda;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.danielqueiroz.BeanValidation.model.TipoVenda;
import com.danielqueiroz.BeanValidation.model.Venda;

public class TotalPorTipoValidator implements ConstraintValidator<TotalPorTipo, Venda>{

	@Override
	public void initialize(TotalPorTipo constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(Venda venda, ConstraintValidatorContext context) {
		if (venda ==  null) {
			return false;
		}
		
		boolean valido = false;
		
		if (venda.getTipo() == TipoVenda.VendaPadrao && venda.getTotal() > 0) {
			valido = true;
		}
		if (venda.getTipo() == TipoVenda.VendaBrinde && venda.getTotal() == 0) {
			valido = true;
		}
		
		return valido;
	}

}
