import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Deck {
private List<Card> cardDeck;


public Deck() {
    cardDeck = new ArrayList<>();
    char[] suits = {'♠', '♥', '♦', '♣'};

    for (char suit : suits) {
        for (int face = 1; face<=13; face++) {
            cardDeck.add(new Card(suit, face)); //legger til kort i kortstokken
        }
    }
    shuffle();

   
}
public void shuffle() {
    Collections.shuffle(cardDeck); //ny måte å stokke kortstokken på, denne er tilfeldig hver gang
}

public Card drawCard() {
    if (cardDeck.isEmpty()) {
        throw new IllegalArgumentException("Kortstokken er tom!");
    }
    return cardDeck.remove(0); //remove returner og fjerner kortet på index 0, og flytter indexen fremover.
}


}
