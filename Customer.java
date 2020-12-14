package com.ex1.refactoring;

import java.util.Enumeration;
import java.util.Vector;

// ���� �뿩���� ���� ��Ÿ��	
public class Customer {
	private String _name;
	private Vector _rentals = new Vector();
	
	public Customer(String name) {
		_name = name;
	}
	
	public void addRental (Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}
	
	
	public String statement () {
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for" + getName() + "\n";
        while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += "\t"+each.getMovie().getTitle()+"\t"+String.valueOf( each.getCharge());
        }
        //ǲ��(footer) �߰�
        result += "Amount owed is"+String.valueOf(getTotalCharge())+"\n";
        result += "You earned" + String.valueOf(getTotalFrequentRenterPoints())+"frequent renter points";
		return result;
	}
		
	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = _rentals.elements();
		 while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			//�� �뿩�� ���� ��� ����� ǥ��
			result +=  each.getCharge();
        }
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
	 	while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			
			frequentRenterPoints += each.getFrequentRenterPoints();
	    }
		return frequentRenterPoints;
	}
	
	public static void main(String[] args) {
		Customer customer = new Customer("seulgi");
		Movie movie = new Movie("����",Movie.NEW_RELEASE);
		Rental rental = new Rental(movie, 3);
		customer.addRental(rental);
		customer.statement();
	}
}
