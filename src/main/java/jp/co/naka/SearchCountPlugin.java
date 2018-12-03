package jp.co.naka;

import org.elasticsearch.node.NodeModule;
import org.elasticsearch.plugins.Plugin;

public class SearchCountPlugin extends Plugin {
    public void onModule(final NodeModule nodeModule) {
        // TODO: Processorの定義をかく
        nodeModule.registerProcessor(SearchCountProcessor.TYPE, (registry) -> new SearchCountProcessor.Factory());
    }
}
