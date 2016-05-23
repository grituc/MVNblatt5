package md.grituc;
import java.util.*;

public class App {

private static void smallToBig(String s1){
    for(char x:s1.toCharArray())
        if ('a' <= x && x <= 'z')
            System.out.print((char)(x-'a'+'A'));
        else
            System.out.print(x);
    System.out.println();
}

public static void main( String[] args ){
    System.out.println( "Hello World!" );
    Scanner sc = new Scanner(System.in); //Input from System.im
    String s = sc.next();
    
    App.smallToBig(s);  

    System.out.println("Ausgabe fertig");

}
}
