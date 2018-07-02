package pdfReader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.PDFRenderer;

public class LoadImage {
	public static String carregaImagem (String caminho, float resolucao) throws InvalidPasswordException, IOException {
	//public static void main(String[]args) throws InvalidPasswordException, IOException {
		
		float dpi = resolucao;
		//float dpi = 300;
		
		//String caminho = "C:/Users/matheus.bonfim/Documents/PDFS/Boleto.pdf";
		String caminhoJPG = caminho;
		caminhoJPG = caminhoJPG.replace(".pdf", ".jpg");
		
		
		//carrega o arquivo
		File arquivo = new File(caminho);
		PDDocument document = PDDocument.load(arquivo);
			
		//instanciar a PDFRenderer
		PDFRenderer renderizar = new PDFRenderer(document);
	
		//gera a imagem do documento
		BufferedImage imagem = renderizar.renderImageWithDPI(0, dpi);
				
		//gerando o arquivo imagem
		ImageIO.write(imagem, "JPEG", new File(caminhoJPG));
	       
	    System.out.println("Imagem gerada");
	       
	    //Fecha o documento
	    document.close();
	    
	    return caminhoJPG;

	}

}
