package com.telusko.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.telusko.model.Student;

public class LaunchUpdate 
{

	public static void main(String[] args) 
	{
			SessionFactory sessionFactory = new Configuration().configure().
					addAnnotatedClass(Student.class).buildSessionFactory();
			Session session=null;
			Transaction transaction=null;
			boolean flag=false;
			int count=0;
		

			try
			{
				 session=sessionFactory.openSession();
				 
				 transaction=session.beginTransaction();
				 
//				 count=session.createQuery("UPDATE Student SET scity= :city").
//				 setParameter("city", "Chennai").executeUpdate();
				 count=session.createMutationQuery("UPDATE Student SET scity= :city WHERE sName=:name").
				 setParameter("city", "Mumbai").setParameter("name","Rohan").executeUpdate();
		
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
					System.out.println("No of rows updated "+ count);
					
				}
				else
				{
					transaction.rollback();
					System.out.println("No of rows updated "+ count);
				
				}
				
				session.close();
				sessionFactory.close();
			}
		


	}

}
