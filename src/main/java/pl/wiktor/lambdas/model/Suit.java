package pl.wiktor.lambdas.model;

public enum Suit {
    CLUBS("CLUBS", Colour.BLACK),
    DIAMONDS("DIAMONDS", Colour.RED),
    HEARTS("HEARTS", Colour.RED),
    SPADES("SPADES", Colour.BLACK);

    private final String name;
    private final Colour colour;

    private Suit(String name, Colour colour) {
        this.name = name;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public Colour getColour() {
        return colour;
    }
}
