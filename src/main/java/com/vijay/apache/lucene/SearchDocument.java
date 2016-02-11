package com.vijay.apache.lucene;

import java.io.IOException;

import javax.print.Doc;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vijay.apache.lucene.common.SearchHit;

/**
 * 
 * @author vijay
 *
 */
public class SearchDocument {

    private final Directory dir;
    private final Analyzer analyzer;

    public SearchDocument(final Directory dir, final Analyzer analyzer) {
	this.dir = dir;
	this.analyzer = analyzer;
    }

    public SearchHit search(final String fieldName, final String searchString) throws ParseException, IOException {
	final QueryParser parser = new QueryParser(fieldName, this.analyzer);
	final Query query = parser.parse(searchString);

	final IndexReader reader = DirectoryReader.open(dir);
	final IndexSearcher searcher = new IndexSearcher(reader);
	final TopDocs docs = searcher.search(query, 100);
	final ScoreDoc[] hits = docs.scoreDocs;
	final int numTotalHits = docs.totalHits;
	final Document[] documents = new Document[numTotalHits];
	for (int i = 0; i < numTotalHits; i++) {
	    documents[i] = searcher.doc(hits[i].doc);
	}
	final SearchHit searchHit = new SearchHit(docs.totalHits, docs.getMaxScore(), documents);
	return searchHit;
    }
}
