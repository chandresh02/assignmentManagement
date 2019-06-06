package com.xworkz.project.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.project.dao.SignUpDAO;
import com.xworkz.project.dto.SignUpDTO;
import com.xworkz.project.entity.SignUpEntity;
import com.xworkz.project.exception.DAOException;
import com.xworkz.project.exception.ServiceException;
import com.xworkz.project.util.DataValidation;
import com.xworkz.project.util.RandomPasswordGenerator;

@Service
public class SignUpService {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private RandomPasswordGenerator passwordGenerator;
	@Autowired
	private DataValidation dataValidation;
	@Autowired
	private SignUpDAO signUpDAO;

	public SignUpService() {
		System.out.println(this.getClass().getSimpleName() + " object created");
	}

	public void signUpServiceSave(SignUpDTO signUpDTO) throws ServiceException {

		System.out.println("signupservicesave started");

		boolean check = false;
		check = valid(signUpDTO);

		if (check)

		{
			int countryCode = signUpDTO.getCountryCode();
			String emailId = signUpDTO.getEmailId();
			String firstName = signUpDTO.getFirstName();
			String lastName = signUpDTO.getLastName();
			Long mobileNo = signUpDTO.getMobileNo();

			System.out.println("signUpDTO is::" + signUpDTO);
			SignUpEntity entity = new SignUpEntity();
			entity.setCountryCode(countryCode);
			entity.setEmailId(emailId);
			entity.setFirstName(firstName);
			entity.setLastName(lastName);
			entity.setMobileNo(mobileNo);
			entity.setNewUser(true);
			// logic for generating random password

			String randomPassword = passwordGenerator.randomPasswordGeneration();
			System.out.println("random password is::" + randomPassword);

			// encryption of generated random password
			String encryptPassword = Base64.getEncoder().encodeToString(randomPassword.getBytes());
			System.out.println("encrypted password is::" + encryptPassword);

			entity.setPassword(encryptPassword);

			try {
				signUpDAO.signUpDAOSave(entity);

				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(emailId);
				mailMessage.setSubject("confirmation mail from assignment management");
				mailMessage.setText("your account is created \n" + "please login by using \n" + "emallId:: \n" + emailId
						+ "encryptPassword::" + encryptPassword);
				mailSender.send(mailMessage);

			} catch (DAOException e) {

				System.out.println("Exception raised in SignUpService: " + e.getMessage());
				throw new ServiceException("EXcetion occurred in SignUpService: " + e.getMessage());

			}

		}
		System.out.println("signupservicesave end");

	}

	private boolean valid(SignUpDTO signUpDTO) {
		System.out.println("validatio of data going to start");
		if (signUpDTO != null) {
			boolean validFirstName = dataValidation.isValidFname(signUpDTO.getFirstName());
			boolean validLastName = dataValidation.isValidLname(signUpDTO.getLastName());
			boolean validEmailId = dataValidation.isValidEmail(signUpDTO.getEmailId());
			boolean validCountryCode = dataValidation.isValidCountryCode(signUpDTO.getCountryCode());
			boolean validMobileNo = dataValidation.isValidMobileNo(signUpDTO.getMobileNo());
			if (validFirstName && validLastName && validEmailId && validCountryCode && validMobileNo) {
				System.out.println("all data is valid");
				return true;
			}

		} else {
			System.out.println("Invalid Data Found...");
			return false;
		}
		return false;

	}

}
