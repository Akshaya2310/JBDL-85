import org.gfg.DefaultKeywordAnalyzer;
import org.gfg.KeywordAnalyzerInterface;
import org.gfg.NewKeywordAnalyser;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        KeywordAnalyzerInterface keywordAnalyzer1 = new DefaultKeywordAnalyzer();
        KeywordAnalyzerInterface keywordAnalyzer = new NewKeywordAnalyser();
    }
}