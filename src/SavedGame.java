import java.util.ArrayList;
import java.util.Collection;

class SavedGame {
    private String saveWord;
    private String wordToBeGuessed;
    private  int k;
    private int i;
    private int j;
    private String idName;
    static ArrayList<SavedGame> savedGames = new ArrayList<SavedGame>();


    public SavedGame(String saveWord, String wordToBeGuessed, int k, int i, int j, String idName) {
        this.saveWord = saveWord;
        this.wordToBeGuessed = wordToBeGuessed;
        this.k = k;
        this.i = i;
        this.j = j;
        this.idName = idName;
    }

    public String getIdName() {
        return idName;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getK() {
        return k;
    }

    public String getSaveWord() {
        return saveWord;
    }

    public String getWordToBeGuessed() {
        return wordToBeGuessed;
    }

    public ArrayList<SavedGame> getSavedGames(){
        for (int i = 0; i < savedGames.size();i++){
            savedGames.add(new SavedGame(this.saveWord, this.wordToBeGuessed, this.k, this.i, this.j,this.idName));
            i++;
        }
        return savedGames;
    }


    @Override
    public String toString() {
        return "savedGame{" +
                "saveWord='" + saveWord + '\'' +
                ", wordToBeGuessed='" + wordToBeGuessed + '\'' +
                ", k=" + k +
                ", i=" + i +
                ", j=" + j +
                ", idName" + idName +
                '}';
    }

}
