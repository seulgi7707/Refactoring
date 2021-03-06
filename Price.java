package com.ex1.refactoring;

abstract class Price {
	
	abstract int getPriceCode();
	
	public double getCharge(int daysRented) {
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
	}

	
}
