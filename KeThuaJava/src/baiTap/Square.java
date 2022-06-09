package baiTap;

public class Square extends Shape  {
    public double size;

    public Square() {
    }
    public Square(double size){
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    public double getArea(){
        return size * size;
    }
}
