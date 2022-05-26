package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private GameStore store = new GameStore();

    private Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    private Game game1 = store.publishGame("Разрушитель", "Экшн");
    private Game game2 = store.publishGame("Расцвет Империи", "Стратегия");
    private Game game3 = store.publishGame("Война Миров", "Экшн");
    private Game game4 = store.publishGame("Солдаты удачи", "Экшн");

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGames() {
        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 7);
        player.installGame(game3);
        player.play(game3, 9);

        int expected = 16;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfThreeGames() {
        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 4);
        player.installGame(game3);
        player.play(game3, 7);
        player.installGame(game4);
        player.play(game4, 3);

        int expected = 14;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfNoGames() {
        Player player = new Player("Petya");

        int expected = 0;
        int actual = player.sumGenre("Логические");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayAtOnce() {
        Player player = new Player("Игорь");
        player.installGame(game);

        int expected = 8;
        int actual = player.play(game, 8);
        assertEquals(expected, actual);
    }
    @Test
    public void shouldPlayMoreThanOnce() {
        Player player = new Player("Олег");
        player.installGame(game2);
        player.play(game2, 1);

        int expected = 6;
        int actual = player.play(game2, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayIfGameNotInstalled() {
        Player player = new Player("Дмитрий");

        assertThrows(RuntimeException.class, () -> {
            player.play(game2, 5);
        });
    }
    @Test
    public void shouldInstall() {
        Game game = store.publishGame("Звездный десант", "RTS");
        Player player = new Player("Евгений");
        player.installGame(game);

        int expected = 0;
        int actual = player.sumGenre("RTS");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangePlayTimeIfReinstall() {
        Player player = new Player("Валентин");
        player.installGame(game);
        player.play(game, 9);
        player.installGame(game);   // Переустановка игры

        int expected = 9;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }
    @Test
    public void showMostPlayedIfNotPlayed() {
        Player player = new Player("Ирина");
        Game expected = null;
        Game actual = player.mostPlayerByGenre("Выживалка");
        assertEquals(expected, actual);
    }

    @Test
    public void showMostPlayedIfOneGame() {
        Player player = new Player("Дмитрий");
        player.installGame(game1);
        player.play(game1, 10);

        Game expected = game1;
        Game actual = player.mostPlayerByGenre("Экшн");
        assertEquals(expected, actual);
    }

    @Test
    public void showMostPlayedIfTwoGames() {
        Player player = new Player("Олег");
        player.installGame(game1);
        player.play(game1, 5);
        player.installGame(game4);
        player.play(game4, 15);

        Game expected = game4;
        Game actual = player.mostPlayerByGenre("Экшн");
        assertEquals(expected, actual);
    }

    @Test
    public void showMostPlayedIfThreeGames() {
        Player player = new Player("Петр");
        player.installGame(game1);
        player.play(game1, 7);
        player.installGame(game3);
        player.play(game3, 11);
        player.installGame(game4);
        player.play(game4, 3);

        Game expected = game3;
        Game actual = player.mostPlayerByGenre("Экшн");
        assertEquals(expected, actual);
    }
}
