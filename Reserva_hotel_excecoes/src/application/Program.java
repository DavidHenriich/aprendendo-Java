package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int number = sc.nextInt();
		System.out.print("Data de entrada (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de saida: (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(! checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data de saida deve ser depois da data de entrada.");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println("\nEntre com os dados para atualizar a reserva:");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de saida: (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: a atualização da reserva deve ser feita para uma data futura à atual.");
			} 
			else if(! checkOut.after(checkIn)){
				System.out.println("Erro na reserva: a data de saida deve ser depois da data de entrada.");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			}			
		}
		
		sc.close();
	}

}
