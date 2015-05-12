package PDFObject;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by NCS Customer on 5/6/2015.
 */
public class PDFImage extends  PDFObject {
    private PDXObjectImage picture;
    private String pathToImage;
    private PDDocument document;

    public PDFImage(String name, String pathToImage, PDDocument document) {
        super(name);
        this.pathToImage = pathToImage;
        this.document = document;
        try {
            BufferedImage image = ImageIO.read(new File(pathToImage));
            this.picture = new PDJpeg(document,image);

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.height = this.picture.getHeight();
        this.width = this.picture.getWidth();
    }
    public PDFImage(String name, String pathToImage, PDDocument document, int width, int height) {
        super(name);
        this.pathToImage = pathToImage;
        this.document = document;
        try {
            BufferedImage image = ImageIO.read(new File(pathToImage));
            this.picture = new PDJpeg(document,image);

        } catch (IOException e) {
            e.printStackTrace();
        }
        resize(width,height);
    }
    public PDXObjectImage getImage()
    {
        return picture;
    }


    public void resize(int width, int height)
    {
        try {
            BufferedImage image = ImageIO.read(new File(pathToImage));
            BufferedImage resized = new BufferedImage(width, height, image.getType());
            Graphics2D g = resized.createGraphics();
            g.drawImage(image,0,0,width,height,null);
            g.dispose();
            picture = new PDJpeg(document,resized);
            this.height = height;
            this.width = width;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
