import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by tjense25 on 10/10/17.
 */
public class ProteinClusterer {
    List<String> proteins;

    public ProteinClusterer(List<String> proteins) {
        this.proteins = proteins;
    }

    public static void main(String[] args) {
        if(args.length != 1) System.out.println("ERROR");
        else {
            try {
                Scanner scanner = new Scanner(new FileReader(args[0]));
                List<String> proteins = new ArrayList<>();
                while(scanner.hasNext()) {
                    scanner.next(); //GETS DNA SEQUENCE
                    String protein = scanner.next().substring(1); //STORES PROTEINS
                    scanner.nextInt();
                    scanner.nextInt();
                    scanner.nextInt();
                    scanner.nextInt();
                    scanner.nextInt();
                    scanner.nextInt();
                    scanner.nextDouble();
                    scanner.nextInt();
                    proteins.add(protein);
                }
                ProteinClusterer proteinClusterer = new ProteinClusterer(proteins);
                proteinClusterer.cluster();
            }
            catch(IOException e) {
                System.out.println("ERROR");
                e.printStackTrace();
            }
        }

    }

    public List<Set<String>> cluster() {
        ProteinScorer scorer = new ProteinScorer(proteins);
        List<int[]> scored_Proteins = scorer.getScoredVectors();
        for(int[] vector : scored_Proteins) {
            System.out.print("{");
            for(int i = 0; i < vector.length; i++) {
                if(i != 0) System.out.print(",");
                System.out.print(vector[i]);
            }
            System.out.println("}");
            return null;
        }
        return null;
    }
}
