import java.util.Scanner;

public class Blackjack
{
    public static void main(String[] args)
    {
        P1Random rng = new P1Random();
        Scanner scanner = new Scanner(System.in);
        int playerNumber = 0;
        String playerCard = "0";
        int playerHand = 0;
        int dealerHand = 0;
        int playerSelect = 1;
        double playerWins = 0;
        double dealerWins = 0;
        int tieGames = 0;
        double totalGamesPlayed = 0;
        double winPercentage;
        int gameCount = 1;

        // Keep the game rolling unless the player inputs "4"
        while (true)
        {
            while (playerHand < 21)
            {
                // If the playerHand = 0, we start another game
                if (playerHand == 0)
                {
                    System.out.println("START GAME #" + gameCount);
                }
                // Draw card
                if (playerSelect == 0 || playerSelect == 1 || playerSelect == 2)
                {
                    playerNumber = rng.nextInt(13) + 1;
                }
                // Assign card value
                if (playerNumber == 1)
                {
                    playerCard = "ACE";
                    playerNumber = 1;
                }
                else if (playerNumber == 2)
                {
                    playerCard = "2";
                    playerNumber = 2;
                }
                else if (playerNumber == 3)
                {
                    playerCard = "3";
                    playerNumber = 3;
                }
                else if (playerNumber == 4)
                {
                    playerCard = "4";
                    playerNumber = 4;
                }
                else if (playerNumber == 5)
                {
                    playerCard = "5";
                    playerNumber = 5;
                }
                else if (playerNumber == 6)
                {
                    playerCard = "6";
                    playerNumber = 6;
                }
                else if (playerNumber == 7)
                {
                    playerCard = "7";
                    playerNumber = 7;
                }
                else if (playerNumber == 8)
                {
                    playerCard = "8";
                    playerNumber = 8;
                }
                else if (playerNumber == 9)
                {
                    playerCard = "9";
                    playerNumber = 9;
                }
                else if (playerNumber == 10)
                {
                    playerCard = "10";
                    playerNumber = 10;
                }
                else if (playerNumber == 11)
                {
                    playerCard = "JACK";
                    playerNumber = 10;
                }
                else if (playerNumber == 12)
                {
                    playerCard = "QUEEN";
                    playerNumber = 10;
                }
                else if (playerNumber == 13)
                {
                    playerCard = "KING";
                    playerNumber = 10;
                }

                // Only add cards if the player select is 1 or 2
                if (playerSelect == 1 || playerSelect == 2)
                {
                    playerHand += playerNumber;
                    System.out.println("Your card is a " + playerCard + "!");
                    System.out.println("Your hand is: " + playerHand);
                }


                // If player hits 21
                if (playerHand == 21)
                {
                    System.out.println("BLACKJACK! You win!");
                    System.out.println("");
                    playerWins++;
                    totalGamesPlayed++;
                    playerHand = 0;
                    gameCount++;
                    continue;
                }

                // If player busts (> 21)
                if (playerHand > 21)
                {
                    System.out.println("You exceeded 21! You lose.");
                    System.out.println("");
                    dealerWins++;
                    totalGamesPlayed++;
                    playerHand = 0;
                    gameCount++;
                    continue;
                }

                // Player Options
                System.out.println("");
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println("");
                System.out.print("Choose an option: ");
                System.out.println("");
                playerSelect = scanner.nextInt();

                // Draw another card
                if (playerSelect == 1)
                {
                    continue;
                }
                // Player stands; draws dealer's hand
                else if (playerSelect == 2)
                {
                    dealerHand = rng.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + playerHand);
                    if ((playerHand > dealerHand && playerHand <= 21) || dealerHand > 21)
                    {
                        System.out.println("You win!");
                        System.out.println("");
                        playerWins++;
                        totalGamesPlayed++;
                        playerHand = 0;
                        gameCount++;
                    }
                    else if (playerHand < dealerHand && dealerHand <= 21)
                    {
                        System.out.println("Dealer wins!");
                        System.out.println("");
                        dealerWins++;
                        totalGamesPlayed++;
                        playerHand = 0;
                        gameCount++;
                    }
                    else if (playerHand == dealerHand)
                    {
                        System.out.println("It's a tie! No one wins!");
                        System.out.println("");
                        tieGames++;
                        totalGamesPlayed++;
                        playerHand = 0;
                        gameCount++;
                    }
                }
                // Displays game stats
                else if (playerSelect == 3)
                {
                    System.out.println("Number of Player wins: " + Math.round(playerWins));
                    System.out.println("Number of Dealer wins: " + Math.round(dealerWins));
                    System.out.println("Number of tie games: " + tieGames);
                    System.out.println("Total # of games played is: " + Math.round(totalGamesPlayed));
                    if (totalGamesPlayed > 0)
                    {
                        winPercentage = 100.0 * (playerWins / totalGamesPlayed);
                        System.out.println("Percentage of Player wins: " + winPercentage + "%");
                    }
                    else
                    {
                        System.out.println("Percentage of Player wins: 0%");
                    }
                }
                // Quits the game
                else if (playerSelect == 4)
                {
                    return;
                }
                // Error in case player tries to input number other than 1-4
                else if (playerSelect < 1 || playerSelect > 4)
                {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                }

            }
            gameCount++;
        }


    }
}
