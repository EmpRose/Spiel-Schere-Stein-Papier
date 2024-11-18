import java.util.Scanner;
import java.util.Random;

public class SchereSteinPapier {

    public static final int SCHERE = 0;
    public static final int STEIN = 1;
    public static final int PAPIER = 2;

    public static int playerCount = 0;
    public static int computerCount = 0;

    public static void main(String[] args) {
        System.out.println("Willkommen zum Spiel, Schere,Stein,Papier");
        while(playerCount <3 && computerCount <3){
        int playerChoice = getPlayerChoice();
        int computerChoice = getComputerChoice();
        System.out.println("Spieler wählt: " + playerChoice );
        System.out.println("Computer wählt: " + computerChoice);
        determineWinner(playerChoice,computerChoice);
        System.out.println(getWinnerCount(playerCount, computerCount));
    }}
    
    public static int getPlayerChoice (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wählen Sie 0: für Schere, 1: für Stein, 2: für Papier");
        int choice = -1;
        while(choice < 0 || choice > 2){
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                // Wenn eine falsche Zahl eingegeben wird.
                if (choice < 0 || choice > 2){ 
                    System.out.println("Falsche Eingabe. Bitte wählen Sie 0: für Schere, 1: für Stein, 2: für Papier ");
                }
            // Wenn keine Zahl eingegeben wird.
            }else{                           
                System.out.println("Falsche Eingabe. Bitte wählen Sie 0: für Schere, 1: für Stein, 2: für Papier ");
                //Löscht ungültige Eingabe (keine Zahl)
                scanner.next(); 
            }
        }
        return choice;
    }

    public static int getComputerChoice (){
        Random random = new Random();
        return random.nextInt(3);
    }

    public static void determineWinner (int playerChoice, int computerChoice){


        if (playerChoice == computerChoice){
            System.out.println("Unentschieden");
        } else if (
                (playerChoice == SCHERE && computerChoice == PAPIER) ||
                (playerChoice == STEIN && computerChoice == SCHERE) ||
                (playerChoice == PAPIER && computerChoice == STEIN)){
            System.out.println("Du gewinnst!");
            playerCount++;
        } else {
            System.out.println("Computer gewinnt!");
            computerCount++;
        }
    }
    public static String getWinnerCount(int playerCount, int computerCount){
        if(playerCount >= 3){
            return "Der Spieler gewinnt das Duell mit " + playerCount + " Punkten zu " + computerCount;
        } else if (computerCount >=3) {
            return "Der Computer gewinnt das Duell mit " + computerCount + " Punkten zu " + playerCount;
        }else{
            return"Nächste Runde. Der Stand ist, Spieler: " + playerCount + " Computer: " + computerCount;
        }
    }
}
