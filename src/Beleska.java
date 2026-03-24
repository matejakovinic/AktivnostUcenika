import java.time.LocalDate;

public class Beleska {

    private int trajanje;
    private String opis;
    private double brojPoena;
    private Aktivnost aktivnost;
    private Ucenik ucenik;
    private LocalDate datum;

    public Beleska(Ucenik ucenik,Aktivnost aktivnost,int trajanje,String opis,double brojPoena,LocalDate datum) {
        this.trajanje = trajanje;
        this.opis = opis;
        this.brojPoena = brojPoena;
        this.aktivnost = aktivnost;
        this.ucenik = ucenik;
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Beleska{" + "trajanje=" + trajanje + ", opis='" + opis  + ", brojPoena=" + brojPoena + ", aktivnost=" + aktivnost + ", ucenik=" + ucenik + '}';
    }

    public int getTrajanje() {return trajanje;}
    public void setTrajanje(int trajanje) {this.trajanje = trajanje;}

    public String getOpis() {return opis;}
    public void setOpis(String opis) {this.opis = opis;}

    public double getBrojPoena() {return brojPoena;}
    public void setBrojPoena(double brojPoena) {this.brojPoena = brojPoena;}

    public Aktivnost getAktivnost() {return aktivnost;}
    public void setAktivnost(Aktivnost aktivnost) {this.aktivnost = aktivnost;}

    public Ucenik getUcenik() {return ucenik;}
    public void setUcenik(Ucenik ucenik) {this.ucenik = ucenik;}

    public LocalDate getDatum() {return datum;}
    public void setDatum(LocalDate datum) {this.datum = datum;}
}
