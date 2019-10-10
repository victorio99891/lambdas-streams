package pl.wiktor.lambdas.model;

public enum Suit {

    CLUBS(Colour.BLACK),

    DIAMONDS(Colour.RED),

    HEARTS(Colour.RED),

    SPADES(Colour.BLACK);

    private final Colour colour;

    private Suit(Colour colour) {
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }
}
