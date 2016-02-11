package com.vijay.apache.lucene;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vijay.apache.lucene.common.SearchHit;

/**
 * 
 * @author vijay
 *
 */
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, ParseException {
	final Directory dir = new RAMDirectory();
	final Analyzer analyzer = new StandardAnalyzer();
	final IndexDocument indexDocument = new IndexDocument(dir, analyzer);
	indexDocument.index();
	final SearchDocument searchDocument = new SearchDocument(dir, analyzer);
	searchFirstString(searchDocument);
	searchSecondString(searchDocument);
	searchThirdString(searchDocument);
	searchFourthString(searchDocument);
	searchFifthString(searchDocument);
	searchSixthString(searchDocument);
    }

    private static void searchFirstString(final SearchDocument searchDocument) throws ParseException, IOException {
	// First search string.
	final String searchString1 = "Bharat";
	LOGGER.info("\nSearch for {}", searchString1);
	final SearchHit searchHit = searchDocument.search(Constants.CONTENTS, searchString1);
	LOGGER.info("TotalHits: {}", searchHit.getTotalHits());
	for (final Document document : searchHit.getDocs()) {
	    LOGGER.info("Document: {}", document.get(Constants.CONTENTS));
	}
    }

    private static void searchSecondString(final SearchDocument searchDocument) throws ParseException, IOException {
	// First search string.
	final String searchString1 = "BRICS";
	LOGGER.info("\nSearch for {}", searchString1);
	final SearchHit searchHit = searchDocument.search(Constants.CONTENTS, searchString1);
	LOGGER.info("TotalHits: {}", searchHit.getTotalHits());
	for (final Document document : searchHit.getDocs()) {
	    LOGGER.info("Document: {}", document.get(Constants.CONTENTS));
	}
    }

    private static void searchThirdString(final SearchDocument searchDocument) throws ParseException, IOException {
	// First search string.
	final String searchString1 = "G20";
	LOGGER.info("\nSearch for {}", searchString1);
	final SearchHit searchHit = searchDocument.search(Constants.CONTENTS, searchString1);
	LOGGER.info("TotalHits: {}", searchHit.getTotalHits());
	for (final Document document : searchHit.getDocs()) {
	    LOGGER.info("Document: {}", document.get(Constants.CONTENTS));
	}
    }

    private static void searchFourthString(final SearchDocument searchDocument) throws ParseException, IOException {
	// First search string.
	final String searchString1 = "G8";
	LOGGER.info("\nSearch for {}", searchString1);
	final SearchHit searchHit = searchDocument.search(Constants.CONTENTS, searchString1);
	LOGGER.info("TotalHits: {}", searchHit.getTotalHits());
	for (final Document document : searchHit.getDocs()) {
	    LOGGER.info("Document: {}", document.get(Constants.CONTENTS));
	}
    }

    private static void searchFifthString(final SearchDocument searchDocument) throws ParseException, IOException {
	// First search string.
	final String searchString1 = "SAARC";
	LOGGER.info("\nSearch for {}", searchString1);
	final SearchHit searchHit = searchDocument.search(Constants.CONTENTS, searchString1);
	LOGGER.info("TotalHits: {}", searchHit.getTotalHits());
	for (final Document document : searchHit.getDocs()) {
	    LOGGER.info("Document: {}", document.get(Constants.CONTENTS));
	}
    }

    private static void searchSixthString(final SearchDocument searchDocument) throws ParseException, IOException {
	// First search string.
	final String searchString1 = "group";
	LOGGER.info("\nSearch for {}", searchString1);
	final SearchHit searchHit = searchDocument.search(Constants.CONTENTS, searchString1);
	LOGGER.info("TotalHits: {}", searchHit.getTotalHits());
	for (final Document document : searchHit.getDocs()) {
	    LOGGER.info("Document: {}", document.get(Constants.CONTENTS));
	}
    }
}