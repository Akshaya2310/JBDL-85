package org.gfg.collections.keywordAnalyser;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KeywordFreqAnalyzerImp implements KeywordAnalyzerInterface{

    private Map<String,Long> map;

    public KeywordFreqAnalyzerImp() {
        this.map = new LinkedHashMap<>();
    }

    @Override
    public void recordKeyword(String keyword) {
        map.put(keyword,map.getOrDefault(keyword,0l)+1);
    }

    @Override
    public List<String> getKeywords() {
        return map.keySet().stream().toList();
    }

    @Override
    public Map<String, Long> getKeywordFreq() {
        return map;
    }
}
