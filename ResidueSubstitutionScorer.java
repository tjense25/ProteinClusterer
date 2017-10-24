import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by tjense25 on 10/10/17.
 */
public class ResidueSubstitutionScorer {

    private int[][] score_matrix;


    public ResidueSubstitutionScorer() {
        this.score_matrix = loadMatrix();
    }

    private int[][] loadMatrix() {
        int[][] matrix = new int[20][20];
        try {
            Scanner scan = new Scanner(new FileReader("src/Blosum62.txt"));
            for(int i = 0; i < 20; i++) {
                for(int j = 0; j < 20; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }
        }
        catch(IOException e) {
            System.out.println("Invalid File Name!");
            e.printStackTrace();
        }
        return matrix;
    }

    public int score(char aa1, char aa2) {
        int score1 = AAtoInt(aa1);
        int score2 = AAtoInt(aa2);
        if(score1 == -1 || score2 == -1) return -4;
        else return score_matrix[score1][score2];
    }




    public static int AAtoInt(char aa) {
        switch(aa) {
            case 'A' : return 0;
            case 'R' : return 1;
            case 'N' : return 2;
            case 'D' : return 3;
            case 'C' : return 4;
            case 'Q' : return 5;
            case 'E' : return 6;
            case 'G' : return 7;
            case 'H' : return 8;
            case 'I' : return 9;
            case 'L' : return 10;
            case 'K' : return 11;
            case 'M' : return 12;
            case 'F' : return 13;
            case 'P' : return 14;
            case 'S' : return 15;
            case 'T' : return 16;
            case 'W' : return 17;
            case 'Y' : return 18;
            case 'V' : return 19;
            default : return -1;
        }
    }

    public static char InttoAA(int i) {
        switch(i) {
            case 0 : return 'A';
            case 1 : return 'R';
            case 2 : return 'N';
            case 3 : return 'D';
            case 4 : return 'C';
            case 5 : return 'Q';
            case 6 : return 'E';
            case 7 : return 'G';
            case 8 : return 'H';
            case 9 : return 'I';
            case 10 : return 'L';
            case 11 : return 'K';
            case 12 : return 'M';
            case 13 : return 'F';
            case 14 : return 'P';
            case 15 : return 'S';
            case 16 : return 'T';
            case 17 : return 'W';
            case 18 : return 'Y';
            case 19 : return 'V';
            default : return '_';
        }
    }
}
