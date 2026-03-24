import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klasa implements ImaProsek{


    private int razred;
    private int odeljenje;
    private String razredniStaresina;
    private Smer smer;
    private List<Ucenik> ucenici = new ArrayList<>();

    public Klasa(Smer smer, int razred, int odeljenje, String razredniStaresina) {
        this.smer = smer;
        this.razred = razred;
        this.odeljenje = odeljenje;
        this.razredniStaresina = razredniStaresina;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Klasa klasa = (Klasa) o;
        return razred == klasa.razred && odeljenje == klasa.odeljenje && Objects.equals(razredniStaresina, klasa.razredniStaresina) && smer == klasa.smer && Objects.equals(ucenici, klasa.ucenici);
    }

    @Override
    public int hashCode() {
        return Objects.hash(razred, odeljenje, razredniStaresina, smer, ucenici);
    }

    @Override
    public double prosek(){
        int ukupnoBeleski = 0;
        for(Ucenik u : ucenici){
            ukupnoBeleski += u.getBeleske().size();
        }
        return (double)ukupnoBeleski/ ucenici.size();
    }

    @Override
    public String toString() {
        return "Klasa{" + "razred=" + razred + ", odeljenje=" + odeljenje + ", smer=" + smer + '}';
    }

    public int getRazred() {return razred;}
    public void setRazred(int razred) {this.razred = razred;}

    public int getOdeljenje() {return odeljenje;}
    public void setOdeljenje(int odeljenje) {this.odeljenje = odeljenje;}

    public String getRazredniStaresina() {return razredniStaresina;}
    public void setRazredniStaresina(String razredniStaresina) {this.razredniStaresina = razredniStaresina;}

    public Smer getSmer() {return smer;}
    public void setSmer(Smer smer) {this.smer = smer;}

    public List<Ucenik> getUcenici() {return ucenici;}
    public void setUcenici(List<Ucenik> ucenici) {this.ucenici = ucenici;}
}
