package pl.edu.agh.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {


    public static void main(String[] args) throws FileNotFoundException {
        gameEngine();
    }

    private static void gameEngine() throws FileNotFoundException {
        HangmanBody hangman = new HangmanBody();
        Scanner playerInput = new Scanner(System.in);
        Word wordForGame = new Word();
        wordForGame.initialize();
        String word = wordForGame.word;

        List<Character> playerInputs = new ArrayList<>();

        int wrongGuessCounter = 0;

        //System.out.println(word);

        hangman.printHangmanState(wrongGuessCounter);

        printProgress(word, playerInputs);


        while(true) {
           //printProgress(word, playerInputs);
           if (!guessRound(playerInput, word, playerInputs)) {
            wrongGuessCounter++ ;
            System.out.println("wrong:"+wrongGuessCounter);
            };
            hangman.printHangmanState(wrongGuessCounter);

            if(printProgress(word, playerInputs)) {
              System.out.println("You win!");
              break ;
           }
           if (wrongGuessCounter == (hangman.HANGMANPICS.length - 1)){
               System.out.println("You lost!");
               System.out.println("Word was: "+ word);

               break ;
           };
        }
    }


    private static boolean guessRound(Scanner playerInput, String word, List<Character> playerInputs) {
        System.out.println("Guess a letter");
        String playerGuess = playerInput.next();
        playerInputs.add(playerGuess.charAt(0));
        return word.contains(playerGuess);

    }

    private static boolean printProgress(String word, List<Character> playerInputList) {
        int correctGuessCoutner = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerInputList.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctGuessCoutner ++;
            } else {
                System.out.print("_");
            }
        }
        System.out.println();
        return (correctGuessCoutner == word.length());
    }
}


