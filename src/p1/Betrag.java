package p1;

public class Betrag {
    private int euro;
    private int cent;

    public Betrag(int euro, int cent){
        setEuro(euro);
        setCent(cent);
    }

    public int getEuro() {
        return euro;
    }

    public void setEuro(int euro) {
        this.euro = euro;
    }

    public int getCent() {
        return cent;
    }

    public void setCent(int cent) {
        if(cent >= 100){
            euro += cent/100;
            cent -= cent%100;
            this.cent = cent;
        }
    }
}
