import java.util.Locale;
import java.util.Scanner;

public class Terreno {

	// Programa para medir a área de um terreno e seu preço
	
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira a largura do terreno: ");
		double largura = sc.nextDouble();
		System.out.println("Insira o comprimento do terreno: ");
		double comprimento = sc.nextDouble();
		System.out.println("Insira a quantidade de m² do terreno: ");
		double metroQuadrado = sc.nextDouble();

		double area = largura * comprimento;
		double preco = area * metroQuadrado;

		System.out.printf("Area: %.2f%n", area);
		System.out.printf("Preco: %.2f%n", preco);

		sc.close();

	}

}
