import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

public class GameMode {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Character> characterArrayList = new ArrayList<>();
    private ArrayList<Character> characterArrayListToBeGuessed = new ArrayList<>();
    private String charToString = "";
    private String[] stringToContainAnswers = charToString.split(",");

    public GameMode() {
    }

    public void getGameFunctionalities(String wordToBeGuessed) {
        for (int i = 0; i < wordToBeGuessed.length(); i++) {
            characterArrayListToBeGuessed.add(wordToBeGuessed.charAt(i));
            characterArrayList.add('_');

            //Inspiration from : https://stackoverflow.com/questions/36170017/swapping-out-elements-between-arraylists
        }
        for (int i = 0, j = 0; i < characterArrayListToBeGuessed.size() && j < characterArrayList.size(); i++, j++) {
            System.out.println("Please type a letter to guess: ");
            char inputCharGuess = scanner.next().charAt(0);
            characterArrayList.add(inputCharGuess);
            if (characterArrayListToBeGuessed.contains(inputCharGuess) && characterArrayList.get(i) == characterArrayList.get(j)) {

                characterArrayListToBeGuessed.set(i, characterArrayList.set(j, characterArrayListToBeGuessed.get(i)));
            } else {
                i--;
                j--;

            }
            //System.out.println(characterArrayListToBeGuessed);
            System.out.println(characterArrayList);
        }


        }
    }













