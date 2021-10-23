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
    //little inspiration from : https://stackoverflow.com/questions/36170017/swapping-out-elements-between-arraylists
    public void getGameFunctionalities(String wordToBeGuessed) {
            for (int i = 0; i < wordToBeGuessed.length(); i++) {
                characterArrayListToBeGuessed.add(wordToBeGuessed.charAt(i));
                characterArrayList.add('_');
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
                    String saveWord = "";
                    for (int l = 0; l < characterArrayListToBeGuessed.size(); l++) {
                        saveWord += characterArrayList.get(l);
                    }
                    System.out.println("Please type your name: ");
                    String userNameIdSave = scanner.next();
                    writerToFile(saveWord.concat(";") + wordToBeGuessed.concat(";") + k + ";" + i + ';' + j + ';'+ userNameIdSave);
                    k = 7;
                } else {
                    k++;
                }
                System.out.println(characterArrayList + "\n" + hangManDrawings.get(k));
            }


        } catch (IndexOutOfBoundsException exception) {
            System.out.println("GAME OVER!!");
            System.out.println(
                              "IIIIIIIIIIIIIIIIIII" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                😵" +
                            "\nII               -I-" +
                            "\nII               / \\" +
                            "\nII" +
                            "\nII" +
                            "\nII" +
                            "\nIIIIIIIIIIIIIIIIIII");
        }

    }
    public void getGameFunctionalitiesForSavedGame( String savedWord, String wordToBeGuessed, int k, int i, int j) {
        for (int l = 0; l < savedWord.length(); l++) {
            characterArrayList.add(savedWord.charAt(l));
        }
        for (int p = 0; p < wordToBeGuessed.length(); p++) {
            characterArrayListToBeGuessed.add(wordToBeGuessed.charAt(p));
            if (!characterArrayList.contains('_'))
            characterArrayList.add('_');
        }
        System.out.println("Let's start were you left!\n" + characterArrayList);
        System.out.println(drawHangman().get(k));
        try {
            for (int u = i,y = k, z = j; /*i < characterArrayListToBeGuessed.size() && j < characterArrayList.size()*/; ) {
                System.out.println("Please type a letter to guess:\nor 1 to save");
                char inputCharGuess = scanner.next().charAt(0);
                boolean saveCommand = '1' == inputCharGuess;
                if (characterArrayListToBeGuessed.contains(inputCharGuess)) {
                    do {
                        int indexToSwap = characterArrayListToBeGuessed.indexOf(inputCharGuess);
                        i = indexToSwap;
                        j = indexToSwap;
                        characterArrayListToBeGuessed.set(i, characterArrayList.set(j, characterArrayListToBeGuessed.get(i)));
                        //i++;
                        // j++;
                    } while (characterArrayListToBeGuessed.contains(inputCharGuess) && k < 5);
                } else if (saveCommand) {
                    String saveWord = "";
                    for (int l = 0; l < characterArrayListToBeGuessed.size(); l++) {
                        saveWord += characterArrayList.get(l);
                    }
                    System.out.println("Please type your name: ");
                    String userNameIdSave = scanner.next();
                    writerToFile(saveWord.concat(";") + wordToBeGuessed.concat(";") + k + ";" + i + ';' + j + ';'+ userNameIdSave);
                    k = 7;
                } else {
                    k++;
                }
                System.out.println(characterArrayList + "\n" + hangManDrawings.get(k));
            }


        } catch (IndexOutOfBoundsException exception) {
            System.out.println("GAME OVER!!");
            System.out.println(
                              "IIIIIIIIIIIIIIIIIII" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                I" +
                            "\nII                😵" +
                            "\nII               -I-" +
                            "\nII               / \\" +
                            "\nII" +
                            "\nII" +
                            "\nII" +
                            "\nIIIIIIIIIIIIIIIIIII");
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

     static void writerToFile(String listToBeSaved) {
        try {
            Writer w = new FileWriter("resources/GameStats.csv");
            String content = listToBeSaved;
            w.write(content);
            w.close();
            System.out.println("Saved"+"💾");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

















