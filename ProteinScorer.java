import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tjense25 on 10/10/17.
 */
public class ProteinScorer {

    int k;
    List<String> proteins;
    List<int[]> scored_vectors;

    public ProteinScorer(List<String> proteins) {
        this.proteins = proteins;
        if(proteins.size() != 0) k = proteins.get(0).length();
        scored_vectors = scoreProteins();
    }

    private List<int[]> scoreProteins() {
        List<int[]> vectors = new ArrayList<>();
        Random rand = new Random();
        int rand_pos = rand.nextInt(proteins.size());
        String selected_protein = proteins.get(0);
        ResidueSubstitutionScorer rss = new ResidueSubstitutionScorer();
        for(int i = 0; i < proteins.size(); i++) {
            int[] vector = new int[k];
            String current_protein = proteins.get(i);
            for(int j = 0; j < k; j++) {
                vector[j] = rss.score(selected_protein.charAt(j), current_protein.charAt(j));
            }
            vectors.add(vector);
        }
        return vectors;
    }

    public List<int[]> getScoredVectors() {
        return scored_vectors;
    }

}
