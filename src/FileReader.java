import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FileReader {
    private static Object Country;
    private static ArrayList<Movies> allMovies = new ArrayList<>();

     static void main(String[] args) {
        ArrayList<Integer> allMoviesTitleLength = new ArrayList<>();
        File populationFiles = new File("resources/movies.csv");
        String theLongestMovieTitle = "";
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
                allMoviesTitleLength.add(currentMovie.getTitleLength());
                System.out.println("The longest movie title is: " + getLongestMovieTitle(allMoviesTitleLength, currentMovie));
                allMovies.add(currentMovie);


            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }

        allMoviesTitleLength.stream().max(Integer::compare).get();

    }

    public static void setAllMovies(ArrayList<Movies> allMovies) {
        FileReader.allMovies = allMovies;
    }

    public static ArrayList<Movies> getAllMovies() {
        return allMovies;
    }

    static String getLongestMovieTitle(ArrayList<Integer> movieTitleLengths, Movies currentMovie) {
        String movieTitle = "";
        int theLengthOfLongestMovie = movieTitleLengths.stream().max(Integer::compare).get();
        if (currentMovie.getTitleLength() == theLengthOfLongestMovie) {
            movieTitle = currentMovie.getTitle();
        }
        return movieTitle;
    }
}