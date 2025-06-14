package org.gfg.collections.keywordAnalyser;

import java.util.List;
import java.util.Map;

public interface KeywordAnalyzerInterface {

    void recordKeyword(String keyword);

    List<String> getKeywords();

    default Map<String,Long> getKeywordFreq(){
        return null;
    }
}
