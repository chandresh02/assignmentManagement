package com.xworkz.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.project.entity.SignUpEntity;
import com.xworkz.project.exception.DAOException;

@Repository
public class SignUpDAO implements ISignUpDAO {

	@Autowired
	private SessionFactory factory;

	public void signUpDAOSave(SignUpEntity entity) throws DAOException {

		Session session = null;
		Transaction transaction = null;
		System.out.println("signUpDAO save start");
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			System.out.println("Exception raised in SignUpDAO: "+e.getMessage());
			throw new DAOException("EXcetion occurred SignUpDAO: "+e.getMessage());


		} finally {
			session.close();
		}

		System.out.println("signUpDAO save start");

	}

}
