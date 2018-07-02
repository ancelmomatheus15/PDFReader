package pdfReader;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public class Main {

	public static void main(String[] args) throws InvalidPasswordException, IOException {
		
		float resolucao = 300;
		String caminho = "";
		String codigo = "";
				
		for(int i = 0; i < 5; i++) {
			caminho = "C:/Users/matheus.bonfim/Documents/PDFS/Boleto.pdf";
			caminho = LoadImage.carregaImagem(caminho, resolucao);		
			codigo = imageReader.processaImagem(caminho);
			resolucao += 50;
			
			if(!(codigo.equals("codigo nao encontrado"))) {
				i = 5; //se o retorno de codigo for o codigo, o contador encerra o método
				File imagem = new File(caminho);
				imagem.delete();
				//return codigo
			}
			
			System.out.println(codigo);
			
			File imagem = new File(caminho);
			imagem.delete();
			//return codigo
		}
	}
}
