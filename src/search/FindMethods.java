package search;

import java.util.ArrayList;
import java.util.List;

public class FindMethods {

    public FindMethods() {};

    public static void allFind(List<String> words, String word) {
        String[] query = word.split("\\s+");
        List<String> list = new ArrayList<>();

        for (int x = 0; x < words.size(); x++) {
            String hold = words.get(x).toLowerCase();
            boolean check = true;
            for (String s : query) {
                if (!hold.contains(s)) {
                    check = false;
                }
            }
            if (check) {
                list.add(words.get(x));
            }
        }
        printFindings(list);
    }

    public static void anyFind(List<String> words, String word) {
        String[] query = word.split("\\s+");
        List<String> list = new ArrayList<>();

        for (int x = 0; x < words.size(); x++) {
            String hold = words.get(x).toLowerCase();
            boolean check = false;
            for (String s : query) {
                if (hold.contains(s)) {
                    check = true;
                }
            }
            if (check) {
                list.add(words.get(x));
            }
        }
        printFindings(list);
    }


    public static void dontFind(List<String> words, String word) {
        String[] query = word.split("\\s+");
        List<String> list = new ArrayList<>();

        for (int x = 0; x < words.size(); x++) {
            String hold = words.get(x).toLowerCase();
            boolean check = true;
            for (String s : query) {
                s = s.toLowerCase();
                if (hold.contains(s)) {
                    check = false;
                }
            }
            if (check) {
                list.add(words.get(x));
            }
        }
        printFindings(list);
    }

    public static void printFindings(List<String> list) {
        if (list.size() != 0) {
            System.out.println("Found people: ");
            for (String s : list) {
                System.out.println(s);
            }
        } else {
            System.out.println("No matching people found.");
        }
    }

}
