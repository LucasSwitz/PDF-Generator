package PDFObject;

import java.util.EnumSet;

/**
 * Created by NCS Customer on 5/6/2015.
 */
public abstract class PDFObject {

    private String name;
    protected int absoluteX, absoluteY;
    protected int localX, localY;
    protected int height, width;

    public enum Flag
    {
        FLAG1,
        FLAG2

    };
    public PDFObject(String name) {
        this.name = name;
        absoluteX = absoluteY = localY = localX =  0;
    }

    public void setRelative(PDFObject friend, int pixelsX,int pixelsY)
    {
        localX = friend.getLocalX() + pixelsX;
        localY = friend.getLocalY() + pixelsY;
    }
    public String getName() {
        return name;
    }
    public void setFlags(EnumSet<Flag> flags)
    {
        for(Flag flag : flags)
        {

        }
    }
    public int getAbsoluteX(){return absoluteX;}
    public int getAbsoluteY(){return absoluteY;}
    public int getLocalX(){return localX;}
    public int getLocalY(){return localY;}

    public void setAbsoluteX(int x){absoluteX = x;}
    public void setAbsoluteY(int y) {absoluteY = y;}
    public void compensateContainerDimensions(int x , int y){
        absoluteX = x + localX;
        absoluteY = y + localY;
    }
    public void setLocalX(int x){localX = x;}
    public void setLocalY(int y){localY = y;}
    public void setLocalPosition(int x, int y)
    {
        setLocalX(x);
        setLocalY(y);
    }
    public int getHeight(){return  height;}
    public int getWidth(){return width;}
}
