import java.util.Locale;
import java.util.Scanner;

public class Area_Circulo {

	//Programa que calcula a area de um circulo
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		double raio, area, pi = 3.14159;
		
		System.out.print("Insira o raio do circulo: ");
		raio = sc.nextDouble();
    
		area = pi * Math.pow(raio, 2);
    
		System.out.printf("Resultado: %.4f%n", area);
		
		sc.close();

	}

}
