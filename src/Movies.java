import java.util.ArrayList;
import java.util.Collection;

public class Movies {
    private int year;
    private  int length;
    private static String title;
    private String subject;
    private int popularity;
    private boolean awards;

    public Movies(int year, int length, String title, String subject, int popularity, boolean awards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }
    public String getTitle() {
        return this.title;
    }


    @Override
    public String toString() {
        return "Movies{" +
                "year=" + year +
                ", length=" + length +
                ", subject='" + subject + '\'' +
                ", popularity=" + popularity +
                ", awards=" + awards +
                '}';
    }
}
