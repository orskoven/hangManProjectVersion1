import java.util.ArrayList;
import java.util.Collection;

 class Movies {
    private int year;
    private  int length;
    private  String title;
    private String subject;
    private int popularity;
    private boolean awards;
    static ArrayList<Movies> movies = new ArrayList<Movies>(1583);


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

    public String getSubject() {
        return subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getYear() {
        return year;
    }
     public ArrayList<Movies> getMovies(){
        for (int i = 0; i < movies.size();i++){
            movies.add(new Movies(this.year, this.length, this.title, this.subject, this.popularity, this.awards));
            i++;
        }
        return movies;
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
