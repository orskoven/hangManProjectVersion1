import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Game {
    public static void main(String[] args) {
        GameMode gameTest = new GameMode();
        gameTest.getGameFunctionalities(getRandomMovieTitle(getAllMovies()).toLowerCase(Locale.ROOT));

    }

    static String getRandomMovieTitle(ArrayList<String> movies){
        Random random = new Random();
        int randomNumber = random.nextInt(100 - 1)+1;
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

    }
