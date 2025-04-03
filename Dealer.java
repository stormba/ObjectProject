

public class Dealer  extends Player{
    public Dealer(){
        super("Dealer"); //navn satt til "Dealer"
    }

    public void playTurn(Deck deck) {
        while (getHandValue() < 17) { //trekker kort til minst 17
            addCard(deck.drawCard());
        }
    }

    public void printHiddenHand() {
        System.out.print("Dealer's hånd: [" + getHand().get(0) + ", ??]");
        System.out.println(" (Verdi: ??)"); // Skjuler andre kort
    }
}
