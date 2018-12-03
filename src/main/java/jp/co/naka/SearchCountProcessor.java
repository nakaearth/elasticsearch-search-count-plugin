package jp.co.naka;

import org.elasticsearch.ingest.AbstractProcessor;
import org.elasticsearch.ingest.IngestDocument;

public final class SearchCountProcessor extends AbstractProcessor {

    public final static String NAME = "searchCount";

    protected SearchCountProcessor(String tag) {
        super(tag);
    }

    @Override
    public String getType() {
        return NAME;
    }

    @Override
    public void execute(IngestDocument ingestDocument) throws Exception {
        // Implement your logic code here
    }
}

