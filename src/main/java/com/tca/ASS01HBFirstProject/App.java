package com.tca.ASS01HBFirstProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Configuration configuration = null;
        SessionFactory sessionfactory =null;
        Session session=null;
        Transaction transaction=null;
        
        try {
        	
        	
        	 configuration = new Configuration();
        	
        	configuration.configure("hibernate.cfg.xml");
        	
        	
        	
        	
            sessionfactory = configuration.buildSessionFactory();
            session = sessionfactory.openSession();
            transaction =session.beginTransaction();
        	
            
            Student student = new Student();
            student.setRno(101);
            student.setName("AAA");
            student.setPer(70.80);
            
            session.save(student);
            
               
            transaction.commit();
            System.out.println("Data Saved Successfully");
       	
            Student ob = (Student) session.get(Student.class,101);
            
            System.out.println(ob.getName());
            System.out.println(ob.getPer());
        }
        
        
        
        catch(Exception e) {
        	e.printStackTrace();
        	transaction.rollback();
        	
        }
        
        finally {
        	
        	
        	
        	
        }
        
     
    }
}
