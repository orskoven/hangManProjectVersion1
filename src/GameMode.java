import java.io.*;
import java.util.*;




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
        }
        System.out.println("Let the game begin!\n" + characterArrayList);
        System.out.println(drawHangman().get(0));
        try {
            for (int i = 0, j = 0, k = 0; /*i < characterArrayListToBeGuessed.size() && j < characterArrayList.size()*/; ) {
                System.out.println("Please type a letter to guess:\nor 1 to save");
                char inputCharGuess = scanner.next().charAt(0);
                boolean saveCommand = '1' == inputCharGuess;
                if (characterArrayListToBeGuessed.contains(inputCharGuess)) {
                    do {
                        int indexToSwap = characterArrayListToBeGuessed.indexOf(inputCharGuess);
                        j = indexToSwap;
                        i = indexToSwap;
                        characterArrayListToBeGuessed.set(i, characterArrayList.set(j, characterArrayListToBeGuessed.get(i)));
                        //i++;
                        // j++;
                    } while (characterArrayListToBeGuessed.contains(inputCharGuess) && k < 5);
                } else if (saveCommand){
                    writerToFile(characterArrayList);
                } else {
                    k++;
                }
                System.out.println(characterArrayList + "\n" + hangManDrawings.get(k));
            }


        } catch (IndexOutOfBoundsException exception) {
            System.out.println("GAME OVER!!");
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
                        "\nII               / \\" +
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
                        "\nII               / \\" +
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
                        "\nII               / \\" +
                        "\nII" +
                        "\nII" +
                        "\nII" +
                        "\nIIIIIIIIIIIIIIIIIII");

        return hangManDrawings;
    }

    // got inspiration from https://www.javatpoint.com/java-writer-class

     static void writerToFile(ArrayList<Character> listToBeSaved) {
        try {
            Writer w = new FileWriter("resources/GameStats.csv");
            ArrayList<Character> content = listToBeSaved;
            w.write(String.valueOf(content));
            w.close();
            System.out.println("Saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

















