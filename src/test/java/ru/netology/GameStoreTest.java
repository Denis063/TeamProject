package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    private GameStore store = new GameStore();
    private Game game1 = store.publishGame("Расцвет нации", "Стратегия");
    private Game game2 = store.publishGame("Боец", "Файтинг");
    private Game game3 = store.publishGame("Стрелок", "Шутер");

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldFindGameAtTheBeginning() {
        assertTrue(store.containsGame(game1));
    }

    @Test
    public void shouldFindGameInTheMiddle() {
        assertTrue(store.containsGame(game2));
    }

    @Test
    public void shouldFindGameAtTheEnd() {
        assertTrue(store.containsGame(game3));
    }
}