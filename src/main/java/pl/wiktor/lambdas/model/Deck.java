package pl.wiktor.lambdas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Deck {


    private Deck() {

    }

    public static List<Card> getNewDeck() {
        List<Card> deck = new ArrayList<>();
        Figure.getAllFiguresStream()
                .forEach(figure -> getSuitStream()
                        .forEach(suit -> addNewCardToDeck(deck, figure, suit)));
        return deck;
    }

    private static Stream<Suit> getSuitStream() {
        return Stream.of(Suit.values());
    }

    private static void addNewCardToDeck(List<Card> deck, Figure figure, Suit suit) {
        deck.add(new Card(suit, figure));
    }


}
