package br.usp.each.typerace.client;

import java.util.*;

public class GameInfo {

    private String nick;
    private int players;
    private int words;

    public GameInfo(String nick, int players, int words) {

        this.nick = nick;
        this.players = players;
        this.words = words;
    }

    public String getNick() {
        return nick;
    }

    public int getPlayers() {
        return players;
    }

    public int getWords() {
        return words;
    }

}
