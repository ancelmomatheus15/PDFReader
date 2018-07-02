package pdfReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class imageReader {
    
	public static String processaImagem (String caminho){
	//public static void main(String[]args) {
        File imagem = new File(caminho);
        BinaryBitmap binaryBitmap;
        Result result = null;
        String resultado = "";
        
        try {
            binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(imagem)))));
            
            Hashtable<DecodeHintType, Object> decodeHints = new Hashtable<>();
            decodeHints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            
            result = new MultiFormatReader().decode(binaryBitmap, decodeHints);
            
            resultado = ("Valor: " + result.getText() +"\n" + "Formato: " + result.getBarcodeFormat());
       
            
        } catch (IOException e) {
            e.printStackTrace();
        
        } catch (NotFoundException e) {
            resultado = "codigo nao encontrado";
            return resultado;            
        }
		
        return (resultado);
        
    }
}