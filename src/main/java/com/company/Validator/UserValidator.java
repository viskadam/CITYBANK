package com.company.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.company.model.Customer;
import com.company.services.CustService;


@Component
public class UserValidator implements Validator {
	@Autowired
	private CustService custService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Customer.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Customer cust = (Customer) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		
		if (cust.getUsername().length() < 6 || cust.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		if (custService.findByUsername(cust.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (cust.getPassword().length() < 5 || cust.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		
	}
}