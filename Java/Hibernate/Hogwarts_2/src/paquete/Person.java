package paquete;
// Generated 1 ene 2022 15:48:48 by Hibernate Tools 5.4.32.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Person generated by hbm2java
 */
public class Person implements java.io.Serializable {

	private int id;
	private House house;
	private String firstName;
	private String lastName;
	private Set houses = new HashSet(0);
	private Set courses = new HashSet(0);
	private Set housePointsesForGiver = new HashSet(0);
	private Set courses_1 = new HashSet(0);
	private Set housePointsesForReceiver = new HashSet(0);

	public Person() {
	}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person(int id, House house, String firstName, String lastName, Set houses, Set courses,
			Set housePointsesForGiver, Set courses_1, Set housePointsesForReceiver) {
		this.id = id;
		this.house = house;
		this.firstName = firstName;
		this.lastName = lastName;
		this.houses = houses;
		this.courses = courses;
		this.housePointsesForGiver = housePointsesForGiver;
		this.courses_1 = courses_1;
		this.housePointsesForReceiver = housePointsesForReceiver;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set getHouses() {
		return this.houses;
	}

	public void setHouses(Set houses) {
		this.houses = houses;
	}

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

	public Set getHousePointsesForGiver() {
		return this.housePointsesForGiver;
	}

	public void setHousePointsesForGiver(Set housePointsesForGiver) {
		this.housePointsesForGiver = housePointsesForGiver;
	}

	public Set getCourses_1() {
		return this.courses_1;
	}

	public void setCourses_1(Set courses_1) {
		this.courses_1 = courses_1;
	}

	public Set getHousePointsesForReceiver() {
		return this.housePointsesForReceiver;
	}

	public void setHousePointsesForReceiver(Set housePointsesForReceiver) {
		this.housePointsesForReceiver = housePointsesForReceiver;
	}

}
