package pl.wiktor.lambdas.model;

import java.util.stream.Stream;

public enum Figure {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;

    public static Stream<Figure> getAllFiguresStream() {
        return Stream.of(Figure.values());
    }

    public static Stream<Figure> getNonNamedStream() {
        return Stream.of(Figure.values())
                .filter(figure -> !isNamedFigure(figure));
    }

    public static Stream<Figure> getNamedStream() {
        return Stream.of(Figure.values())
                .filter(Figure::isNamedFigure);
    }

    private static boolean isNamedFigure(Figure figure) {
        return figure == Figure.ACE ||
                figure == Figure.KING ||
                figure == Figure.QUEEN ||
                figure == Figure.JACK;
    }
}
