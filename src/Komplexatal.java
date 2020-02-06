/*
Alexander holmström

*/
public class Komplexatal {
    private double im;
    private double re;

    public Komplexatal(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static void main(String[] args) {
        Komplexatal A = new Komplexatal (3 ,2);
        Komplexatal B = new Komplexatal(4,1);
        Komplexatal C = A.add(B);
        Komplexatal D = A.multiply(B);
    }

    private Komplexatal multiply(Komplexatal B) {
        double a= re*B.re;
        double b= im*B.im;
        double c= im*B.re;
        double d= re*B.im;
        double re = a-b;
        double im = c+d;
        return new Komplexatal(re , im);
    }

    private Komplexatal add(Komplexatal B) {
        double newre = re+B.re;
        double newim = im+B.im;
        return new Komplexatal(newre, newim);
    }

}
