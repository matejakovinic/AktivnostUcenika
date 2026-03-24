public class Vizita extends Aktivnost{


    public Vizita(String naziv) {
        super(naziv,Smer.PEKAR,1,5);
    }

    @Override
    public int izracunajOcenu(double a) {
        if(a < getMinimum() || a > getMaksimum()) return 0;
        double ocena = a * 0.75 + 1.25;
        return (int)ocena;
    }
}
