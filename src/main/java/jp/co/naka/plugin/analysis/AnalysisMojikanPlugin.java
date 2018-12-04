package jp.co.naka.plugin.analysis;

import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.singletonMap;
public class AnalysisMojikanPlugin extends Plugin implements AnalysisPlugin {
    @Override
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return singletonMap("mojikan", MojikanAnalyzerProvider::new);
    }
}
