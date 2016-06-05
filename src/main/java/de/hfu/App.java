package de.hfu; //md.grituc;
import java.util.*;

public class App { //this is an example-Class
				   //testing Maven
/*
private static void smallToBig(String s1){
    for(char x:s1.toCharArray())
        if ('a' <= x && x <= 'z')
            System.out.print((char)(x-'a'+'A'));
        else
            System.out.print(x);
    System.out.println();
}
*/

public static void main( String[] args ){
    System.out.print("Ein String eingeben: ");
    Scanner sc = new Scanner(System.in); //Input from System.in
    String s = sc.next();
    
    s = s.toUpperCase();
    System.out.println("Der neue String: " + s);
    System.out.println("Ausgabe fertig");
    sc.close();
}
}
