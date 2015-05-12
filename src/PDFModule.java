import PDFObject.*;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;

import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by NCS Customer on 5/6/2015.
 */
public class PDFModule extends PDFObject{

    private HashMap<String, PDFObject> objectHashMap;
    private PDPageContentStream stream;
    private float padding;

    public PDFModule(String name, int x, int y, int height, int width) throws IOException {
        super(name);
        localX = x;
        localY = y;
        this.height = height;
        this.width = width;
        stream = PDFStream.getInstance();
        stream.addRect(x,y,width,height);
        stream.drawPolygon(new float[]{x, width}, new float[]{y, height});
        padding = 10;
        objectHashMap = new HashMap<String, PDFObject>();
    }
    public void addPDFObject(PDFObject object)
    {
        object.compensateContainerDimensions(localX, localY);

        if(!contains(object))
        {
            ErrorLogger.error("Object \"" + object.getName()+"\" not contained");
            object.setAbsoluteY(localY);
            object.setAbsoluteX(localX);
        }
        switch (object.getClass().getName())
        {
            case "PDFObject.PDFImage":
                addPDFImage((PDFImage)object);
                break;
            case "PDFObject.PDFString":
                addPDFString((PDFString)object);
                break;
            default:
                System.out.println("Invalid Object Class: "+ object.getClass().getName());
        }
    }
    public void addPDFString(PDFString string)
    {
        try {
            stream.beginText();
            stream.moveTextPositionByAmount(string.getAbsoluteX()+ padding, string.getAbsoluteY() + padding);
            stream.setFont(string.getFont(), string.getFontSize());
            stream.drawString(string.getName());
            stream.endText();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void addPDFImage(PDFImage image)
    {
        try {
            stream.drawImage(image.getImage(),image.getAbsoluteX(),image.getAbsoluteY());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void setPadding(int padding)
    {
        this.padding = padding;

    }
    public void draw()
    {

    }
    private boolean contains(PDFObject object)
    {
        if(localX < object.getAbsoluteX() + object.getWidth() &&
                localX + width > object.getAbsoluteX() &&
                localY < object.getAbsoluteY() + object.getHeight() &&
                height + localY > object.getHeight()
                ) {

            return true;
        }

        else return false;
    }
}
