import java.util.Locale;
import java.util.Scanner;

public class Calculo_Salario {

	//Programa que mostra o numero e calcula o salario do funcionario
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int num, hrs;
		double sal_hr, sal;
		
		System.out.print("Insira o numero do funcionario: ");
		num = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Insira o numero de horas trabalhadas: ");
		hrs = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Insira o salario por hora trabalhada: ");
		sal_hr = sc.nextDouble();
		sc.nextLine();
		
		sal = hrs * sal_hr;
		System.out.println("Number: " + num);
		System.out.printf("Salary: U$ %.2f%n", sal);

		sc.close();
				
	}

}
