package paquete;

import java.util.List;
import java.util.Set;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Ejercicios {
	public static void Act1() {
		Configuration config = new Configuration().configure();

		SessionFactory sesionFactory = config.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session sesion = sesionFactory.openSession();
		
		List<Person> dl =  sesion.createQuery("from Person where lastName ='Potter'").getResultList();
		for(Person p:dl) {
			System.out.println(p.getFirstName()+" "+p.getLastName()+" - "+p.getHouse().getName());
		}
		
		sesion.close();
	}
	
	
	
	public static void Act2() {
		Configuration config = new Configuration().configure();

		SessionFactory sesionFactory = config.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session sesion = sesionFactory.openSession();
		
		ScrollableResults sc =  sesion.createQuery("from Person order by last_name ASC").scroll();


		while(sc.next()) {
			Person p = (Person)sc.get(0);
			System.out.println(p.getLastName()+", "+p.getFirstName());
			}
		
		Person cont =(Person) sesion.createQuery("select max(p) from Person p").uniqueResult();
		System.out.println("Numero total de estudiantes: "+cont.getId());
		
		sesion.close();
	}
	
	public static void Act3() {
		Configuration config = new Configuration().configure();
		int puntos = 0;
		SessionFactory sesionFactory = config.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session sesion = sesionFactory.openSession();
		
		List<HousePoints> listaHarry = sesion.createQuery(
				"from HousePoints h where h.personByReceiver.firstName = ?1 and h.personByReceiver.lastName = ?2").setParameter(1, "Harry").setParameter(2, "Potter").getResultList();
		for (HousePoints h : listaHarry) {
			puntos = puntos + h.getPoints();
			System.out.println(h.getPersonByGiver().getFirstName() + " " + h.getPersonByGiver().getLastName() + " -> "
					+ h.getPoints() + " puntos para " + h.getPersonByReceiver().getFirstName() + " "
					+ h.getPersonByReceiver().getLastName());
		}
		List<HousePoints> listaRon = sesion.createQuery(
				"from HousePoints h where h.personByReceiver.firstName = ?1 and h.personByReceiver.lastName = ?2").setParameter(1, "Ron").setParameter(2, "Weasley").getResultList();
		for (HousePoints h : listaRon) {
			puntos = puntos + h.getPoints();

			System.out.println(h.getPersonByGiver().getFirstName() + " " + h.getPersonByGiver().getLastName() + " -> "
					+ h.getPoints() + " puntos para " + h.getPersonByReceiver().getFirstName() + " "
					+ h.getPersonByReceiver().getLastName());
		}
		List<HousePoints> listaHermione = sesion.createQuery(
				"from HousePoints h where h.personByReceiver.firstName = ?1 and h.personByReceiver.lastName = ?2").setParameter(1, "Hermione").setParameter(2, "Granger").getResultList();
		for (HousePoints h : listaHermione) {
			puntos = puntos + h.getPoints();

			System.out.println(h.getPersonByGiver().getFirstName() + " " + h.getPersonByGiver().getLastName() + " -> "
					+ h.getPoints() + " puntos para " + h.getPersonByReceiver().getFirstName() + " "
					+ h.getPersonByReceiver().getLastName());
		}
		
		System.out.print("Puntos totales: "+puntos);
		
		
		sesion.close();
	}
	
	public static void Act4() {
		Configuration config = new Configuration().configure();

		SessionFactory sesionFactory = config.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session sesion = sesionFactory.openSession();
		
		//Con Fetch
		System.out.println("Primera Parte");
		System.out.println("");
		Course nombre1 = (Course) sesion.createQuery(
				"from Course c inner join fetch c.persons a inner join fetch c.person p where c.name = 'Potions' and a.house.name = 'Gryffindor'").uniqueResult();

		Set<Person> lista1 = nombre1.getPersons();
		
		for (Person h : lista1) {
			System.out.println(h.getFirstName()+" "+h.getLastName()+" estudia "+nombre1.getName()+" con "+ nombre1.getPerson().getFirstName()+" "+nombre1.getPerson().getLastName());
		}
		
		//Sin Fetch

		Course nombre2 = (Course) sesion.createQuery(
				"from Course c inner join fetch c.persons a inner join fetch c.person p where c.name = 'Potions' and a.house.name = 'Gryffindor'").uniqueResult();

		Set<Person> lista2 = nombre2.getPersons();
		System.out.println("");
		System.out.println("Segunda Parte");
		System.out.println("");

		for (Person h : lista2) {
			System.out.println(h.getFirstName()+" "+h.getLastName()+" estudia "+nombre2.getName()+" con "+ nombre2.getPerson().getFirstName()+" "+nombre2.getPerson().getLastName());
		}
		
		sesion.close();
	}
	
	public static void main(String[]args) {
		Act4();

	}
}
