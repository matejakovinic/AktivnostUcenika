import java.util.Objects;

public abstract class Aktivnost {

    private String naziv;
    private double minimum;
    private double maksimum;
    private Smer smer;

    public Aktivnost(String naziv,Smer smer,double minimum, double maksimum) {
        this.naziv = naziv;
        this.minimum = minimum;
        this.maksimum = maksimum;
        this.smer = smer;
    }

    public Aktivnost(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aktivnost aktivnost = (Aktivnost) o;
        return Double.compare(minimum, aktivnost.minimum) == 0 && Double.compare(maksimum, aktivnost.maksimum) == 0 && Objects.equals(naziv, aktivnost.naziv) && smer == aktivnost.smer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv, minimum, maksimum, smer);
    }

    public abstract int izracunajOcenu(double a);

    public String getNaziv() {return naziv;}
    public void setNaziv(String naziv) {this.naziv = naziv;}

    public double getMinimum() {return minimum;}
    public void setMinimum(double minimum) {this.minimum = minimum;}

    public double getMaksimum() {return maksimum;}
    public void setMaksimum(double maksimum) {this.maksimum = maksimum;}

    public Smer getSmer() {return smer;}
    public void setSmer(Smer smer) {this.smer = smer;}
}
