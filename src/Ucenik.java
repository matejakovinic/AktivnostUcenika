import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ucenik {

    private String ime;
    private String prezime;
    private String jmbg;
    private List<Beleska> beleske = new ArrayList<>();
    private Klasa klasa;

    public Ucenik(String ime, String prezime, String jmbg, Klasa klasa) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.klasa = klasa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ucenik ucenik = (Ucenik) o;
        return Objects.equals(ime, ucenik.ime) && Objects.equals(prezime, ucenik.prezime) && Objects.equals(jmbg, ucenik.jmbg) && Objects.equals(beleske, ucenik.beleske) && Objects.equals(klasa, ucenik.klasa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, prezime, jmbg, beleske, klasa);
    }

    @Override
    public String toString() {
        return "Ucenik{" + "ime='" + ime + '\'' + ", prezime='" + prezime + '\'' + ", jmbg='" + jmbg + '\'' + '}';
    }

    public String getIme() {return ime;}
    public void setIme(String ime) {this.ime = ime;}

    public String getPrezime() {return prezime;}
    public void setPrezime(String prezime) {this.prezime = prezime;}

    public String getJmbg() {return jmbg;}
    public void setJmbg(String jmbg) {this.jmbg = jmbg;}

    public List<Beleska> getBeleske() {return beleske;}
    public void setBeleske(List<Beleska> beleske) {this.beleske = beleske;}

    public Klasa getKlasa() {return klasa;}
    public void setKlasa(Klasa klasa) {this.klasa = klasa;}
}
