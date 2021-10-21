import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Game {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

            System.out.println("Welcome to the frog and movie hang man the game edition!\n\nPress 1 if you are a grashoppa' (easy/frog mode) \n\nPress any other number for movie title/hard mode!!\n\nPress X to exit!!");
               int inputFromUser = scanner.nextInt();
                GameMode easyGame = new GameMode();
               GameMode hardGame = new GameMode();
               if (inputFromUser == 1) {
                   easyGame.getGameFunctionalities(getRandomFrogName(getAllFrogNames()).toLowerCase(Locale.ROOT));
               } else {
                   hardGame.getGameFunctionalities(getRandomMovieTitle(getAllMovies()).toLowerCase(Locale.ROOT));
               }
        }



    static String getRandomMovieTitle(ArrayList<String> movies) {
        Random random = new Random();
        int randomNumber = random.nextInt(1583 - 1) + 1;
        return movies.get(randomNumber);
    }

    static ArrayList<String> getAllMovies() {
        ArrayList<String> allMoviesTitle = new ArrayList<>();
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


            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }
        return allMoviesTitle;
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
}
