package com.telusko.app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.AnswerTable;
import com.telusko.model.QuestionTable;

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
		
//		QuestionTable q1=new QuestionTable();
//		q1.setId(1);
//		q1.setQuestion("What is Hibernate?");
//		
//		AnswerTable answer1 =new AnswerTable();
//		answer1.setId(1);
//		answer1.setAnswer("Hibernate is an ORM Framewok");
//		answer1.setQuestionTable(q1);
//		
//		AnswerTable answer2 =new AnswerTable();
//		answer2.setId(2);
//		answer2.setAnswer("Hibernate is an implementation of JPA");
//		answer2.setQuestionTable(q1);
//		
//		List<AnswerTable> answers=new ArrayList<AnswerTable>();
//		answers.add(answer1);
//		answers.add(answer2);
//		
//		q1.setAnswerList(answers);
		
		QuestionTable question = session.get(QuestionTable.class,1);
		
		System.out.println(question.getQuestion());
//		answer=question.getAnswerList();
		
		for(AnswerTable answers: question.getAnswerList())
		{
			System.out.println(answers.getAnswer());
		}
	
		try
		{
			transaction=session.beginTransaction();
	
			//session.persist(q1);


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
