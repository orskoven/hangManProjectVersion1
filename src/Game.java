import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> allMoviesTitle = new ArrayList<String>();
    static ArrayList<Movies> movies = new ArrayList<>();
    static ArrayList<Character> savedWord = new ArrayList<>();


    public static void main(String[] args) {

            System.out.println("Welcome to the frog and movie hang man the game edition!\n______\nPress 1 if you are a grashoppa' (easy/frog mode) " +
                    "\n____\nPress 2 for movie title/hard mode!!\n___\nPress X to exit!!\n__\nPress 3 to continue saved game");
               int inputFromUser = scanner.nextInt();
               if (inputFromUser == 1) {
                   GameMode easyGame = new GameMode();
                   easyGame.getGameFunctionalities(getRandomFrogName(getAllFrogNames()).toLowerCase(Locale.ROOT));
               } else if (inputFromUser == 2){
                   GameMode hardGame = new GameMode();
                   System.out.println("Subject: " + getAllMoviesList().get(randomizer()).getSubject() + "\nYear: "+
                           getAllMoviesList().get(randomizer()).getYear());
                   hardGame.getGameFunctionalities( getAllMoviesList().get(randomizer()).getTitle());
               }  else if (inputFromUser == 3){
                   GameMode savedGame = new GameMode();
                   savedGame.getGameFunctionalities(getSavedGame());
               }
        }

        static int randomizer(){
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
    static String getSavedGame() {
        File populationFiles = new File("resources/GameStats.csv");
        try {
            Scanner sc = new Scanner(populationFiles);
            while (sc.hasNext()) {
                char line = sc.next().charAt(0);
                System.out.println(line);
                savedWord.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }
        return savedWord.toString() ;
    }

}
