package br.usp.each.typerace.server;


import java.io.*;
import java.util.*;


public class TypeRace {

    public static List<String> getWordsListFromFile(int length) {

        String randomWord = "";
        List<String> wordsList = new ArrayList<String>();

        try {

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("./sherlock.txt"), "UTF-8"));
            String line = reader.readLine();
            List<String> words = new ArrayList<String>();

            while (line != null) {

                String[] wordsLine = line.split(" ");

                for(String word : wordsLine)
                    words.add(word);

                line = reader.readLine();
            }

            Random random = new Random(System.currentTimeMillis());

            while (wordsList.size() != length) {

                while (randomWord.length() < 5)
                    randomWord = words.get(random.nextInt(words.size()));

                wordsList.add(randomWord.trim().toLowerCase());
                randomWord = "";
            }

            reader.close();

        } catch (Exception e) {

            e.getMessage();
        }

        return wordsList;
    }

    public static int setPoints(List<String> wordsList, String typedWord, int points, int cont) {

        if (typedWord.equals(wordsList.get(cont)))
            return points + 5;

        else return points;
    }
}
