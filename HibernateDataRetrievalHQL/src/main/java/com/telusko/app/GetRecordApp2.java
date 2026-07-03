package com.telusko.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.telusko.model.Student;

public class GetRecordApp2 
{

	public static void main(String[] args) 
	{
			SessionFactory sessionFactory = new Configuration().configure()
					.addAnnotatedClass(Student.class).buildSessionFactory();
			Session session1 =null;
			try
			{
				session1=sessionFactory.openSession();
				//SELECT * FROM studenttable where scity=?;
				//Query<Student> query = session1.createQuery("FROM Student WHERE scity=:city", Student.class);
				Query<String> query = session1.createQuery("SELECT sName FROM Student WHERE scity IN(:city1, :city2)", String.class);
				query.setParameter("city1", "Bengaluru");
				query.setParameter("city2", "Mumbai");
				List<String> listStudent = query.list();
				
//				for(Student s: listStudent)
//				{
//					System.out.println(s);
//				}
				listStudent.forEach((s)->System.out.println(s));
				

			      
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
			    session1.close();
			    sessionFactory.close();
			}
		


	}

}
