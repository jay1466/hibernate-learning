package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Answer;
import com.telusko.model.Question;

public class LaunchStandardApp 
{

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		
		config=new Configuration();
		
		config.configure();

		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		Question q1=new Question();
		q1.setId(1);
		q1.setQuestion("What is Hibernate?");
		
		Answer answer1 =new Answer();
		answer1.setId(1);
		answer1.setAnswer("Hibernate is an ORM Framewok");
		
		q1.setAnswer(answer1);
		answer1.setQuestion(q1);
		
		
		
		Question q2=new Question();
		q2.setId(2);
		q2.setQuestion("What is JPA?");
		
		Answer answer2 =new Answer();
		answer2.setId(2);
		answer2.setAnswer("It is a specificatiion used to persist "
				+ "data between Java object and relational database.");
		
		q2.setAnswer(answer2);
		answer2.setQuestion(q2);
		
//		Question qa=session.get(Question.class, 1);
//		System.out.println(qa);
		
		try
		{
			transaction=session.beginTransaction();
			//session.save(student);
			session.persist(q1);
			session.persist(q2);
			
//			session.persist(answer1);
//			session.persist(answer2);
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
