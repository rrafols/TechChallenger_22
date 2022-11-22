import java.io.File;
import java.util.Scanner;

class Time {
    public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);

        try {
            sc = new Scanner(new File("Qualification_1/00/in.txt"));
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }

        while(sc.hasNextLine()) {
            line = sc.nextLine();
            /* Lisez les données et effectuez votre traitement */

            System.out.println(isTimeValid(line));
        }
    /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }

    private static String isTimeValid(String time) {
        try {
            String[] tc = time.split(":");
            int hours = Integer.parseInt(tc[0]);
            int minutes = Integer.parseInt(tc[1]);

            if (hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59) return "YES";
            else return "NO";
        } catch(Exception e) {
            return "NO";
        }
    }
}