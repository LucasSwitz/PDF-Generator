package PDFObject;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;

import java.io.IOException;

/**
 * Created by NCS Customer on 5/6/2015.
 */
public class PDFStream extends PDPageContentStream {

    private static PDFStream instance;
    public PDFStream(PDDocument document, PDPage sourcePage) throws IOException {
        super(document, sourcePage);
        instance = this;
    }
    public static PDFStream getInstance()
    {
        return instance;
    }
}
