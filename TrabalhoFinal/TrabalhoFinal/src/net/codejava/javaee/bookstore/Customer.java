//marcelocb3005631*ifsp//

package net.codejava.javaee.bookstore;


public class Customer {
	protected int id;
	protected String cust_name;
	protected String city;
	protected float grade;

	public Customer() {
	}

	public Customer(int id) {
		this.id = id;
	}

	public Customer(int id, String cust_name, String city, float grade) {
		this(cust_name, city, grade);
		this.id = id;
	}
	
	public Customer(String cust_name, String city, float grade) {
		this.cust_name = cust_name;
		this.city = city;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCust_Name() {
		return cust_name;
	}

	public void setCust_Name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	

	
	}

}