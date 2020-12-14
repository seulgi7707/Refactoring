package com.ex1.refactoring;

public class ChildrenPrice extends Price{

	@Override
	int getPriceCode() {
		return Movie.CHILDREN;
	}
	
}
