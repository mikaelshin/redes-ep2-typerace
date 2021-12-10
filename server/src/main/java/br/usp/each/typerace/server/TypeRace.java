package br.usp.each.typerace.server;

import java.io.*;
import java.util.*;

public class TypeRace {

    public static List<String> getWordsListFromFile(int qtd) {

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

            while (wordsList.size() != qtd) {

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
}
