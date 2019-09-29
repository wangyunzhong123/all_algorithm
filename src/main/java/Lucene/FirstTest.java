package Lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;

/**
 * Created by yzwang on 2019/9/29.
 * https://www.cnblogs.com/xiaobai1226/p/7652093.html
 */
public class FirstTest {

    public static void main(String[] args) {

        try {
            FirstTest firstTest = new FirstTest();
            firstTest.testCreateIndex();
            firstTest.testMatchAllDocsQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //创建索引
    public void testCreateIndex() throws IOException {
        //指定索引库的存放位置Directory对象
        Directory directory = FSDirectory.open(new File("/Users/yzwang/Documents/result"));
        //索引库还可以存放到内存中
//        directory = new RAMDirectory();

        //指定一个标准分析器，对文档内容进行分析
        Analyzer analyzer = new StandardAnalyzer();

        //创建indexwriterCofig对象
        //第一个参数： Lucene的版本信息，可以选择对应的lucene版本也可以使用LATEST
        //第二根参数：分析器对象
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);

        //创建一个indexwriter对象
        IndexWriter indexWriter = new IndexWriter(directory, config);

        //原始文档的路径
        File file = new File("/Users/yzwang/Documents/raw");
        File[] fileList = file.listFiles();
        for (File file2 : fileList) {
            //创建document对象
            Document document = new Document();

            //创建field对象，将field添加到document对象中

            //文件名称
            String fileName = file2.getName();
            //创建文件名域
            //第一个参数：域的名称
            //第二个参数：域的内容
            //第三个参数：是否存储
            Field fileNameField = new TextField("fileName", fileName, Field.Store.YES);

            //文件的大小
            long fileSize  = FileUtils.sizeOf(file2);
            //文件大小域
            Field fileSizeField = new LongField("fileSize", fileSize, Field.Store.YES);

            //文件路径
            String filePath = file2.getPath();
            //文件路径域（不分析、不索引、只存储）
            Field filePathField = new StoredField("filePath", filePath);

            //文件内容
            String fileContent = FileUtils.readFileToString(file2);
            //String fileContent = FileUtils.readFileToString(file2, "utf-8");
            //文件内容域
            Field fileContentField = new TextField("fileContent", fileContent, Field.Store.YES);

            document.add(fileNameField);
            document.add(fileSizeField);
            document.add(filePathField);
            document.add(fileContentField);
            //使用indexwriter对象将document对象写入索引库，此过程进行索引创建。并将索引和document对象写入索引库。
            indexWriter.addDocument(document);
        }
        //关闭IndexWriter对象。
        indexWriter.close();
    }

    public void testMatchAllDocsQuery() throws Exception {
        //创建一个Directory对象，指定索引库存放的路径
        Directory directory = FSDirectory.open(new File("/Users/yzwang/Documents/result"));
        //创建IndexReader对象，需要指定Directory对象
        IndexReader indexReader = DirectoryReader.open(directory);
        //创建Indexsearcher对象，需要指定IndexReader对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        //创建查询条件
        //使用MatchAllDocsQuery查询索引目录中的所有文档
        Query query = new MatchAllDocsQuery();
        //执行查询
        //第一个参数是查询对象，第二个参数是查询结果返回的最大值
        TopDocs topDocs = indexSearcher.search(query, 10);

        //查询结果的总条数
        System.out.println("查询结果的总条数："+ topDocs.totalHits);
        //遍历查询结果
        //topDocs.scoreDocs存储了document对象的id
        //ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            //scoreDoc.doc属性就是document对象的id
            //int doc = scoreDoc.doc;
            //根据document的id找到document对象
            Document document = indexSearcher.doc(scoreDoc.doc);
            //文件名称
            System.out.println(document.get("fileName"));
            //文件内容
            System.out.println(document.get("fileContent"));
            //文件大小
            System.out.println(document.get("fileSize"));
            //文件路径
            System.out.println(document.get("filePath"));
            System.out.println("----------------------------------");
        }
        //关闭indexreader对象
        indexReader.close();
    }
}
