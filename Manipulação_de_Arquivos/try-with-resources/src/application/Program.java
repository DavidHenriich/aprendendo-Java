package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
	
		String path = "C:\\Users\\Hp\\Desktop\\Projetos\\ws_eclipse\\Java Intermediario\\ler-arquivo-file\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error " + e.getMessage());
		}
	}
}
