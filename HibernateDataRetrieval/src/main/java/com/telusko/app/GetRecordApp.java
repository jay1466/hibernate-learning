package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Student;


public class GetRecordApp 
{

	public static void main(String[] args) 
	{
			SessionFactory sessionFactory = new Configuration().configure()
					.addAnnotatedClass(Student.class).buildSessionFactory();
			Session session1 =null;
			Session session2=null;
			
			try
			{
			   session1 = sessionFactory.openSession();
			   session2 = sessionFactory.openSession();
//			   Student student = session1.get(Student.class, 1);
//			   System.out.println(student);
			   
//			   Student students = session1.get(Student.class, 1);
//			   System.out.println(students);
//			   
//			   
//			   Student student2 = session2.get(Student.class, 1);
//			   System.out.println(student2);
//			   Student student3 = session2.get(Student.class, 1);
//			   System.out.println(student3);
			   
			   
			   
			   
			   //Student student = session1.load(Student.class, 1);
			   
			   
			   Student student = session2.getReference(Student.class, 1);
			   
			   
			   if(student!=null)
			   {
			   System.out.println("Id is : "+ student.getSid());
			   System.in.read();   // this mean stop java app until you press the Enter Button
			   System.out.println("Name is : "+ student.getsName());
			   System.out.println("City is : "+ student.getScity());
			   }
			   else
			   {
				   System.out.println("There is no data/record with given id");
			   }


			      
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
