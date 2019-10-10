package pl.wiktor.lambdas.model;

import java.util.List;
import java.util.stream.Collectors;
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

    public static List<Figure> getAllFigures() {
        return Stream.of(Figure.values())
                .collect(Collectors.toList());
    }

    public static List<Figure> getNonNamed() {
        return Stream.of(Figure.values())
                .filter(figure ->
                        figure != Figure.ACE && figure != Figure.KING && figure != Figure.QUEEN && figure != Figure.JACK)
                .collect(Collectors.toList());
    }

    public static List<Figure> getNamed() {
        return Stream.of(Figure.values())
                .filter(figure ->
                        figure == Figure.ACE || figure == Figure.KING || figure == Figure.QUEEN || figure == Figure.JACK)
                .collect(Collectors.toList());
    }
}