package jp.co.naka.index.analysis;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.ja.JapaneseAnalyzer;
import org.apache.lucene.analysis.ja.JapaneseTokenizer;
import org.apache.lucene.analysis.ja.dict.UserDictionary;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import java.util.Set;

public class MojikanAnalyzerProvider extends AbstractIndexAnalyzerProvider<JapaneseAnalyzer> {

    public MojikanAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
        final Set<?> stopWords = Analysis.parseStopWords(
            env, indexSettings.getIndexVersionCreated(), settings, JapaneseAnalyzer.getDefaultStopSet());
        final JapaneseTokenizer.Mode mode = MojikanTokenizerFactory.getMode(settings);
        final UserDictionary userDictionary = MojikanTokenizerFactory.getUserDictionary(env, settings);
        analyzer = new JapaneseAnalyzer(userDictionary, mode, CharArraySet.copy(stopWords), JapaneseAnalyzer.getDefaultStopTags());
    }

    @Override
    public JapaneseAnalyzer get() {
        return this.analyzer;
    }
}
