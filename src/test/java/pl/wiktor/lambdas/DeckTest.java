package pl.wiktor.lambdas;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.wiktor.lambdas.model.Card;
import pl.wiktor.lambdas.model.Figure;
import pl.wiktor.lambdas.model.Suit;
import pl.wiktor.lambdas.repo.DeckRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    void shouldCreateNewDeck() {
        assertNotNull(deckRepository.getNewDeck());
    }

    @Test
    void shouldContainsAceSpades() {
        List<Card> aces = deckRepository.getNewDeck()
                .stream()
                .filter(card -> Figure.ACE.equals(card.getFigure()))
                .collect(Collectors.toList());

        Optional<Card> aceSpades = aces.stream()
                .filter(ace -> ace.getSuit().equals(Suit.SPADES)).findAny();

        assertTrue(aceSpades.isPresent());
    }

    @Test
    void shouldContainsKingHearts() {
        Card expected = new Card(Suit.HEARTS, Figure.KING);
        Optional<Card> optCard = Optional.of(
                deckRepository.getNewDeck().stream()
                        .filter(card -> card.equals(expected))).get().findAny();

        assertTrue(optCard.isPresent());
    }


}
