package lesson5;

import java.util.*;

public class Main {
    /**
     * Дан текст. Нужно отсортировать слова по длине (по возрастанию) и вывести статистику на экран.
     * Регистр слова не имеет значения. Формат вывода произвольный.
     * Программа-минимум:
     * 1. Слова, состоящие из дефисов, считаем одним словом. Т.е. каких-то - одно слово из 8 символов.
     * 2. Точки и запятые не должны входить в статистику.
     *
     * Доп. задание
     * 1. * Не включать дефис в длину слова. Т.е. каких-то - одно слово из 7 символов.
     *
     * Пример:
     *
     * Это мой первый текст. Он состоит из каких-то тестовых слов и нужен для того, чтобы выполнить тестовое задание GB.
     * Данный текст не несет в себе какого-либо смысла, он просто содержит набор слов.
     *
     * 1 -> [и, в]
     * 2 -> [он, из, gb, не]
     * 3 -> [мой, для]
     * 4 -> [слов, того, себе]
     * 5 -> [текст, нужен, чтобы, несет, набор]
     * ...
     */
    public static void main(String[] args) {
        String text = "Это мой первый текст. Он состоит из каких-то тестовых слов и нужен для того," +
                " чтобы выполнить тестовое задание GB. " +
                "Данный текст не несет в себе какого-либо смысла, он просто содержит набор слов.";

        printStats(text);
    }
    static void printStats(String text) {

        String lowText = text.toLowerCase();
        String replacedText = lowText.replace(".", "");
        String replacedText1 = replacedText.replace(",", "");
        //String replacedText2 = replacedText1.replace("-", "");
        String[] splitText = replacedText1.split(" ");

        Map<Integer, List<String>> stats = new HashMap<>();

        for (int i = 0; i < splitText.length; i++){
            List<String> list1 = new ArrayList<String>();
            if (!stats.containsKey(splitText[i].length())){
                for (int j = 0; j < splitText.length; j++){
                    if (splitText[i].length() == splitText[j].length()){
                        list1.add(splitText[j]);
                    }
                }
                stats.put(splitText[i].length(), list1);
            }
        }
        //System.out.println(stats);
        for (Integer key: stats.keySet()){
            System.out.println(key + " = " + stats.get(key));
        }
    }
}
