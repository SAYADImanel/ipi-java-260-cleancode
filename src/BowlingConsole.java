
import java.util.Scanner;

public class BowlingConsole {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        BowlingGame bowlingGame = new BowlingGame();

        for (int i = 1; i <= 20; i++) {
            System.out.println("Lanc� " + i);
            System.out.println("Combien de quille vous avez fait tomb� ?");
            String nbQuillesAsString = scanner.nextLine();
            int nbQuilles = Integer.parseInt(nbQuillesAsString);
            bowlingGame.roll(nbQuilles);
            int score = bowlingGame.score();
            System.out.println("Votre score est de : " + score);
            System.out.println("-----------------");
        }
    }
}