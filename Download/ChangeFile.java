package org.Download;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * @Author: yanshilong
 * @Date: 18-9-22 下午11:10
 * @Version 1.0
 */
public class ChangeFile {
    private  static Logger LOGGER=Logger.getLogger(ChangeFile.class);

    public String change(String filename){

       String url="/home/fyc/pact/"+filename;


       // String url="/home/syl/文档/"+filename;

        LOGGER.info("文件存储的路径++:"+url);



        DownloadPic downloadPic=new DownloadPic();
        downloadPic.downloadFile(filename);

        //下载



        File file=new File(url);

        FileInputStream fis= null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XWPFDocument docx= null;
        try {
            docx = new XWPFDocument(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XWPFWordExtractor extractor=new XWPFWordExtractor(docx);
        String doc=extractor.getText();
        System.out.println(doc);
        FileWriter fr = null;
        try {
            fr = new FileWriter(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("读取到文件的String是：---"+doc);

        try {
            fr.write(doc);
            fr.flush();
            fr.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  doc;
    }

    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/syl/project/Law/src/main/java/org/log4j.properties");
        ChangeFile changeFile=new ChangeFile();
        String ss=changeFile.change("Docx/F7WE7QYFC4.docx");



        System.out.println(ss);


    }
}
