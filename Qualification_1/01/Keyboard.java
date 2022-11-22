/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
// package com.isograd.exercise;
import java.io.File;
import java.util.Scanner;

public class Keyboard {
    
    private static char[][] map = new char[][] {
        new char[] {' '},
        new char[] {'a','b','c'},
        new char[] {'d','e','f'},
        new char[] {'g','h','i'},
        new char[] {'j','k','l'},
        new char[] {'m','n','o'},
        new char[] {'p','q','r'},
        new char[] {'s','t','u','v'},
        new char[] {'w','x','y'},
        new char[] {'z'}
    };
    
public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);

        try {
            sc = new Scanner(new File("Qualification_1/01/in.txt"));
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }

        while(sc.hasNextLine()) {
            line = sc.nextLine();
            /* Lisez les données et effectuez votre traitement */
            System.out.println(translate(line));
        }
    /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }
    
    private static String translate(String line) {
        StringBuilder sb = new StringBuilder();
        String[] keys = line.split(" ");
        for (String key: keys) {
            int idx = (int)(key.charAt(0) - '0');
            sb.append(map[idx][(key.length() - 1) % map[idx].length]);
        }
        return sb.toString();
    }
}