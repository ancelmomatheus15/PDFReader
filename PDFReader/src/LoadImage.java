import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.PDFRenderer;

public class LoadImage {
	//public static void carregaImagem (String caminho) throws InvalidPasswordException, IOException {
	public static void main(String[]args) throws InvalidPasswordException, IOException {
		
		//carrega o arquivo
		//File arquivo = new File(caminho);
		File arquivo = new File("C:/Users/matheus.bonfim/Documents/PDFS/Boleto.pdf");
		PDDocument document = PDDocument.load(arquivo);
	
		//instanciar a PDFRenderer
		PDFRenderer renderizar = new PDFRenderer(document);
	
		//gera a imagem do documento
		BufferedImage imagem = renderizar.renderImage(0);
		
		//gerando o arquivo imagem
		ImageIO.write(imagem, "JPEG", new File("C:/Users/matheus.bonfim/Documents/PDFS/Boleto.jpg"));
	       
	    System.out.println("Image created");
	       
	    //Fecha o documento
	    document.close();

	}

}
