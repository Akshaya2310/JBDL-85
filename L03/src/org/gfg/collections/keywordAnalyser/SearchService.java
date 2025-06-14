package org.gfg.collections.keywordAnalyser;

import java.util.List;

public class SearchService {


    public static void main(String[] args) {
        //KeywordAnalyzerInterface keywordAnalyzer = new DefaultKeywordAnalyzer();
        //KeywordAnalyzerInterface keywordAnalyzer = new UniqueKeywordAnalyzerImpl();
        KeywordAnalyzerInterface keywordAnalyzer = new KeywordFreqAnalyzerImp();

        keywordAnalyzer.recordKeyword("Pen");
        keywordAnalyzer.recordKeyword("Paper");
        keywordAnalyzer.recordKeyword("Laptop");
        keywordAnalyzer.recordKeyword("Mobile");
        keywordAnalyzer.recordKeyword("Laptop");
        keywordAnalyzer.recordKeyword("Paper");

        System.out.println(keywordAnalyzer.getKeywords());

        System.out.println(keywordAnalyzer.getKeywordFreq());

    }



    public List<String> getAllProduct(String keyword){

        KeywordAnalyzerInterface keywordAnalyzer = new MockKeywordAnalyzerImp();
        keywordAnalyzer.recordKeyword(keyword);


        /*

         */
        return null;
    }
}
