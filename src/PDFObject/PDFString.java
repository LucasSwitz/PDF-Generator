package PDFObject;

import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * Created by NCS Customer on 5/6/2015.
 */
public class PDFString extends PDFObject {
    private String value;
    private PDType1Font font;
    private int fontSize;

    public PDFString(String name, String value) {
        super(name);
        this.value = value;
        font = PDType1Font.HELVETICA;
        fontSize = 12;
    }

    public PDFString(String name, String value, PDType1Font font, int fontSize) {
        super(name);
        this.value = value;
        this.font = font;
        this.fontSize = fontSize;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getFontSize() {
        return fontSize;
    }

    public PDType1Font getFont() {
        return font;
    }

}
