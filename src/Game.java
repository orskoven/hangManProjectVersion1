


import com.logicbig.example.ConsoleHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> allMoviesTitle = new ArrayList<String>();
    static ArrayList<Movies> movies = new ArrayList<>();
    static ArrayList<SavedGame> savedGames = new ArrayList<>();
    static String idNameInput;
    static SavedGame savedGameToLoad;
    static boolean isGameRunning;
    static String lastLine = "";
    static String ani;
    static String endString;
    static String animate;


    public static void main(String[] args) throws InterruptedException {
        do{
            ConsoleHelper.main();
            System.out.println("\n\nPress 1 - FROG MODE\n_________________________________________________\n\n\n" +
                    "Press 2 - MOVIE MODE\n_________________________________________________\n\n\nPress 3 - SAVED GAME\n_________________________________________________\n\n\n" +
                    "Press X - EXIT\n_________________________________________________");
            int inputFromUser = scanner.nextInt();
            if (inputFromUser == 1) {
                GameMode easyGame = new GameMode();
                easyGame.getGameFunctionalities(getRandomFrogName(getAllFrogNames()).toLowerCase(Locale.ROOT));
                isGameRunning = easyGame.isGameRunning();
            } else if (inputFromUser == 2) {
                GameMode hardGame = new GameMode();
                System.out.println("Subject: " + getAllMoviesList().get(randomizer()).getSubject() + "\nYear: " +
                        getAllMoviesList().get(randomizer()).getYear() + "\nPopularity: " + getAllMoviesList().get(randomizer()).getPopularity());
                hardGame.getGameFunctionalities(getAllMoviesList().get(randomizer()).getTitle());
                isGameRunning = hardGame.isGameRunning();
            } else if (inputFromUser == 3) {
                GameMode savedGame = new GameMode();
                do {
                    System.out.println("Please type your name: ");
                    idNameInput = scanner.next();
                    savedGame.getGameFunctionalitiesForSavedGame(getSavedGame().getSaveWord(), getSavedGame().getWordToBeGuessed(), getSavedGame().getK(),
                            getSavedGame().getI(), getSavedGame().getJ());
                    isGameRunning = savedGame.isGameRunning();
                } while (savedGame.isSaveNamePresent());

            }
        } while (isGameRunning);
    }

    static int randomizer() {
        Random random = new Random();
        return random.nextInt(1583 - 1) + 1;
    }


    static String getAllMoviesTitle(ArrayList<Movies> movies) {
        return movies.get(randomizer()).getTitle();

    }

    static ArrayList<Movies> getAllMoviesList() {
        File populationFiles = new File("resources/movies.csv");
        try {
            Scanner sc = new Scanner(populationFiles);
            while (sc.hasNextLine()) {
                // Få mappet dataværdier til et object
                String line = sc.nextLine();
                String[] stringLikeArray = line.split(";");
                int movieYear = Integer.parseInt(stringLikeArray[0]);
                int movieLength = Integer.parseInt(stringLikeArray[1]);
                String movieTitle = stringLikeArray[2];
                String movieSubject = stringLikeArray[3];
                int moviePopularity = Integer.parseInt(stringLikeArray[4]);
                boolean movieAwards = Boolean.parseBoolean(stringLikeArray[4]);
                Movies currentMovie = new Movies(movieYear, movieLength, movieTitle, movieSubject, moviePopularity, movieAwards);
                allMoviesTitle.add(currentMovie.getTitle());
                movies.add(currentMovie);


            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }
        return movies;
    }

    static ArrayList<String> getAllFrogNames() {
        ArrayList<String> allFrogNames = new ArrayList<>();
        File populationFiles = new File("resources/frogs.csv");
        try {
            Scanner sc = new Scanner(populationFiles);
            while (sc.hasNextLine()) {
                // Få mappet dataværdier til et object
                String line = sc.nextLine();
                String[] stringLikeArray = line.split(";");
                String frogName = stringLikeArray[0];
                Frogs currentFrog = new Frogs(frogName);
                allFrogNames.add(currentFrog.getName());


            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }
        return allFrogNames;
    }

    static String getRandomFrogName(ArrayList<String> frogs) {
        Random random = new Random();
        int randomNumber = random.nextInt(78 - 1) + 1;
        return frogs.get(randomNumber);
    }

    static SavedGame getSavedGame() {
        File populationFiles = new File("resources/GameStats.csv");
        try {
            Scanner sc = new Scanner(populationFiles);
            while (sc.hasNextLine()) {
                // Få mappet dataværdier til et object
                String line = sc.nextLine();
                String[] stringLikeArray = line.split(";");
                String savedWord = stringLikeArray[0];
                String wordToBeGuessed = stringLikeArray[1];
                int k = Integer.parseInt(stringLikeArray[2]);
                int i = Integer.parseInt(stringLikeArray[3]);
                int j = Integer.parseInt(stringLikeArray[4]);
                String idName = stringLikeArray[5];
                if (Objects.equals(idNameInput, idName)) {
                    savedGameToLoad = new SavedGame(savedWord, wordToBeGuessed, k, i, j, idName);
                } else {
                    System.out.println("Name could not be found!");
                }


            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }
        return savedGameToLoad;
    }


}






