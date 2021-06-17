package deeperJunit;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double getAspectRatio(){
        return (double)width/height;
    }

    public boolean isSquare(){
        return width==height;
    }

    public int getArea(){
        return width*height;
    }

    public int[] getSides(){
        return new int[] {width,height};
    }

    public List<Integer> getSidesList(){
        return  asList(width, height);
    }

    public static void  willThrow() throws IOException {
        throw new IOException("Bang");
    }
}
