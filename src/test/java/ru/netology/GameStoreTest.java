package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameStoreTest {
    GameStore store = new GameStore();


    @Test
    public void shouldAddGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Меч и Магия", "Аркады");
        Game game3 = store.publishGame("Пабг Мобайл", "Шутеры");
        Game game4 = store.publishGame("2048", "Логические");


        assertTrue(store.containsGame(game3));
    }

    // другие ваши тесты
    @Test
    public void shouldShowPlayTime() {
        store.addPlayTime("Olya", 12);
        store.addPlayTime("Sasha", 4);
        store.addPlayTime("Alex", 10);
        store.addPlayTime("Nina", 7);

        assertEquals("Olya", store.getMostPlayer());
    }
    @Test
    public void shouldShowPlayTimeOfOnePlayer() {
        store.addPlayTime("Nina", 7);
        assertEquals("Nina", store.getMostPlayer());
    }
    @Test
    public void shouldShowSumPlayedTime() {
        store.addPlayTime("Alex", 10);
        store.addPlayTime("Evgen", 11);
        store.addPlayTime("Sasha", 4);

        assertEquals(25, store.getSumPlayedTime());
    }

    @Test
    public void shouldShowSumPlayedTimeOfOnePlayer() {
        store.addPlayTime("Alex", 10);
        assertEquals(10, store.getSumPlayedTime());
    }





}
