package pl.wiktor.lambdas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.wiktor.lambdas.exceptions.FirstOrSecondIsNullException;
import pl.wiktor.lambdas.generic.Pair;
import pl.wiktor.lambdas.repo.DeckRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PairTest {


    private static DeckRepository deckRepository;

    @BeforeAll
    static void init() {
        deckRepository = new DeckRepository();
    }

    @Test
    void shouldTwoPairsBeEqual() {
        final String first = "FIRST";
        final String second = "SECOND";
        Pair<String, String> firstPair = new Pair<>(first, second);
        Pair<String, String> secondPair = new Pair<>(first, second);

        assertEquals(firstPair, secondPair);
    }

    @Test
    void shouldThrowFirstOrSecondIsNullException() {
        Pair<String, String> pair = new Pair<>("FIRST", null);
        assertThrows(FirstOrSecondIsNullException.class, pair::checkIfFirstAndSecondAreTheSame);
    }

    @Test
    void shouldThrowClassCastException() {
        Pair<String, Integer> pair = new Pair<>("FIRST", 2);
        assertThrows(ClassCastException.class, pair::checkIfFirstAndSecondAreTheSame);
    }

}
