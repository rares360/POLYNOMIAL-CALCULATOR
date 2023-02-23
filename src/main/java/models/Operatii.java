package models;

import java.util.ArrayList;
import java.util.List;

public class Operatii {

    public static Polinom adunarePolinom(Polinom polinom1, Polinom polinom2) {
        Polinom rezultatPolinom = new Polinom();
        int i = 0, j = 0;
        while (i < polinom1.getPolinom().size() && j < polinom2.getPolinom().size()) {
            if (polinom1.getPolinom().get(i).getExponent() > polinom2.getPolinom().get(j).getExponent()) {
                Monom monom = new Monom(polinom1.getPolinom().get(i).getCoeficient(), polinom1.getPolinom().get(i).getExponent());
                rezultatPolinom.addPolinom(monom);
                i++;
            } else if (polinom1.getPolinom().get(i).getExponent() < polinom2.getPolinom().get(j).getExponent()) {
                Monom monom = new Monom(polinom2.getPolinom().get(j).getCoeficient(), polinom2.getPolinom().get(j).getExponent());
                rezultatPolinom.addPolinom(monom);
                j++;
            } else if (polinom1.getPolinom().get(i).getExponent() == polinom2.getPolinom().get(j).getExponent()) {
                Monom monom = new Monom(polinom1.getPolinom().get(i).getCoeficient() + polinom2.getPolinom().get(j).getCoeficient(), polinom1.getPolinom().get(i).getExponent());
                rezultatPolinom.addPolinom(monom);
                i++;
                j++;
            }
        }
        while (i < polinom1.getPolinom().size()) {
            Monom temp = new Monom(polinom1.getPolinom().get(i).getCoeficient(), polinom1.getPolinom().get(i).getExponent());
            rezultatPolinom.addPolinom(temp);
            i++;
        }
        while (j < polinom2.getPolinom().size()) {
            Monom temp = new Monom(polinom2.getPolinom().get(j).getCoeficient(), polinom2.getPolinom().get(j).getExponent());
            rezultatPolinom.addPolinom(temp);
            j++;
        }
            return rezultatPolinom;
    }
    public static Polinom scaderePolinom(Polinom polinom1, Polinom polinom2) {
        Polinom rezultatPolinom = new Polinom();
        int i = 0, j = 0;
        while (i < polinom1.getPolinom().size() && j < polinom2.getPolinom().size()) {
            if (polinom1.getPolinom().get(i).getExponent() > polinom2.getPolinom().get(j).getExponent()) {
                Monom monom = new Monom(polinom1.getPolinom().get(i).getCoeficient(), polinom1.getPolinom().get(i).getExponent());
                rezultatPolinom.addPolinom(monom);
                i++;
            } else if (polinom1.getPolinom().get(i).getExponent() < polinom2.getPolinom().get(j).getExponent()) {
                Monom monom = new Monom((-1) * polinom2.getPolinom().get(j).getCoeficient(), polinom2.getPolinom().get(j).getExponent());
                rezultatPolinom.addPolinom(monom);
                j++;
            } else if (polinom1.getPolinom().get(i).getExponent() == polinom2.getPolinom().get(j).getExponent()) {
                Monom monom = new Monom(polinom1.getPolinom().get(i).getCoeficient() - polinom2.getPolinom().get(j).getCoeficient(), polinom1.getPolinom().get(i).getExponent());
                rezultatPolinom.addPolinom(monom);
                i++;
                j++;
            }
        }
            while (i < polinom1.getPolinom().size()) {
                Monom temp = new Monom(polinom1.getPolinom().get(i).getCoeficient(), polinom1.getPolinom().get(i).getExponent());
                rezultatPolinom.addPolinom(temp);
                i++;
            }
            while (j < polinom2.getPolinom().size()) {
                Monom temp = new Monom((-1)*polinom2.getPolinom().get(j).getCoeficient(), polinom2.getPolinom().get(j).getExponent());
                rezultatPolinom.addPolinom(temp);
                j++;
            }
        return rezultatPolinom;
    }
    public static Polinom inmultirePolinom(Polinom polinom1, Polinom polinom2) {
        Polinom rezultatPolinom = new Polinom();
        for (Monom i:polinom1.getPolinom()) {
            for (Monom j:polinom2.getPolinom()) {
                Monom monom = new Monom(i.getCoeficient() * j.getCoeficient(), i.getExponent() + j.getExponent());
                rezultatPolinom.addPolinom(monom);
            }
        }
        return rezultatPolinom;
    }
    public static Polinom derivarePolinom(Polinom polinom1) {
        Polinom rezultatPolinom = new Polinom();
        for (Monom i:polinom1.getPolinom()) {
            if (i.getExponent() >0) {
                Monom monom = new Monom(i.getCoeficient() * i.getExponent(), i.getExponent() - 1);
                rezultatPolinom.addPolinom(monom);
            } else {
                Monom monom = new Monom(0, 0);
                rezultatPolinom.addPolinom(monom);
            }
        }
        return rezultatPolinom;
    }
    public static List<Polinom> impartirePolinom(Polinom polinom1, Polinom polinom2) {
        Polinom catPolinom = new Polinom();
        List<Polinom> rezultatPolinom=new ArrayList<Polinom>();

        Polinom d=new Polinom();
        Polinom i=new Polinom();
        clonaPolinom(polinom1,d);
        clonaPolinom(polinom2,i);

        while(d.getPolinom().get(0).getExponent()>=i.getPolinom().get(0).getExponent()){
            Monom md=d.getPolinom().get(0);
            Monom mi=i.getPolinom().get(0);
            Monom mc=new Monom(mi.getCoeficient()/md.getCoeficient(),mi.getExponent()-md.getExponent());

            Polinom auxiliar=new Polinom();
            auxiliar.addPolinom(mc);

            rezultatPolinom.get(0).addPolinom(mc);

            Polinom inmultire=inmultirePolinom(i,auxiliar);
            d=scaderePolinom(d,inmultire);
        }
        rezultatPolinom.add(1,d);
        return rezultatPolinom;
    }
    public static Polinom integrarePolinom(Polinom polinom1) {
        Polinom rezultatPolinom = new Polinom();
        for (Monom i:polinom1.getPolinom()) {
            if(i.getExponent()==0){
                Monom monom=new Monom(1,1);
                rezultatPolinom.addPolinom(monom);
            }else if(i.getExponent()!=0){
                Monom monom=new Monom(i.getCoeficient()/(i.getExponent()+1),i.getExponent()+1);
                rezultatPolinom.addPolinom(monom);
            }
        }
        return rezultatPolinom;
    }
    public static void clonaPolinom(Polinom polinom1,Polinom polinom2){
        for (Monom i:polinom1.getPolinom()
             ) {
                polinom2.getPolinom().add(i);
        }
    }



}

