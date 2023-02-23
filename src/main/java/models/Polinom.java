package models;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    private List<Monom> polinom;

    public Polinom(){ polinom=new ArrayList<Monom>();}

    public List<Monom> getPolinom() {
        return polinom;
    }

    public void setPolinom(List<Monom> polinom) {this.polinom = polinom;}

    public void addPolinom(Monom monom) {
        polinom.add(monom);
    }

    public void convertToMonomial(String polynomial) {
        Pattern p1 = Pattern.compile("([+-]?[\\d\\.]*[a-zA-Z]?\\^?\\d*)");Matcher m1 = p1.matcher(polynomial);
        while (!m1.hitEnd()) {
            m1.find();
            Pattern p2 = Pattern.compile("([+-]?[\\d\\.]*)([a-zA-Z]?)\\^?(\\d*)");Matcher m2 = p2.matcher(m1.group());
            if (m2.find()) {
                float coeficient;
                try {
                    String coef = m2.group(1);
                    if (isNumeric(coef)) {
                        coeficient = Float.valueOf(coef);
                    } else {
                        coeficient = Float.valueOf(coef + "1");
                    }
                } catch (IllegalStateException e) {
                    coeficient = 0.0F;
                }
                int exponent=0;
                try {
                    String letter = m2.group(2),exp=m2.group(3);
                    if (isNumeric(exp)) {
                        exponent = Integer.valueOf(exp);
                    } else if(!isNumeric(exp) && isLetter(letter)){
                        exponent = 1;
                    } else if(!isNumeric(exp) && !isLetter(letter)){
                        exponent = 0;
                    }
                } catch (IllegalStateException e) {
                    exponent = -1;
                }
                Monom monom=new Monom(coeficient,exponent);
                polinom.add(monom);
            }
        }
        Collections.sort(polinom);
    }

    boolean isNumeric(String str) {
        return str.matches("[+-]*\\d*\\.?\\d+");
    }

    boolean isLetter(String str) {
        return str.matches("[a-zA-Z]+");
    }

    public String toString(){
        String rezultat="";
        for (Monom i:polinom) {
            rezultat=rezultat+i.toString();
        }
        System.out.println(rezultat);
        return rezultat;
    }

}
