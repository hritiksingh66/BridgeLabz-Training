import java.util.Scanner;

// Program to create, shuffle and distribute deck of cards
public class DeckOfCards {

    // Initialize a standard deck of 52 cards
    public static String[] initializeDeck() {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10",
                           "Jack", "Queen", "King", "Ace" };
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        // Create all card combinations
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Shuffle the deck randomly
    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // Distribute cards to players
    public static String[][] distributeCards(String[] deck, int cardsPerPlayer, int numPlayers) {
        int totalCards = cardsPerPlayer * numPlayers;
        if (totalCards > deck.length) {
            System.out.println("Not enough cards to distribute.");
            return null;
        }

        String[][] players = new String[numPlayers][cardsPerPlayer];
        int index = 0;

        // Deal cards to each player
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[index++];
            }
        }
        return players;
    }

    // Display cards for each player
    public static void printPlayers(String[][] players) {
        if (players == null) return;

        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Initialize and shuffle deck
        String[] deck = initializeDeck();
        shuffleDeck(deck);

        // Get game parameters from user
        System.out.print("Enter number of players: ");
        int numPlayers = sc.nextInt();

        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = sc.nextInt();

        // Distribute and display cards
        String[][] players = distributeCards(deck, cardsPerPlayer, numPlayers);
        printPlayers(players);
    }
}
