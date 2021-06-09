package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Quantidade de Produtos: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("\nDados do produto #" + i + ":");
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char ch = sc.next().charAt(0);
			if (ch != 'c' && ch != 'C' && ch != 'u' && ch != 'U' && ch != 'i' && ch != 'I') {
				do {
					System.out.print("\nOpção invalida. \nDigite (c, u ou i):");
					ch = sc.next().charAt(0);
				}while(ch != 'c' && ch != 'C' && ch != 'u' && ch != 'U' && ch != 'i' && ch != 'I');
			}
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Preço: ");
			double price = sc.nextDouble();
			if(ch == 'c' || ch == 'C') {
				Product p = new Product(name, price);
				list.add(p);
			}
			else if(ch == 'u' || ch == 'U') {
				System.out.print("Data de fabricação (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				Product p = new UsedProduct(name, price, date);
				list.add(p);
			}
			else {
				System.out.print("Custo alfândega: ");
				double customsFree = sc.nextDouble();
				Product p = new ImportedProduct(name, price, customsFree);
				list.add(p);
			}
		}
		
		System.out.println("\nETIQUETAS DE PREÇO: ");
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
