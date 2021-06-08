package application;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com a pasta: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		//Para filtrar as pastas
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("\nPASTAS:");
		for(File folder : folders) {
			System.out.println(folder);
		}
		
		//Para filtrar os arquivos
		File[] files = path.listFiles(File::isFile);
		System.out.println("\nARQUIVOS:");
		for(File file : files) {
			System.out.println(file);
		}
		
		//criação de pastas
		System.out.print("\nPasta a ser criada: ");
		String f = sc.nextLine();
		new File(strPath + "\\" + f).mkdir();
		System.out.println("Diretorio criado com sucesso! ");
		
		sc.close();
	}

}
