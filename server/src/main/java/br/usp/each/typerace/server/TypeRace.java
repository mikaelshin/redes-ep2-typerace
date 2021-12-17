package br.usp.each.typerace.server;

import java.io.*;
import java.util.*;

public class TypeRace {

    public static List<String> getWordsList(int length) {

        List<String> wordsStock = wordsStock();
        List<String> wordsList = new ArrayList<>();

        for (int i = 0; i < length; i++) {

            Random rand = new Random();
            String word = wordsStock().get(rand.nextInt(wordsStock.size()));

            wordsList.add(word);
        }

        return wordsList;
    }

    public static int setPoints(List<String> wordsList, String typedWord, int points, int cont) {

        if (typedWord.equals(wordsList.get(cont)))
            return points++;

        else return points;
    }

    private static List<String> wordsStock() {

        List<String> words = new ArrayList<>();
        words.add("arroz");
        words.add("usp");
        words.add("sistemas");
        words.add("informação");
        words.add("daniel");
        words.add("álcool");
        words.add("pandemia");
        words.add("garrafa");
        words.add("úmido");
        words.add("sherlock");
        words.add("bloco");
        words.add("notas");
        words.add("notebook");
        words.add("exercício");
        words.add("programa");
        words.add("redes");
        words.add("computadores");
        words.add("maluco");
        words.add("feliz");
        words.add("modesto");
        words.add("amor");
        words.add("abraço");
        words.add("característica");
        words.add("ortorrinolaringologista");
        words.add("coração");
        words.add("bochecha");
        words.add("presunto");
        words.add("salgado");
        words.add("excelência");
        words.add("suco");
        words.add("mamão");
        words.add("morango");
        words.add("estável");
        words.add("hierarquia");
        words.add("analista");
        words.add("futebol");
        words.add("imortal");
        words.add("xadrez");
        words.add("alicate");
        words.add("corrida");
        words.add("digitação");
        words.add("repositório");
        words.add("grupo");

        return words;
    }
}