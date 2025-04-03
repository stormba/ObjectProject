import java.util.Scanner;
public class Game {
    
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Scanner scanner;

    public Game () {
        deck = new Deck();
        player = new Player("Spiller");
        dealer = new Dealer();
        scanner = new Scanner(System.in);
    }

    //startfunksjon, spilleren får 2 kort, samme gjør dealer
    public void start() {
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        player.printHand();
        dealer.printHiddenHand();

        if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
            System.out.println("Gratulerer du fikk BlackJack og vant!");
        }
        //forsikring hvis det første kortet til dealern er ess må implemeteres

        playerTurn();
        if (!player.isBusted()) {
            dealerTurn();
        }
        
        checkWinner();
    }


    
    private void playerTurn(){
        System.out.println("Vil du (1) trekke kort, stå (2) eller doble innsatsen (3)?");
        int choice = scanner.nextInt();

        //trekker
        if (choice == 1) {
            
            player.addCard(deck.drawCard());
            player.printHand();

            if (player.isBusted()) {
                System.out.println("Du tapte! Du fikk over 21.");
                return;
            } else {
                playerTurn();
            }
        //dobbel
        } else if (choice == 3){
            
            player.addCard(deck.drawCard());
            player.printHand();
            if (player.isBusted()) {
                System.out.println("Du tapte! Du fikk over 21.");
            } else {
                return;
            }
        }
        //står
        else{
            System.out.println("Du står!");
            return;
        }
    }
    

    private void dealerTurn(){
        System.out.println("\nDealeren sin tur!");
        dealer.playTurn(deck);
        dealer.printHand();
    }


    private void checkWinner(){
        int playerScore = player.getHandValue();
        int dealerScore = dealer.getHandValue();

        if (player.isBusted()) {
            System.out.println("Dealer vinner.");
        } else if (dealer.isBusted() || playerScore > dealerScore) {
            System.out.println("Du vant. Gratulerer!");
        } else if (dealerScore > playerScore) {
            System.out.println("Dealeren vinner.");
        } else {
            System.out.println("Uavgjort!");
        }
    }






}
