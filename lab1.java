/**
 * Lab0: Leitura de Base de Dados N�o-Distribuida
 * 
 * Autor: Lucio A. Rocha
 * Ultima atualizacao: 20/02/2023
 * 
 * Referencias: 
 * https://docs.oracle.com/javase/tutorial/essential/io
 * 
 */

import java.io.*;
import java.lang.reflect.TypeVariable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Principal_v0 {

	public final static Path path = Paths			
			.get("src\\fortune-br.txt");
	private int NUM_FORTUNES = 0;

	public class FileReader {

		public int countFortunes() throws FileNotFoundException {

			int lineCount = 0;

			InputStream is = new BufferedInputStream(new FileInputStream(
					path.toString()));
			try (BufferedReader br = new BufferedReader(new InputStreamReader(
					is))) {

				String line = "";
				while (!(line == null)) {

					if (line.equals("%"))
						lineCount++;

					line = br.readLine();

				}// fim while

				System.out.println(lineCount);
			} catch (IOException e) {
				System.out.println("SHOW: Excecao na leitura do arquivo.");
			}
			return lineCount;
		}

		public void parser(HashMap<Integer, String> hm)
				throws FileNotFoundException {

			InputStream is = new BufferedInputStream(new FileInputStream(
					path.toString()));
			try (BufferedReader br = new BufferedReader(new InputStreamReader(
					is))) {

				int lineCount = 0;

				String line = "";
				while (!(line == null)) {

					if (line.equals("%"))
						lineCount++;

					line = br.readLine();
					StringBuffer fortune = new StringBuffer();
					while (!(line == null) && !line.equals("%")) {
						fortune.append(line + "\n");
						line = br.readLine();
						// System.out.print(lineCount + ".");
					}

					hm.put(lineCount, fortune.toString());
					System.out.println(fortune.toString());

					System.out.println(lineCount);
				}// fim while

			} catch (IOException e) {
				System.out.println("SHOW: Excecao na leitura do arquivo.");
			}
		}

		public void read(HashMap<Integer, String> hm) throws FileNotFoundException {
			// Abrir o arquivo para leitura
			///File file = new File("src\\fortune-br.txt");
			///Scanner scanner = new Scanner(file);
		
			// Ler as linhas do arquivo e armazenar no mapa
			///int lineNumber = 1;
			///while (scanner.hasNextLine()) {
			///	String line = scanner.nextLine();
			///	hm.put(lineNumber, line);
			///	lineNumber++;
			///}
		
			// Fechar o scanner
			///scanner.close();
			//////////tentando de novo/////
			for (Integer chave : hm.keySet()) {
				String valor = hm.get(chave);
				Integer aux = Integer.parseInt(valor);
				boolean x = false;
				if(aux == 1 || aux == 2 || aux == 3 || aux == 4 || aux == 5 || aux == 6 || aux == 7 || aux == 8 || aux == 9 || aux == 0 ){
					System.out.println(valor);
					x = true;
				}
				if(valor != "%"){
					System.out.println(valor);
				}else if(valor == "%" && x == true){
					System.out.println(valor);
				}else{
					System.exit(0);
				}
				
			}
			
		}

		public void write(HashMap<Integer, String> hm) throws FileNotFoundException {
			// Abrir o arquivo para escrita
			///PrintWriter writer = new PrintWriter("src\\fortune-br.txt");

			///for (Integer key : hm.keySet()) {
        	///	writer.println(key + ": " + hm.get(key));
    		///}

			//writer.println("%\nEu sou a Mariana e estou tentando fazer este exercicio\n%");
		
			// Fechar o escritor
			///writer.close();
			//////tentando de novo//////
			Scanner scanner = new Scanner(System.in);
	
			System.out.println("Digite uma chave inteira seguida de um valor de string:");
	
			int chave = scanner.nextInt();
			String valor = scanner.next();
	
			hm.put(chave, valor);
			
		}
	}

	public void iniciar() {

		FileReader fr = new FileReader();
		try {
			NUM_FORTUNES = fr.countFortunes();
			HashMap hm = new HashMap<Integer, String>();
			fr.parser(hm);
			fr.read(hm);
			fr.write(hm);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Principal_v0().iniciar();
	}

}
