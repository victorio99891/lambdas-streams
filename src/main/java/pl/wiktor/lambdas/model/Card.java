package pl.wiktor.lambdas.model;

import java.util.Objects;

public class Card {

    private Suit suit;
    private Figure figure;

    public Card(Suit suit, Figure figure) {
        this.suit = suit;
        this.figure = figure;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                figure == card.figure;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, figure);
    }
}
