package com.ex1.refactoring;

//단순한 데이터 클래스
public class Movie {
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String _title;
	private Price _price;
	
	public int getPriceCode(int daysRented) {
		return _price.getPriceCode(daysRented);
	}

	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR:
			_price = new RegularPrice();
			break;
		case CHILDREN:
			_price = new ChildrenPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}
/*	public double getCharge(int daysRented) {
		double result = 0;
		//각 영화에 대한 요금 결정
		switch (getPriceCode()) {
		case Movie.REGULAR:
			result +=2;
			if(daysRented >2) result += (daysRented-2)*1.5;
			break;
		case Movie.NEW_RELEASE:
			result += daysRented*3;
			break;
		case Movie.CHILDREN:
			result += 1.5;
			if(daysRented >3) result += (daysRented-3)*1.5;
			break;
		}
		return result;
	}*/
	
	

	public int getFrequentRenterPoints(int daysRented) {
		if( (getPriceCode() == NEW_RELEASE) && daysRented > 1) 
			return 2;
		else
			return 1;
	}
}
