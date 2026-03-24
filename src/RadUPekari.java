public class RadUPekari extends Aktivnost{


    public RadUPekari(String naziv) {
        super(naziv,Smer.PEKAR,5,10);
    }

    @Override
    public int izracunajOcenu(double a) {
        if(a < getMinimum() || a > getMaksimum()) return 0;
        double ocena = a * 0.75 - 1.75;
        return (int)ocena;
    }
}
