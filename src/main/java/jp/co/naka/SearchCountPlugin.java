package jp.co.naka;

import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.AnalysisPlugin;

public class SearchCountPlugin extends Plugin implements AnalysisPlugin {
    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>>
        analyzers = new HashMap();
        analyzers.put(CustomEnglishAnalyzerProvider.NAME,
                      CustomEnglishAnalyzerProvider::getCustomEnglishAnalyzerProvider);
        return analyzers;
    }
}
