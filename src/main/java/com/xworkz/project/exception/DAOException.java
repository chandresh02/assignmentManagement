package com.xworkz.project.exception;

import org.hibernate.HibernateException;

public class DAOException extends Exception{
	
	public DAOException(String message)
	{
		super(message);
	}

}
