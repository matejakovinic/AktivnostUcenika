import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Comparator;

public class Dnevnik implements ImaProsek {

    private List<Beleska> beleske = new ArrayList<>();
    private List<Klasa> klase = new ArrayList<>();
    private List<Aktivnost> aktivnosti = new ArrayList<>();

    public Dnevnik() {
    }

    public Klasa dodajKlasu(Smer a,int b,int c,String d) {
        Klasa nova = new Klasa(a,b,c,d);
        for(Klasa k : klase){
            if(k.equals(nova)) return k;
        }
        klase.add(nova);
        return nova;
    }

    public List<Klasa> nadjiKlaseZaSmer(Smer smer){

        List<Klasa> rezultat = new ArrayList<>();
        for(Klasa k : klase){
            if(k.getSmer() == smer){
                rezultat.add(k);
            }
        }
        return rezultat;
    }

    public Ucenik dodajUcenika(String ime,String prezime,String jmbg,int razred,int odeljenje,Smer smer) {
        Klasa target = null;
        for (Klasa k : klase) {
            if (k.getRazred() == razred && k.getOdeljenje() == odeljenje
                    && k.getSmer() == smer) {
                target = k;
                break;
            }
        }
        if (target == null) {
            target = new Klasa(smer, razred, odeljenje, "");
            klase.add(target);
        }

        for (Ucenik u : target.getUcenici()) {
            if (u.getJmbg().equals(jmbg)) return null;
        }
        Ucenik novi = new Ucenik(ime,prezime,jmbg,target);
            target.getUcenici().add(novi);
            return novi;
    }

    public Aktivnost dodajAktivnost(Aktivnost a){
       for(Aktivnost postojeca: aktivnosti){
           if(postojeca.equals(a)){
               return postojeca;
           }
       }
       aktivnosti.add(a);
       return a;
    }

    public Beleska dodajBelesku(Ucenik ucenik, Aktivnost aktivnost, int trajanje, String opis, double brojPoena){
        if(ucenik.getKlasa().getSmer() != aktivnost.getSmer()){
            System.out.println("Ucenik ne moze ucestovati u aktivnosti (pogresan smer)");
            return null;
        }
        if(trajanje < 5){
            System.out.println("Trajanje mora trajati najmanje 5 minuta");
            return null;
        }

        Beleska b = new Beleska(ucenik,aktivnost,trajanje,opis,brojPoena,LocalDate.now());
        beleske.add(b);
        ucenik.getBeleske().add(b);
        return b;
    }

    @Override
    public double prosek() {
        double suma = 0;
        for(Beleska b : beleske){
            suma += b.getTrajanje();
        }
        return suma / beleske.size();
    }

    public void ispisiAktivnostiUcenika(Ucenik u, String fajl) {

        try {
            PrintWriter pw = new PrintWriter(fajl);

            // 1. Ime i prezime
            pw.println(u.getIme() + " " + u.getPrezime());

            if (u.getBeleske().isEmpty()) {
                pw.println("Nema zabelezenih aktivnosti");
                pw.close();
                return;
            }

            // 2. Sortiranje po datumu
            u.getBeleske().sort(Comparator.comparing(Beleska::getDatum));

            double sumaPoena = 0;
            double sumaOcena = 0;

            // 3. Ispis
            for (Beleska b : u.getBeleske()) {

                int ocena = b.getAktivnost().izracunajOcenu(b.getBrojPoena());

                pw.println(
                        b.getDatum().getDayOfMonth() + "." +
                                b.getDatum().getMonthValue() + "." +
                                b.getDatum().getYear() + " - " +
                                b.getAktivnost().getNaziv() + " - " +
                                b.getBrojPoena() + " (" + ocena + ")"
                );

                sumaPoena += b.getBrojPoena();
                sumaOcena += ocena;
            }

            // 4. Kraj
            pw.println("Ukupno poena: " + sumaPoena);
            pw.println("Prosek: " + (sumaOcena / u.getBeleske().size()));

            pw.close();

        } catch (FileNotFoundException e) {
            System.out.println("Greska pri radu sa fajlom");
        }
    }



    public List<Beleska> getBeleske() {return beleske;}

    public void setBeleske(List<Beleska> beleske) {this.beleske = beleske;}

    public List<Klasa> getKlase() {return klase;}

    public void setKlase(List<Klasa> klase) {this.klase = klase;}

    public List<Aktivnost> getAktivnosti() {return aktivnosti;}

    public void setAktivnosti(List<Aktivnost> aktivnosti) {this.aktivnosti = aktivnosti;}


}
