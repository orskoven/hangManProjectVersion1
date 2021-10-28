import com.logicbig.example.*;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import java.util.*;




public class GameMode {

    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Character> characterArrayList = new ArrayList<>();
    private ArrayList<Character> characterArrayListToBeGuessed = new ArrayList<>();
    private String charToString = "";
    private String userNameIdSave;
    private String[] stringToContainAnswers = charToString.split(",");
    private ArrayList<String> hangManDrawings = new ArrayList<String>(7);
    private String idName = null;
    private boolean isSaveNamePresent;
    private boolean isGameExitting;
    private String winningStatment;


    public GameMode() {

    }

    public boolean isSaveNamePresent() {
        return isSaveNamePresent;
    }

    public boolean isGameRunning() {
        return isGameExitting;
    }


    public ArrayList<Character> getCharacterArrayList() {
        return characterArrayList;
    }
    public void getGameFunctionalities(String wordToBeGuessed, String fileName) throws InterruptedException {
            for (int i = 0; i < wordToBeGuessed.length(); i++) {
                characterArrayListToBeGuessed.add(wordToBeGuessed.charAt(i));
                characterArrayList.add('_');
        }
        System.out.println("Let the game begin!\n" + characterArrayList);
        System.out.println(drawHangman().get(0));
        play(fileName);
        try {
            for (int i = 0, j = 0, k = 0; !isGameExitting; ) {
                ConsoleHoler4.main();
                char inputCharGuess = scanner.next().charAt(0);
                boolean saveCommand = '1' == inputCharGuess;
                if (characterArrayListToBeGuessed.contains(inputCharGuess)) {
                    do {
                        int indexToSwap = characterArrayListToBeGuessed.indexOf(inputCharGuess);
                        j = indexToSwap;
                        i = indexToSwap;
                        characterArrayListToBeGuessed.set(i, characterArrayList.set(j, characterArrayListToBeGuessed.get(i)));
                        isGameExitting = false;
                    } while (characterArrayListToBeGuessed.contains(inputCharGuess) && k < 5);
                } else if (saveCommand) {
                    String saveWord = "";
                    for (int l = 0; l < characterArrayListToBeGuessed.size(); l++) {
                        saveWord += characterArrayList.get(l);
                    }
                    System.out.println("Please type your name: ");
                    String userNameIdSave = scanner.next();
                    writerToFile(saveWord.concat(";") + wordToBeGuessed.concat(";") + k + ";" + i + ';' + j + ';' + userNameIdSave);
                    System.out.println("Do you want to exit? Y/N");
                    String inputFromUser = scanner.next();
                    if (inputFromUser.equals("Y".toLowerCase(Locale.ROOT))) {
                        isGameExitting = true;
                    } else if (inputFromUser.equals("N".toLowerCase(Locale.ROOT))) {
                        isGameExitting = false;
                    }
                } else if (inputCharGuess == '3') {
                    isGameExitting = true;
                } else {
                    k++;
                    isGameExitting = false;
                }
                if (!isGameExitting) {
                    System.out.println(characterArrayList + "\n" + hangManDrawings.get(k));
                } if (!characterArrayList.contains('_')) {
                    ConsoleHelper2.main();
                    isGameExitting = true;
                }
            }



        } catch (IndexOutOfBoundsException | InterruptedException exception) {
            isGameExitting = true;
            ConsoleHoler3.main();
        }

    }
    public void getGameFunctionalitiesForSavedGame( String savedWord, String wordToBeGuessed, int k, int i, int j) throws InterruptedException {
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
        isGameExitting = false;
        try {
            for (;!isGameExitting; ) {
              ConsoleHoler4.main();
                char inputCharGuess = scanner.next().charAt(0);
                boolean saveCommand = '1' == inputCharGuess;
                if (characterArrayListToBeGuessed.contains(inputCharGuess) && !characterArrayList.contains(inputCharGuess)) {
                    do {
                        int indexToSwap = characterArrayListToBeGuessed.indexOf(inputCharGuess);
                        i = indexToSwap;
                        j = indexToSwap;
                        characterArrayListToBeGuessed.set(i, characterArrayList.set(j, characterArrayListToBeGuessed.get(i)));
                    } while (characterArrayListToBeGuessed.contains(inputCharGuess) && k < 5);
                } else if (saveCommand) {
                    String saveWord = "";
                    for (int l = 0; l < characterArrayListToBeGuessed.size(); l++) {
                        saveWord += characterArrayList.get(l);
                    }
                    System.out.println("Please type your name: ");
                    userNameIdSave = scanner.next();
                    writerToFile(saveWord.concat(";") + wordToBeGuessed.concat(";") + k + ";" + i + ';' + j + ';'+ userNameIdSave);
                    System.out.println("Do you want to exit? Y/N");
                    String inputFromUser = scanner.next();
                    if (inputFromUser.equals("N".toLowerCase(Locale.ROOT))){
                        isGameExitting = false;
                    } else if (inputFromUser.equals("Y".toLowerCase(Locale.ROOT))) {
                        isGameExitting = true;
                    }
                } else if (inputCharGuess == '3'){
                    isGameExitting = true;
                } else {
                    k++;
                    isGameExitting = false;

                }if (!isGameExitting) {
                        System.out.println(characterArrayList + "\n" + hangManDrawings.get(k));
                } if (!characterArrayList.contains('_')) {
                    ConsoleHelper2.main();
                    isGameExitting = true;
                }
            }


        } catch (IndexOutOfBoundsException | InterruptedException exception) {
            isGameExitting = true;
            ConsoleHoler3.main();
        }

    }


    public ArrayList<String> drawHangman() {
        ConsoleHelper hangManFace = new ConsoleHelper();
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
                        "\nII                O"+
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

     public void writerToFile(String listToBeSaved) {
         try {
             Writer w = new FileWriter("resources/GameStats.csv", true);
             w.write("\r\n");
             String content = listToBeSaved;
             w.write(content);
             w.close();

             System.out.println("Saved" + "💾");
         } catch (IOException e) {
             e.printStackTrace();
             isSaveNamePresent = false;
             System.out.println("Name not found!");
         }
     }
    static void play(String filename)
    {
        try
        {
            Clip clip = AudioSystem.getClip();
            ((Clip) clip).open(AudioSystem.getAudioInputStream(new File(filename)));
            clip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

}


















