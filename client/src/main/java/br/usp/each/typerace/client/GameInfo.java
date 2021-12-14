package br.usp.each.typerace.client;

import java.util.*;

public class GameInfo {

    private List<String> nick;
    private int players;
    private int words;

    public GameInfo(List<String> nick, int players, int words) {

        this.nick = nick;
        this.players = players;
        this.words = words;
    }

    public List<String> getNick() {
        return nick;
    }

    public int getPlayers() {
        return players;
    }

    public int getWords() {
        return words;
    }

}
