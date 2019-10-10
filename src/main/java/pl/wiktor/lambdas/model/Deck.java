package pl.wiktor.lambdas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Deck {


    private Deck() {

    }

    public static List<Card> getNewDeck() {
        List<Card> deck = new ArrayList<>();
        Figure.getAllFigures().forEach(figure -> Stream.of(Suit.values()).forEach(suit -> deck.add(new Card(suit, figure))));
        return deck;
    }


}
