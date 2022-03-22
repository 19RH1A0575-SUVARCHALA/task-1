package com.motivity;

import java.util.List;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


public class MainLogic {
	public static void main(String[] args) {
		//Configuration cf=new Configuration();
		//cf.configure();
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("Hib.xml").build();
		Metadata me=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=me.getSessionFactoryBuilder().build();
		Session se=sf.openSession();
		Transaction tx=se.beginTransaction();
		
		/*Employer empr = new Employer();
		empr.setEmployer_id(111);
		empr.setEmployer_name("kavya");
		empr.setMobile(9492317789l);
		empr.setDepartment("dept");*/
		
		
		/*Employee emp=new Employee();
		emp.setEmployee_id(12);
		emp.setEmployee_name("amrutha");
		emp.setMobile(9952477838l);
		emp.setAddress("knr");*/
		
		Query qr=se.createQuery("select e.employee_name,e.mobile,er.employer_name from Employer er INNER JOIN Employee e ON er.employer_id=e.employer");
		List<Object[]> list =qr.list();
		Iterator it=list.iterator();	
		while(it.hasNext()) {
			Object ob[]=(Object[])it.next();
			System.out.println(ob[0]+" "+ob[1]+" "+ob[2]);
		}
		
		/*List <Employee> l1 = new ArrayList<Employee>();
		l1.add(emp);
		empr.setEmployee(l1);

		se.save(empr);
		se.save(emp);*/
		tx.commit();
		se.close();
	}

}
