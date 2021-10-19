import java.util.ArrayList;
import java.util.Arrays;

public class GameMode{
    private ArrayList<Character> characterArrayList = new ArrayList<>();
    private String charToString = "";
    private String[] stringToContainAnswers = charToString.split(",");

    public GameMode() {
    }

    public void getGameFunctionalities(char charGuess, String wordToBeGuessed){
        for (int i = 0; i < wordToBeGuessed.length() ; i++) {
            characterArrayList.add('_');
            charToString = characterArrayList.toString();
        }
        System.out.println(characterArrayList);
        System.out.println(Arrays.toString(stringToContainAnswers));

    }

}
