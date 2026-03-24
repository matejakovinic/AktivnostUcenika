public class PraksaApoteka extends Aktivnost{


    public PraksaApoteka(String naziv) {
        super(naziv,Smer.APOTEKAR,0,100);
    }

    @Override
    public int izracunajOcenu(double poeni) {
        if (poeni <= 52) return 1;
        int ocena = 1 + (int)((poeni - 52) / 12);

        if(ocena > 5) ocena = 5;
        return ocena;

        /*  ova metoda moze i ovako
        if(poeni <=52) return 1;
           else if(poeni <= 64) return 2;
           else if(poeni <= 76) return 3;
           else if(poeni <= 88) return 4;
           else return 5;
         */
    }
}
