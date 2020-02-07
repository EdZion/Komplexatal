import java.util.Objects;
import static java.lang.Math.atan;

/*
Alexander holmström
2020-01-31
*/
public class Komplex{ //Skapar variabler för Komplexatalen
    private double re;
    private double im;

    public Komplex(double re, double im) { // Skapar Komplexatal
        this.re = re;
        this.im = im;
    }

    @Override
    public String toString() { // Gör så att man kan skriva ut komplexatalen
        return "re=" + re +
                "+ im=" + im +
                'i';
    }

    @Override
    public boolean equals(Object o) { //Gör så att man kan kolla olika komplexatal med varandra.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Komplex komplex = (Komplex) o;
        return Double.compare(komplex.re, re) == 0 &&
                Double.compare(komplex.im, im) == 0;
    }

    @Override
    public int hashCode() { // den sparar en hashkod för ditt komplexatal
        return Objects.hash(re, im);
    }

    public static void main(String[] args) { // tester så att det funkar
        Komplex A = new Komplex (3 ,2); // skapar Komplexatalet 3+2i
        Komplex B = new Komplex(4,1); // skapar Komplexatalet 4+1i
        Komplex C = A.add(B); // adderar komplexatalen med varandra
        Komplex D = new Komplex(7,3); // skapar Komplexatalet 7+3i för att kolla om dem är lika varandra
        if (C.equals(D)) { // kollar att dem är lika varandra
            System.out.println("Add funkar!!");
        } else {
            System.out.println("Add funkar inte!!");
        }
        double F = arg(A); // kollar argumentet för ett komplexttal
        System.out.println(F); // skriver ut svaret i radianer
        Komplex E = A.multiply(B); // multiplicerar ett komplextal
        System.out.println(E); // skriver ut svaret av dem två multiplicerade talen

    }

    private static double arg(Komplex A) { // Räknar ut vinkeln av ett komplextal i radianer
        double arg;
        double C = A.im/A.re;
        arg = atan(C);
        return arg;
    }

    private Komplex multiply(Komplex B) { // multiplicerar två komplexatal
        double a= re*B.re;
        double b= im*B.im;
        double c= im*B.re;
        double d= re*B.im;
        double re = a-b;
        double im = c+d;
        return new Komplex(re , im);
    }

    private Komplex add(Komplex B) { // adderar två komplexatal med varandra
        double newre = re+B.re;
        double newim = im+B.im;
        return new Komplex(newre, newim);
    }
}
