package pl.wiktor.lambdas;

import org.junit.jupiter.api.Test;
import pl.wiktor.lambdas.exceptions.FirstOrSecondIsNullException;
import pl.wiktor.lambdas.generic.Pair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PairTest {

    private static final String FIRST = "FIRST";
    private static final String SECOND = "SECOND";

    @Test
    void shouldTwoPairsBeEqual() {
        Pair<String, String> firstPair = new Pair<>(FIRST, SECOND);
        Pair<String, String> secondPair = new Pair<>(FIRST, SECOND);

        assertEquals(firstPair, secondPair);
    }

    @Test
    void shouldThrowFirstOrSecondIsNullException() {
        Pair<String, String> pair = new Pair<>(FIRST, null);
        assertThrows(FirstOrSecondIsNullException.class, pair::checkIfFirstAndSecondAreTheSame);
    }

    @Test
    void shouldThrowClassCastException() {
        Pair<String, Integer> pair = new Pair<>(FIRST, 2);
        assertThrows(ClassCastException.class, pair::checkIfFirstAndSecondAreTheSame);
    }

}
