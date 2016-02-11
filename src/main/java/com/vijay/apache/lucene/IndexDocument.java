package com.vijay.apache.lucene;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;

/**
 * 
 * @author vijay
 *
 */
public class IndexDocument {

    private final Directory dir;
    private final Analyzer analyzer;

    public IndexDocument(final Directory dir, final Analyzer analyzer) {
	this.dir = dir;
	this.analyzer = analyzer;
    }

    public void index() throws IOException {
	final IndexWriterConfig indexWriterConfig = new IndexWriterConfig(this.analyzer);
	indexWriterConfig.setOpenMode(OpenMode.CREATE);
	final IndexWriter indexWriter = new IndexWriter(this.dir, indexWriterConfig);
	indexDocs(indexWriter);
	indexWriter.close();
    }

    private void indexDocs(final IndexWriter indexWriter) throws IOException {
	final Document doc1 = new Document();
	doc1.add(new Field(Constants.CONTENTS, "Bharat is member of BRICS, G20 and SAARC group.", TextField.TYPE_STORED));
	indexWriter.addDocument(doc1);
	final Document doc2 = new Document();
	doc2.add(new Field(Constants.CONTENTS, "China is member of BRICS and G20 group.", TextField.TYPE_STORED));
	indexWriter.addDocument(doc2);
	final Document doc3 = new Document();
	doc3.add(new Field(Constants.CONTENTS, "USA is member of G8 and G20 group.", TextField.TYPE_STORED));
	indexWriter.addDocument(doc3);
    }
}
