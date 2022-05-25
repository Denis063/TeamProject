package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    private GameStore store = new GameStore();
    private Game game1 = store.publishGame("Расцвет нации", "Стратегия");
    private Game game2 = store.publishGame("Боец", "Файтинг");
    private Game game3 = store.publishGame("Стрелок", "Шутер");

    @Test
    public void shouldAddNewGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Меч и Магия", "Аркады");
        Game game3 = store.publishGame("Пабг Мобайл", "Шутеры");
        Game game4 = store.publishGame("2048", "Логические");


        assertTrue(store.containsGame(game4));
    }

    @Test
    public void shouldFindGameInTheBeginning() {
        assertTrue(store.containsGame(game1));
    }

    @Test
    public void shouldFindGameInTheMiddle() {
        assertTrue(store.containsGame(game2));
    }

    @Test
    public void shouldFindGameInTheEnd() {
        assertTrue(store.containsGame(game3));
    }

    @Test
    public void shouldAddPlayAtFirstTime(){
        store.addPlayTime("Ираклий", 12);
        assertEquals(12, store.getSumPlayedTime());
    }
    @Test
    public void shouldSumPlayTime(){
        store.addPlayTime("Василий", 3);
        store.addPlayTime("Василий", 1);

        assertEquals(4, store.getSumPlayedTime());
    }

    @Test
    public void shouldFindMostPlayerWithNoPlayer(){
        assertNull(store.getMostPlayer());
    }
    @Test
    public void shouldFindMostPlayerSinglePlayer(){
        store.addPlayTime("Петр", 4);
        assertTrue(store.getMostPlayer().equals("Петр"));
    }

    @Test
    public void shouldFindMostPlayerSeveralPlayers(){
        store.addPlayTime("Василий", 6);
        store.addPlayTime("Дмитрий", 3);
        store.addPlayTime("Олег", 9);

        assertTrue(store.getMostPlayer().equals("Олег"));
    }

    @Test
    public void shouldFindMostPlayerIfPlayersPlayedTheSameTime(){
        store.addPlayTime("Игорь", 1);
        store.addPlayTime("Василий", 1);
        store.addPlayTime("Михаил", 1);

        assertNotNull(store.getMostPlayer());
        assertTrue(store.getMostPlayer().equals("Игорь"));
    }
    @Test
    public void shouldTotalPlayTimeNoPlayers(){
        assertEquals(0, store.getSumPlayedTime());
    }

    @Test
    public void shouldTotalPlayTimeSeveralPlayers(){
        store.addPlayTime("Роман", 3);
        store.addPlayTime("Илья", 2);
        store.addPlayTime("Сергей", 5);
        store.addPlayTime("Святослав", 11);

        assertEquals(21, store.getSumPlayedTime());
    }
}