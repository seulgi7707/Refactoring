package com.ex1;

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
		double totalAmount = 0;
		int frequentRentaerPoints = 0; 
		/*Enumeration �������̽�*/
			//��ü���� ����(Vector)���� ������ ��ü���� �Ѽ����� �ϳ��� ó���� �� �ִ� �޼ҵ带 �����ϴ� �̷���
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for" + getName() + "\n";
		/*boolean hasMoreElements()*/
			//Vector�� ���� ������ Enumeration�� ��Ұ� ������ true, �ƴϸ� false ��ȯ
        while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			/*Object nextElement()*/
				//Enumeration ���� ���� ��Ҹ� ��ȯ
			Rental each = (Rental) rentals.nextElement();
			
			//�� ��ȭ�� ���� ��� ����
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
			
			//����Ʈ(frequent renter points)�߰�
			frequentRentaerPoints ++;
			
			//�ֽ�(new release)�� ��Ʋ �̻� �뿩�ϴ� ��� �߰� ����Ʈ ����
			if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && (each.getDaysRented() > 1)) frequentRentaerPoints ++;
			
			//�� �뿩�� ���� ��� ����� ǥ��
			result += "\t"+each.getMovie().getTitle()+"\t"+String.valueOf(thisAmount);
			totalAmount = thisAmount;
        }
        //ǲ��(footer) �߰�
        result += "Amount owed is"+String.valueOf(totalAmount)+"\n";
        result += "You earned" + String.valueOf(frequentRentaerPoints)+"frequent renter points";
		return result;
	}
	
	public static void main(String[] args) {
		Customer customer = new Customer("seulgi");
		Movie movie = new Movie("����",Movie.NEW_RELEASE);
		Rental rental = new Rental(movie, 3);
		customer.addRental(rental);
		customer.statement();
	}
}
