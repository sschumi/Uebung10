package p2;
import java.lang.String;

public class String2 implements Editable {
    private String mainString;

    public String2(String s){
       mainString = s;
    }

    public void addPrefix(String s){
        mainString = s +mainString;
    }

    public void addPostfix(String s){
        mainString = mainString+s;
    }

}
