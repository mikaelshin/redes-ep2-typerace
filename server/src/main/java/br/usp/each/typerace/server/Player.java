package br.usp.each.typerace.server;

public class Player {
    
    private int id;
    private String nick;
    private int points;
    
    public Player(int id, String nick, int points) {

        this.id = id;
        this.nick = nick;
        this.points = points;
    }

    public int getId() {

        return this.id;
    }
    public int getPoints() {

        return this.points;
    }

    public void setPoints() {

        this.points++;
    }

    public String getNick() {

        return this.nick;
    }
}
