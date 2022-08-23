package paquete;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Ejercicios {
	public static void Act1() throws IOException {
		//Añadir Tabla
				Configuration config = new Configuration().configure();
				SessionFactory sesionFactory = config.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
				Session sesion = sesionFactory.openSession();
				Transaction tx = null;
				String sql = "CREATE TABLE books(\r\n"
						+"id Integer PRIMARY KEY AUTO_INCREMENT,\r\n"
						+"Title varchar(100),\r\n"
						+"Year Integer,\r\n"
						+"Subject Integer REFERENCES course(id));";
				sesion.createSQLQuery(sql).executeUpdate();
				tx.commit();
				
				//Leer y almacenar informacion a la tabla desde un CSV
			    BufferedReader br = null;
				br =new BufferedReader(new FileReader("C:\\Users\\rafah\\Downloads\\Harry_Potter_libros.csv"));
		        String line;
		        Books b = new Books();
		        br.readLine();
		        while ((line = br.readLine()) != null) {
		            
		           String [] fields = line.split(";");
		           System.out.println(fields[0]+fields[1]+fields[2]);

		           b.setTitle(fields[0]);
		           int anio = Integer.parseInt(fields[1]);
		           b.setYear(anio);
		           List<Course> dl =  sesion.createQuery("from Course where name ='"+fields[2]+"'").getResultList();
		   			for(Course p:dl) {
		   	           b.setSubject(p.getId());
		   			}
		           sesion.save(b);
		           try {
		        	    // create session
		        	    tx = sesion.beginTransaction();
		        	    // do something
		        	    tx.commit();
		        	} catch (Exception exp) {
		        	    tx.rollback();
		        	    // close session
		        	}
		        }
	}
	public static void Act2(){
		Configuration config = new Configuration().configure();
		SessionFactory sesionFactory = config.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session sesion = sesionFactory.openSession();
		
		// Cogemos los puntos quitados de los alumnos
				long puntos = (long)sesion.createQuery("select sum(h.points) from HousePoints h where h.personByGiver.firstName = 'Severus' and h.personByGiver.lastName = 'Snape'\r\n" + 
						"and (h.personByReceiver.firstName = 'Harry' and h.personByReceiver.lastName = 'Potter') or (h.personByReceiver.firstName = 'Ron' and h.personByReceiver.lastName = 'Weasley')").uniqueResult();

				System.out.println("Puntos quitados a H y P por SS:" + puntos);		
				
		// Array bidimensional  de los alumnos
		String[][] alumnos = {{"Harry", "Potter"}, {"Ron", "Weasley"}};

		Transaction tx = sesion.beginTransaction();
		
		//Hacemos el insert para duplicar el valor
		String insert = "";
		
		for(String[] alumno: alumnos) {			
			insert = "insert into HousePoints (personByGiver, personByReceiver, points) " + 
					"select h.personByGiver, h.personByReceiver, points from HousePoints h " + 
					"where h.personByGiver.firstName = 'Severus' and h.personByGiver.lastName = 'Snape' " + 
					"and h.personByReceiver.firstName = ?1 and h.personByReceiver.lastName = ?2";
			
			sesion.createQuery(insert).setParameter(1, alumno[0]).setParameter(2, alumno[1]).executeUpdate();			
		}
		tx.commit();
		
		//Volvemos a imprimir para ver los puntos duplicados
		puntos = (long)sesion.createQuery("select sum(h.points) from HousePoints h where h.personByGiver.firstName = 'Severus' and h.personByGiver.lastName = 'Snape'\r\n" + 
				"and (h.personByReceiver.firstName = 'Harry' and h.personByReceiver.lastName = 'Potter') or (h.personByReceiver.firstName = 'Ron' and h.personByReceiver.lastName = 'Weasley')").uniqueResult();

		System.out.println("Puntos quitados a H y P por SS:" + puntos);	
	
	}
	
	public static void Act3(){
		Configuration config = new Configuration().configure();
		SessionFactory sesionFactory = config.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session sesion = sesionFactory.openSession();
		
		// Alumnos matriculados en Muggle Studies
	    long alumnosMuggle = (long) sesion.createQuery("select count(c.person) from Course c inner join c.persons p where c.name = 'Muggle Studies'").uniqueResult();
	    System.out.println("Alumnos en Muggle Studies: " + alumnosMuggle);
	    
	    // Alumnos
	    List <Person> alumnos = sesion.createQuery("from Person").getResultList();

	    // Id de todos los alumnos de pociones
	    List <Integer> alumnosPociones = sesion.createQuery("select p.id from Person p inner join p.courses_1 c where c.name = 'Potions'").getResultList();
	    
	    // Curso de Muggle Studies
	    int muggleStudies = (int) sesion.createQuery("select id from Course where name='Muggle Studies'").uniqueResult();
	    
		Transaction tx = sesion.beginTransaction();

	    for(Person alumno: alumnos) {
	    	for(int id:alumnosPociones) {
	    		// Si es igual lo metemos en muggleStudies
	    		if(alumno.getId()==id) {
	    			String insert = "INSERT INTO enrollment(person_enrollment,course_enrollment) VALUES (?1, ?2)";	    			
	    			sesion.createNativeQuery(insert).setParameter(1, alumno).setParameter(2, muggleStudies).executeUpdate();
	    		}
	    	}
	    }
	    tx.commit();

		// Obtenemos el total de alumnos matriculados en Muggle Studies
	    alumnosMuggle = (long) sesion.createQuery("select count(c.person) from Course c inner join c.persons p where c.name = 'Muggle Studies'").uniqueResult();
	    System.out.println("Alumnos matriculados en Muggle Studies: " + alumnosMuggle);	
	
	
	}
	public static void Act4(){
		Configuration config = new Configuration().configure();
		SessionFactory sesionFactory = config.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session sesion = sesionFactory.openSession();
		Transaction tx = sesion.beginTransaction();
		// Obtenemos el total de alumnos en Flying
		
	    long alumnosFlying = (long) sesion.createQuery("select count(c.person) from Course c inner join c.persons p where c.name = 'Flying'").uniqueResult();
	    System.out.println("Alumnos matriculados en Flying: " + alumnosFlying);
	    
	    // Metemos todos los alumnos
	    List <Person> alumnos = sesion.createQuery("from Person").getResultList();

	    // Metemos todas las ids de los alumnos de Transfiguration
	    List <Integer> alumnosTransfiguration = sesion.createQuery("select p.id from Person p inner join p.courses_1 c where c.name = 'Transfiguration'").getResultList();
	    
	    // Cogemos la Id de Flying
	    int flying = (int) sesion.createQuery("select id from Course where name='Flying'").uniqueResult();
	    
	    for(Person alumno: alumnos) {
	    	for(int id:alumnosTransfiguration) {
	    		// Si es igual lo metemos a Flying
	    		if(alumno.getId()==id) {
	    			sesion = sesionFactory.openSession();
	    			tx = sesion.beginTransaction();
	    			String insert = "INSERT INTO enrollment(person_enrollment,course_enrollment) VALUES (?1, ?2)";	    			
		    		sesion.createNativeQuery(insert).setParameter(1, alumno).setParameter(2, flying).executeUpdate();	    				
	    		    tx.commit();
	    		    sesion.close();
	    		}
	    	}
	    }


	    sesion = sesionFactory.openSession();
	    
	    //Sacamos los alumnos en Flying
	    alumnosFlying = (long) sesion.createQuery("select count(c.person) from Course c inner join c.persons p where c.name = 'Flying'").uniqueResult();
	    System.out.println("Alumnos matriculados en Flying: " + alumnosFlying);
	    
	    sesion.close();	
	}
	public static void main(String[] args) throws IOException {
	Act3();
	}

}
