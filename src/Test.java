import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {

        Dnevnik d = new Dnevnik();

        // ================= KLASE =================
        Klasa k1 = d.dodajKlasu(Smer.PEKAR, 1, 1, "Markovic");
        Klasa k2 = d.dodajKlasu(Smer.LEKAR, 2, 1, "Jovanovic");
        Klasa k3 = d.dodajKlasu(Smer.APOTEKAR, 3, 1, "Petrovic");

        // ================= AKTIVNOSTI =================
        Aktivnost a1 = d.dodajAktivnost(new RadUPekari("Rad u pekari"));
        Aktivnost a2 = d.dodajAktivnost(new Vizita("Vizita bolnici"));
        Aktivnost a3 = d.dodajAktivnost(new PraksaApoteka("Praksa u apoteci"));

        // ================= UCENICI =================
        Ucenik u1 = d.dodajUcenika("Petar", "Petrovic", "111", 1, 1, Smer.PEKAR);
        Ucenik u2 = d.dodajUcenika("Marko", "Markovic", "222", 1, 1, Smer.PEKAR);
        Ucenik u3 = d.dodajUcenika("Jovan", "Jovanovic", "333", 1, 1, Smer.PEKAR);

        // ================= BELESKE =================
        d.dodajBelesku(u1, a1, 10, "Radio hleb", 60);
        d.dodajBelesku(u1, a1, 15, "Radio peciva", 80);
        d.dodajBelesku(u1, a1, 20, "Radio kolace", 95);

        // ================= TEST =================
        System.out.println("Prosek dnevnika: " + d.prosek());
        System.out.println("Prosek klase: " + k1.prosek());

        // ================= ISPIS U FAJL =================
        d.ispisiAktivnostiUcenika(u1, "izvestaj.txt");

        System.out.println("Test zavrsen.");
    }
}