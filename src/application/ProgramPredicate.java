package application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.Product;
import util.ProductPredicate;

public class ProgramPredicate {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		System.out.println();
		System.out.println("===========PREDICATE UTILIZANDO REMOVEIF=================================");
		System.out.println();
		System.out.println("Fazer um programa que, a partir de uma lista de produtos, remova da");
		System.out.println("lista somente aqueles cujo preço mínimo seja 100.");
		System.out.println("Product('Tv', 900.00)");
		System.out.println("Product('Mouse', 50.00)");
		System.out.println("Product('Tablet', 350.50)");
		System.out.println("Product('HD Case', 80.90)");
		System.out.println();
		
		for (int i=1; i < 6; i++) { 	
			
			list.add(new Product("Tv", 900.00));
			list.add(new Product("Tablet", 350.50));
			
			if (i == 1) { 
				System.out.println(); 
				System.out.println("===========Implementação da interface=============================");
								
				list.removeIf(new ProductPredicate());
			} else if (i == 2) { 
				System.out.println();
				System.out.println("===========Reference method com método estático==================");
								
				list.removeIf(Product::staticProductPredicate);
			} else if (i == 3) {
				System.out.println();
				System.out.println("===========Reference method com método não estático==============");
								
				list.removeIf(Product::nonStaticProductPredicate);
			} else if (i == 4) {
				System.out.println();
				System.out.println("===========Expressão lambda declarada============================");
			
				double min = 100.0;
				
				Predicate<Product> pred = p -> p.getPrice() >= min;
				
				list.removeIf(pred); 
			} else { 
				System.out.println();
				System.out.println("===========Expressão lambda inline===============================");
								
				double min = 100.0;
				
				list.removeIf(p -> p.getPrice() >= min); 
			}		
	
			for (Product p : list) {
				System.out.println(p);
			}
		}
	}
}
