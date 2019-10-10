package pl.wiktor.lambdas;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.wiktor.lambdas.model.Card;
import pl.wiktor.lambdas.model.Figure;
import pl.wiktor.lambdas.model.Suit;
import pl.wiktor.lambdas.repo.DeckRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class DeckTest {

    private static DeckRepository deckRepository;

    @BeforeAll
    static void init() {
        deckRepository = new DeckRepository();
    }

    @Test
    void shouldReturnAtLeastOneCardInstance() {
        Optional<Card> atLeastOneCard = deckRepository.getNewDeck()
                .stream()
                .findAny();

        assertTrue(atLeastOneCard.isPresent());
        assertTrue(atLeastOneCard.get() instanceof Card);
    }

    @Test
    void shouldCreateNewDeck() {
        assertNotNull(deckRepository.getNewDeck());
    }

    @Test
    void shouldReturnAceSpades() {
        Optional<Card> actual = deckRepository.getNewDeck()
                .stream()
                .filter(card -> Figure.ACE.equals(card.getFigure()))
                .filter(card -> Suit.SPADES.equals(card.getSuit()))
                .findAny();

        assertTrue(actual.isPresent());
    }

    @Test
    void shouldContainsKingHearts() {
        Card expected = new Card(Suit.HEARTS, Figure.KING);
        Optional<Card> optCard = deckRepository.getNewDeck()
                .stream()
                .filter(card -> card.equals(expected)).findAny();

        assertTrue(optCard.isPresent());
    }


}
