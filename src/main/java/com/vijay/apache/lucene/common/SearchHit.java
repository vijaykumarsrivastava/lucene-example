package com.vijay.apache.lucene.common;

import org.apache.lucene.document.Document;

/**
 * 
 * @author vijay
 *
 */
public class SearchHit {

    private final int totalHits;
    private final float maxScore;
    private final Document[] docs;

    public SearchHit(final int totalHits, final float maxScore, final Document[] docs) {
	this.totalHits = totalHits;
	this.maxScore = maxScore;
	this.docs = docs;
    }

    public int getTotalHits() {
	return this.totalHits;
    }

    public float getMaxScore() {
	return this.maxScore;
    }

    public Document[] getDocs() {
	return this.docs;
    }
}
