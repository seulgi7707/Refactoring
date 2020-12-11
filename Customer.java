package com.ex1;

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
		double totalAmount = 0;
		int frequentRentaerPoints = 0; 
		/*Enumeration 인터페이스*/
			//객체들의 집합(Vector)에서 각각의 객체들을 한순간에 하나씩 처리할 수 있는 메소드를 제공하는 켈렉션
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for" + getName() + "\n";
		/*boolean hasMoreElements()*/
			//Vector로 부터 생성된 Enumeration의 요소가 있으면 true, 아니면 false 반환
        while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			/*Object nextElement()*/
				//Enumeration 내의 다음 요소를 반환
			Rental each = (Rental) rentals.nextElement();
			
			//각 영화에 대한 요금 결정
			switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount +=2;
				if(each.getDaysRented() >2) thisAmount += (each.getDaysRented()-2)*1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented()*3;
				break;
			case Movie.CHILDREN:
				thisAmount += 1.5;
				if(each.getDaysRented() >3) thisAmount += (each.getDaysRented()-3)*1.5;
				break;
			}
			
			//포인트(frequent renter points)추가
			frequentRentaerPoints ++;
			
			//최신(new release)을 이틀 이상 대여하는 경우 추가 포인트 제공
			if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && (each.getDaysRented() > 1)) frequentRentaerPoints ++;
			
			//이 대여에 대한 요금 계산결과 표시
			result += "\t"+each.getMovie().getTitle()+"\t"+String.valueOf(thisAmount);
			totalAmount = thisAmount;
        }
        //풋터(footer) 추가
        result += "Amount owed is"+String.valueOf(totalAmount)+"\n";
        result += "You earned" + String.valueOf(frequentRentaerPoints)+"frequent renter points";
		return result;
	}
	
	public static void main(String[] args) {
		Customer customer = new Customer("seulgi");
		Movie movie = new Movie("조제",Movie.NEW_RELEASE);
		Rental rental = new Rental(movie, 3);
		customer.addRental(rental);
		customer.statement();
	}
}
