import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.*;



public class Roulette {
    

    static boolean stopBet = false;
    public static void main(String[] args) {
        ArrayList<String> players = ReadFile();
        ArrayList<String> bets  = new ArrayList<String>();
        Scanner command = new Scanner(System.in);
        boolean running = true;
        String input = "";

        //timer to run the bet outcome and calculate the winnings
        Timer timer = new Timer(30000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                stopBet = true;
                System.out.println("\nBetting Stopped");
                awardWinnings(bets);
                stopBet = false;
                System.out.println("Betting Started");
                System.out.println("Enter Bet: ");
            }
        });
        timer.setRepeats(true);
        timer.start(); 
        System.out.println(players);

        //listens for command line inputs for bets
        while(running){
            System.out.println("Enter Bet: ");
            input = command.nextLine();
            if((!stopBet) && placeBet(input, players,bets)){
                System.out.println(bets);  
                System.out.println("BET placed");  
            }else{
                System.out.println("Command not recognized!");
            }
        }
        command.close();
    }

    //function to read the list of players
    public static ArrayList<String> ReadFile () {
        ArrayList<String> players = new ArrayList<String>();
        try {
            File myObj = new File("players.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
            players.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return players;
    
    }
    
    //test the input to make sure it is a valid bet and then stores all valid bets
    public static boolean placeBet(String input,  ArrayList<String> players, ArrayList<String> bets ){

        String[] words = input.split("\\s+");
        try {
            if(!players.contains(words[0])){
                return false;
            }

            else if (!(words[1].equals("EVEN") || words[1].equals("ODD") || ( 1 <= Integer.parseInt(words[1]) && Integer.parseInt(words[1]) < 37 ))) {
                return false;
            }
            else if ( 0 > Double.parseDouble(words[2])) {
                return false;
            }else {
                
                bets.add(input);
                return true;
            }
        }catch(NumberFormatException e) {
            return false;
        }
    
    }

    // gets the random choice on roulette and calucaltes and outputs the winnings
    public static void awardWinnings( ArrayList<String> bets ){

        int randomNum = 1 + (int)(Math.random() * ((37 - 1) + 1));

        System.out.println("Number: " + randomNum);
        System.out.println("Player\t\tBet\t\tOutcome\t\tWinnings");
        System.out.println("---");

        //just add for loop for all winnings 
         for (int i =0; i < bets.size(); i++){
            String[] words = bets.get(i).split("\\s+");
            double winnings = 0;
            String outcome = "LOSE";
            try {
                if (words[1].equals("EVEN") && randomNum % 2 == 0) {
                    winnings = Double.parseDouble(words[2]) * 2;
                    outcome = "WIN";
                }
                else if (words[1].equals("ODD") && randomNum % 2 == 1) {
                    winnings = Double.parseDouble(words[2]) * 2;
                }
                
                else if(Integer.parseInt(words[1]) == randomNum){
                    winnings = Double.parseDouble(words[2]) * 36;
                    outcome = "WIN";
                }
            }catch(NumberFormatException e) {
                winnings = 0;
                outcome = "LOSE";
            }
            System.out.println(words[0] + "\t\t" + words[1] + "\t\t" + outcome + "\t\t" + winnings);
         }
         bets.clear();
    } 
}