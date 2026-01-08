package p1;

public class main {
    public static void main(String[] args){

    }

    public static Betrag summe(Betrag a, Betrag b){
        Betrag c = new Betrag(0, 0);
        c.setEuro(a.getEuro()+b.getEuro());
        c.setCent(a.getCent()+b.getCent());
        return c;
    }
}
