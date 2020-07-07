package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = null;
        for (int x = 0; x < args.length; x++) {
            if (args[x].equals("--data")) {
                reader = new Scanner(new File(args[x + 1]));
            }
        }

        if (reader != null) {
            List<String> people = new ArrayList<>();

            while (reader.hasNextLine()) {
                people.add(reader.nextLine());
            }
            reader.close();

            reader = new Scanner(System.in);
            while (true) {
                System.out.println();
                System.out.println("=== Menu ===\n" +
                        "1. Find a person\n" +
                        "2. Print all people\n" +
                        "0. Exit");
                int input = Integer.parseInt(reader.nextLine());

                if (input == 1) {
                    System.out.println("Select a matching strategy: \nALL, ANY, NONE");
                    String in = reader.nextLine();
                    System.out.println("Enter a name or email to search all suitable people.");
                    String person = reader.nextLine();

                    FindMethods a = new FindMethods();

                    if (in.equals("ALL")) {
                        a.allFind(people, person);
                    } else if (in.equals("ANY")) {
                        a.anyFind(people, person);
                    } else if (in.equals("NONE")) {
                        a.dontFind(people, person);
                    }

                } else if (input == 2) {
                    System.out.println("=== List of people ===");
                    for (String x : people) {
                        System.out.println(x);
                    }

                } else if (input == 0) {
                    break;

                } else {
                    System.out.println("Incorrect option! Try again.");
                }
            }
        }
    }
}
