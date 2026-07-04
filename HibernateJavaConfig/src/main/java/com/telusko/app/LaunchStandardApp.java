package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;

public class LaunchStandardApp 
{

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		
		config=new Configuration();  // it will internally automatically find hibernate.properties file no need to give name 
		
		
		//Pure java configuration no need to write configure method because there is no xml file
		
//		config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
//		config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/telusko_db");
//		config.setProperty("hibernate.connection.password", "YOUR_PASSWORD");
//		config.setProperty("hibernate.connection.username", "root");
//		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		config.setProperty("hibernate.hbm2ddl.auto", "update");
//		config.setProperty("hibernate.show_sql", "true");
//		config.setProperty("hibernate.format_sql", "true");
//		
		
		config.addAnnotatedClass(Student.class);

		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		Student student=new Student();
		student.setSid(14);
		student.setsName("Ramesh");
		student.setScity("Bengaluru");
		
		try
		{
			transaction=session.beginTransaction();
			//session.save(student);
			session.persist(student);
			flag=true;
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(flag==true)
			{
				transaction.commit();
			}
			else
			{
				transaction.rollback();
			}
			
			session.close();
			sessionFactory.close();
			
		}

	}

}
