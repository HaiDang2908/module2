public class HinhChuNhat {

    double width , height;
    public HinhChuNhat() {
    }
    public HinhChuNhat(double width,double height){
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        return this.width * this.height;
    }
    public double getChuVi(){
        return (this.width + this.height)*2;
    }


}
