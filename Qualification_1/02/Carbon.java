import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Carbon {
    private static ArrayList<Node> outbound = new ArrayList<>();
    private static ArrayList<Node> inbound = new ArrayList<>();
    public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);

        try {
            sc = new Scanner(new File("Qualification_1/02/in.txt"));
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }

        int n = sc.nextInt(); sc.nextLine();
        while(sc.hasNextLine()) {
            line = sc.nextLine();

            String[] data = line.split(" ");
            String time = data[0];
            String s0 = data[1].split("-")[0];
            String s1 = data[1].split("-")[1];
            String co2 = data[2];

            if (s0.equals("Paris")) {
                outbound.add(new Node(time, co2));
            } else {
                inbound.add(new Node(time, co2));
            }

            /* Lisez les données et effectuez votre traitement */
        }

        Collections.sort(inbound, Collections.reverseOrder());
        Collections.sort(outbound);

        long minimum = Long.MAX_VALUE;
        long minCO2 = Long.MAX_VALUE;
        boolean exitOutLoop = false;
        for (int j = 0; j < outbound.size() && !exitOutLoop; j++) {
            Node t0 = outbound.get(j);
            if (t0.co2 <= minCO2) {
                minCO2 = t0.co2;
                
                if (t0.time > inbound.get(0).time) exitOutLoop = true;

                boolean exitInLoop = false;
                for (int i = 0; i < inbound.size() && !exitInLoop; i++) {
                    Node t1 = inbound.get(i);
                    if (t1.time > t0.time) {
                        long sum = t0.co2 + t1.co2;
                        if (sum < minimum) minimum = sum;
                    } else exitInLoop = true;
                }
            }
        }

        System.out.println(minimum);
    /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }

    static class Node implements Comparable<Node> {
        long time;
        long co2;

        Node(String time, String co2) {
            this.time = Timestamp.valueOf("2022-01-01 " + time).getTime();
            this.co2 = Long.parseLong(co2);
        }
        
        @Override
        public int compareTo(Node n1) {
            return Long.compare(time, n1.time);
        }
    }
}