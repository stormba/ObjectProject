import java.util.List;
// import java.util.Scanner;

public class Player {
    private String name;
    private Hand hand;
    private int balance;
    
    

    //konstruktør for NYE spillere
    public Player (String name) {
        this.name = name;
        this.hand = new Hand();
        this.balance = 1000; //startsaldo
        
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public void clearHand(){
        this.hand = new Hand();
    }

    public int getHandValue () {
        return hand.calculateValue();
    }

    // public void addBet(){
    //     System.out.println("Hvor mye vil du spille for?");
    //     int betAmount = scanner.nextInt();
    //     this.bet = betAmount;


    // }

    public void addBalance(double amount){
        this.balance+=amount;
    }
    public void removeBalance(double amount){
        this.balance-=amount;
    }

    public int getBalance(){
        return this.balance;
    }

    public boolean isBroke(){
        return this.balance<1;
    }

    public boolean isBusted() {
        //returnerer true hvis spilleren har busta.
        return getHandValue() > 21;
    }

    public String getName(){
        return this.name;
    }

    public void printHand() {
        System.out.print(name + "'s hånd: ");
        hand.printHand();
    }

    public List<Card> getHand(){
        return hand.getCards();
    }
    
}
