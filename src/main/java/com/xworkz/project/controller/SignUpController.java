package com.xworkz.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.project.dto.SignUpDTO;
import com.xworkz.project.exception.ControllerException;
import com.xworkz.project.exception.ServiceException;
import com.xworkz.project.service.SignUpService;

@Controller
@RequestMapping("/")
public class SignUpController {

	@Autowired
	private SignUpService signUpSrvice;

	public SignUpController() {
		System.out.println(this.getClass().getSimpleName() + " object created ");
	}

	@RequestMapping(value = "/signUp.ams", method = RequestMethod.POST)
	public ModelAndView signUpController(SignUpDTO signUpDTO) throws ControllerException {
		System.out.println("signUpController method started");

		try {
			signUpSrvice.signUpServiceSave(signUpDTO);
		} catch (ServiceException e) {
			System.out.println("Exception raised in SignUpController: " + e.getMessage());
			throw new ControllerException("EXcetion occurred in SignUpController: " + e.getMessage());
		}

		System.out.println("signUpController method end");
		return new ModelAndView("Landing.jsp", "msg", "user created successfully");
	}

}
