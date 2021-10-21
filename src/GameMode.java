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
    private ArrayList<String> hangManDrawings = new ArrayList<String>(7);


    public GameMode() {

    }

    public ArrayList<Character> getCharacterArrayList() {
        return characterArrayList;
    }

    public void getGameFunctionalities(String wordToBeGuessed) {
        for (int i = 0; i < wordToBeGuessed.length(); i++) {
            characterArrayListToBeGuessed.add(wordToBeGuessed.charAt(i));
            characterArrayList.add('_');

            //Inspiration from : https://stackoverflow.com/questions/36170017/swapping-out-elements-between-arraylists

        } System.out.println("The word to be guessed is this long: "+ characterArrayList);
        System.out.println(drawHangman().get(0));
        for (int i = 0, j = 0, k = 0; i < characterArrayListToBeGuessed.size() && j < characterArrayList.size() || k > 7;) {
            System.out.println("Please type a letter to guess: ");
            char inputCharGuess = scanner.next().charAt(0);
            if (characterArrayListToBeGuessed.contains(inputCharGuess)) {
                do {
                    int indexToSwap = characterArrayListToBeGuessed.indexOf(inputCharGuess);
                    j = indexToSwap;
                    i = indexToSwap;
                    characterArrayListToBeGuessed.set(i, characterArrayList.set(j, characterArrayListToBeGuessed.get(i)));
                    i++;
                    j++;
                } while (characterArrayListToBeGuessed.contains(inputCharGuess));
            } else {
                k++;
            }
            System.out.println(characterArrayList +"\n" +hangManDrawings.get(k));
        }


    }
    public ArrayList<String> drawHangman() {
            hangManDrawings.add("IIIIIIIIIIIIIIIIIII" +
                              "\nII                I" +
                              "\nII                I" +
                              "\nII                I" +
                              "\nII" +
                              "\nII" +
                              "\nII" +
                              "\nII" +
                              "\nII" +
                              "\nII" +
                              "\nIIIIIIIIIIIIIIIIIII");
            hangManDrawings.add(
                      "IIIIIIIIIIIIIIIIIII" +
                    "\nII                I" +
                    "\nII                I" +
                    "\nII                I" +
                    "\nII                O" +
                    "\nII" +
                    "\nII" +
                    "\nII" +
                    "\nII" +
                    "\nII" +
                    "\nIIIIIIIIIIIIIIIIIII");
            hangManDrawings.add(
                              "IIIIIIIIIIIIIIIIIII" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                O" +
                            "\nII                I" +
                            "\nII" +
                            "\nII" +
                            "\nII" +
                            "\nII" +
                            "\nIIIIIIIIIIIIIIIIIII");
            hangManDrawings.add(
                              "IIIIIIIIIIIIIIIIIII" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                O" +
                            "\nII                I" +
                            "\nII                \\" +
                            "\nII" +
                            "\nII" +
                            "\nII" +
                            "\nIIIIIIIIIIIIIIIIIII");
            hangManDrawings.add(
                              "IIIIIIIIIIIIIIIIIII" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                O" +
                            "\nII                I" +
                            "\nII               /\\" +
                            "\nII" +
                            "\nII" +
                            "\nII" +
                            "\nIIIIIIIIIIIIIIIIIII");
            hangManDrawings.add(
                              "IIIIIIIIIIIIIIIIIII" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                O" +
                            "\nII               -I" +
                            "\nII               /\\" +
                            "\nII" +
                            "\nII" +
                            "\nII" +
                            "\nIIIIIIIIIIIIIIIIIII");
            hangManDrawings.add(
                              "IIIIIIIIIIIIIIIIIII" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                O" +
                            "\nII               -I-" +
                            "\nII               /\\" +
                            "\nII" +
                            "\nII" +
                            "\nII" +
                            "\nIIIIIIIIIIIIIIIIIII");

        return hangManDrawings;
    }
}
















