//marcelocb3005631*ifsp//

package net.codejava.javaee.bookstore;


public class Order {
	protected int id;
	protected String order_no;
	protected String purch_amt;
	protected float order_date;

	public Order() {
	}

	public Order(int id) {
		this.id = id;
	}

	public Order(int id, String cust_name, String purch_amt, float order_date) {
		this(cust_name, purch_amt, order_date);
		this.id = id;
	}
	
	public Order(String cust_name, String purch_amt, float order_date) {
		this.order_no= order_no;
		this.purch_amt = purch_amt;
		this.order_date = order_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCust_Name() {
		return order_no;
	}

	public void setName(String cust_name) {
		this.order_no= cust_name;
	}

	public String getCity() {
		return purch_amt;
	}

	public void setCity(String purch_amt) {
		this.purch_amt = purch_amt;
	}

	public float getGrade() {
		return order_date;
	}

	public void setGrade(float order_date) {
		this.order_date = order_date;
	

	
	}

}