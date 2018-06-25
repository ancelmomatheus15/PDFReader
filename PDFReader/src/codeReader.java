import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class codeReader {
    
	//public static String processaImagem (){
	public static void main(String[]args) {
        File imagem = new File("C:/Users/matheus.bonfim/Documents/PDFS/testQR.jpeg");
        BinaryBitmap binaryBitmap;
        Result result = null;
        
        try {
            binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(imagem)))));
            result = new MultiFormatReader().decode(binaryBitmap);
            System.out.println(result.getText());
       
        } catch (IOException e) {
            e.printStackTrace();
        
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
		
        //return (result.getText());
        
    }
}