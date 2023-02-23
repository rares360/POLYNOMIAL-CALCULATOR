package models;

public class Monom implements Comparable<Monom>{
    private float coeficient;
    private int exponent;

    public Monom(float coeficient,int exponent){
        this.exponent=exponent;
        this.coeficient=coeficient;
    }
    public int getExponent() {
        return exponent;
    }
    public void setExponent(int exponent) {
        this.exponent = exponent;
    }
    public float getCoeficient() {
        return coeficient;
    }
    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }
    public String toString( )
    {
        if( coeficient == 0)
            return "";
        if( exponent > 0 && coeficient ==1)
            return "X^" + exponent;
        if( exponent == 0 && coeficient>0)
            return  "+" + coeficient + "";
        if( exponent == 0 && coeficient<0)
            return  coeficient + "";
        if( exponent > 0 && coeficient > 0 && exponent!=1)
            return "+" + coeficient + "X^" + exponent;
        if( exponent > 0 && coeficient > 0 && exponent==1)
            return "+" + coeficient + "X";
        if( exponent > 0 && coeficient < 0 && exponent!=1)
            return coeficient + "X^" + exponent;
        if( exponent > 0 && coeficient < 0 && exponent==1)
            return coeficient + "X";
        if( coeficient == 1 && exponent == 1 )
            return "X";
    return "";
    }

    @Override
    public int compareTo(Monom o) {
        return -(exponent-o.getExponent());
    }
}
