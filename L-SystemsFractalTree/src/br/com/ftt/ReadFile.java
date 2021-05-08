package br.com.ftt;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadFile {

	public Integer etapas;
	public String axioma;
	public Double angulo;
	public String regraMod;


	public ReadFile(String fileName) {
		File file = new File(fileName);
		this.leArquivo(file);




	}
	public void leArquivo(File file) {



		try {

			Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);

			while(scanner.hasNextLine()) {

				String linha = scanner.nextLine();

				if(linha.substring(0,1).equals("Σ") )
					linha = scanner.nextLine();


				if(linha.substring(0,1).equals("n")) {	
					String[] vetor = linha.split(":");
					this.etapas = Integer.parseInt(vetor[1].trim());
				}

				if(linha.substring(0,1).equals("ω")) {
					String[] vetor = linha.split(":");
					this.axioma = vetor[1].trim();		
				}				

				if(linha.substring(0,1).equals("δ")) {
					String[] vetor = linha.split(":");
					this.angulo = Double.parseDouble(vetor[1]
							.trim()
							.replace("º", ""));
				}

				if(linha.substring(0,1).equals("p")) {
					String[] vetor = linha.split(":");  
					String regra = vetor[1].trim();

					String[] vetor2 = regra.split("→");
					this.regraMod = this.axioma.replace(vetor2[0].trim(), vetor2[1].trim());

				}


			}		

			scanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*public static void main(String[] args) {
		ReadFile rf = new ReadFile("inputFile.txt");

	}*/
}


