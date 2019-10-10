package pl.wiktor.lambdas.repo;

import pl.wiktor.lambdas.model.Card;
import pl.wiktor.lambdas.model.Deck;

import java.util.List;

public class DeckRepository {

    public List<Card> getNewDeck() {
        return Deck.getNewDeck();
    }

}
