import PDFObject.PDFImage;
import PDFObject.PDFObject;
import PDFObject.PDFStream;
import PDFObject.PDFString;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.EnumSet;

/**
 * Created by NCS Customer on 5/6/2015.
 */
public class PDFGenerator {

    //size of paper is 612, 792

    public static void main(String[] args) throws IOException, COSVisitorException {

          PDFGenerator genreator =   new PDFGenerator();

    }
    public PDFGenerator() throws IOException, COSVisitorException {



        PDDocument document = new PDDocument();

        PDPage page = new PDPage();
        document.addPage(page);


        PDFont font = PDType1Font.HELVETICA_BOLD;


        PDFStream stream = new PDFStream(document,page);
        PDFModule module = new PDFModule("Starlord",250,250,200,200);
        module.addPDFString(new PDFString("Title" ,"Hello",PDType1Font.HELVETICA,14));
        PDFImage image = (new PDFImage("Pic","C:\\Users\\NCS Customer\\Desktop\\starlord.jpg",document,100,100));
        PDFImage image2 = (new PDFImage("Pic","C:\\Users\\NCS Customer\\Desktop\\starlord.jpg",document,100,100));
        image.setLocalPosition(50,50);
        image2.setRelative(image,0,100);
        module.addPDFObject(image2);
        module.addPDFObject(image);


        stream.close();

        document.save( "Hello World.pdf");
        document.close();


    }
}
