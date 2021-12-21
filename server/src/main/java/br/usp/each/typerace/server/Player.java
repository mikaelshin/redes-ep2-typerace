package br.usp.each.typerace.server;
import java.util.*;

public class Player {
    
    private int id;
    private String nick;
    private int points;
    private int errors;
    private static Map<String, Player> instances = new HashMap<>();
    
    public Player(int id, String nick, int points) {

        this.id = id;
        this.nick = nick;
        this.points = points;
        
        instances.put(this.nick, this);
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

    public int getErrors() {

        return this.errors;
    }

    public void setErrors() {

        this.errors++;
    }

    public String getNick() {

        return this.nick;
    }

    public static Map<String, Player> getInstances() {

        return instances;
    }
}
