package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Alex", 50);
    Player player2 = new Player(2, "Viki", 52);
    Player player3 = new Player(3, "Nicolas", 48);
    Player player4 = new Player(4, "Nick", 55);
    Player player5 = new Player(5, "Lee", 48);

    @Test
    public void shouldCompareTwoRegisteredPlayersWithEqualStrength() {
        Game regPlayers = new Game();
        regPlayers.register(player3);
        regPlayers.register(player5);

        int exp = 0;
        int act = regPlayers.round(player3.getName(), player5.getName());

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldCompareTwoRegisteredPlayersIfFirstPlayerIsStrongest() {
        Game regPlayers = new Game();
        regPlayers.register(player1);
        regPlayers.register(player3);

        int exp = 1;
        int act = regPlayers.round(player1.getName(), player3.getName());

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldCompareTwoRegisteredPlayersIfFirstPlayerIsNotStrongest() {
        Game regPlayers = new Game();
        regPlayers.register(player2);
        regPlayers.register(player4);

        int exp = 2;
        int act = regPlayers.round(player2.getName(), player4.getName());
    }

    @Test
    public void shouldCompareStrengthIfFirstPlayerIsNotRegistered() {
        Game regPlayers = new Game();
        regPlayers.register(player1);
        regPlayers.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            regPlayers.round(player2.getName(), player4.getName());
        });
    }

    @Test
    public void shouldCompareStrengthIfSecondPlayerIsNotRegistered() {
        Game regPlayers = new Game();
        regPlayers.register(player2);
        regPlayers.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            regPlayers.round(player2.getName(), player3.getName());
        });
    }

    @Test
    public void shouldCompareStrengthIfBothPlayersAreNotRegistered() {
        Game regPlayers = new Game();
        regPlayers.register(player1);
        regPlayers.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            regPlayers.round(player3.getName(), player4.getName());
        });
    }
}
