package Conversion.ConversionPDF;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
 
public class Docx2PdfConversion {
 
 public static void main(String[] args) {
 try (InputStream is = new FileInputStream(new File("CoverLetter.docx"));
 OutputStream out = new FileOutputStream(new File("converted.pdf"));) {
 long start = System.currentTimeMillis();
 // 1) Load DOCX into XWPFDocument
 XWPFDocument document = new XWPFDocument(is);
 // 2) Prepare Pdf options
 PdfOptions options = PdfOptions.create();
 // 3) Convert XWPFDocument to Pdf
 PdfConverter.getInstance().convert(document, out, options);
 System.out.println("class.docx was converted to a PDF file in :: "
 + (System.currentTimeMillis() - start) + " milli seconds");
 } catch (Throwable e) {
 e.printStackTrace();
 }
 }
}