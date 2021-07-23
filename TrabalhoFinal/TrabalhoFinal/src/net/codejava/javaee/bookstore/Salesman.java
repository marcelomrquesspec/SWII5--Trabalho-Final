//marcelocb3005631*ifsp//

package net.codejava.javaee.bookstore;


public class Salesman {
	protected int id;
	protected String name;
	protected String city;
	protected float commission;

	public Salesman() {
	}

	public Salesman(int id) {
		this.id = id;
	}

	public Salesman(int id, String name, String city, float commission) {
		this(name, city, commission);
		this.id = id;
	}
	
	public Salesman(String name, String city, float commission) {
		this.name = name;
		this.city = city;
		this.commission = commission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		this.commission = commission;
	}

	public float getCommission1() {
		// TODO Auto-generated method stub
		return 0;
	}

}