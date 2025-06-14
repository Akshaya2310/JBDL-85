package org.gfg.collections.keywordAnalyser;

import java.util.ArrayList;
import java.util.List;

// develop by B
public class DefaultKeywordAnalyzer implements KeywordAnalyzerInterface{

    private List<String> dataStore;

    public DefaultKeywordAnalyzer() {
        this.dataStore = new ArrayList<>();
    }

    @Override
    public void recordKeyword(String keyword) {
        dataStore.add(keyword);
    }

    @Override
    public List<String> getKeywords() {
        return dataStore;
    }
}
