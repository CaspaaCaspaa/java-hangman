package pl.edu.agh.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Word {
    List<String> words = new ArrayList<>();
    String word;

    public void initialize() throws FileNotFoundException {
        this.modeSetup();
    }



    private void fileReader() throws FileNotFoundException {
    Scanner fileScanner = new Scanner(new File("src/main/resources/slowa.txt"));

        while (fileScanner.hasNext()) {
        words.add(fileScanner.nextLine().toLowerCase());
         }

    Random rand = new Random();
    word = words.get(rand.nextInt(words.size()));
    }

    private void modeSetup () throws FileNotFoundException {
        Scanner modeInput = new Scanner(System.in);
        System.out.println("Choose game mode:");
        System.out.println("Mode 1 to read random word from file");
        System.out.println("Mode 2 to choose random word length");
        System.out.println("Mode 3 to read word from Wordnik");

        String input = String.valueOf(modeInput.nextInt());
        if (input.equals("1")){
            this.fileReader();
        }
        if (input.equals("2")) {
            System.out.println("MODE NOT IMPLEMENTED");
            System.out.println("Switching to Mode 1");
            this.fileReader();
        }
        if (input.equals("3")) {
            System.out.println("MODE NOT IMPLEMENTED");
            System.out.println("Switching to Mode 1");
            this.fileReader();
        }
    }

}
