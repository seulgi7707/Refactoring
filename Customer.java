package com.ex1.refactoring;

import java.util.Enumeration;
import java.util.Vector;

// 비디오 대여점의 고객을 나타냄	
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
        //풋터(footer) 추가
        result += "Amount owed is"+String.valueOf(getTotalCharge())+"\n";
        result += "You earned" + String.valueOf(getTotalFrequentRenterPoints())+"frequent renter points";
		return result;
	}
		
	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = _rentals.elements();
		 while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			//이 대여에 대한 요금 계산결과 표시
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
		Movie movie = new Movie("조제",Movie.NEW_RELEASE);
		Rental rental = new Rental(movie, 3);
		customer.addRental(rental);
		customer.statement();
	}
}
