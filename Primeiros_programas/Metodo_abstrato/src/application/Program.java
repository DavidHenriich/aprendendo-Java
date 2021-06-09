package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Shape> list = new ArrayList<>();
		
		System.out.print("Entre um número de figuras: ");
		int n =  sc.nextInt();
		
		for(int i = 1; i<= n; i++) {
			System.out.println("\nDados da figura #" + i + ":");
			System.out.print("Retangulo ou circulo (r/c)? ");
			char ch = sc.next().charAt(0);
			if(ch != 'R' && ch != 'r' && ch != 'c' && ch != 'C') {
				do {
				System.out.println("\nOpção invalida, tente novamente! \n(r/c)?");
				ch = sc.next().charAt(0);
				}while(ch != 'R' && ch != 'r' && ch != 'c' && ch != 'C');
				System.out.println();
			}
			System.out.print("Cor (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.next());
			if(ch == 'r' || ch == 'R') {
				System.out.print("Largura: ");
				double width = sc.nextDouble();
				System.out.print("altura: ");
				double height = sc.nextDouble();
				
				list.add(new Rectangle(color, width, height));
			}else {
				System.out.print("Raio: ");
				double radius = sc.nextDouble();
				
				list.add(new Circle(color, radius));
			}
		}
		
		System.out.println("\nAREAS DAS FIGURAS:");
		for(Shape shape : list) {
			System.out.println(String.format("%.2f", shape.area()));
		}
		
		sc.close();
	}

}
