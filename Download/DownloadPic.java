package org.Download;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * @Author: yanshilong
 * @Date: 18-9-21 下午5:02
 * @Version 1.0
 */
public class DownloadPic {
 //   private  static Logger LOGGER=Logger.getLogger(DownloadPic.class);

    private static String endpoint = "http://oss-cn-qingdao.aliyuncs.com";

    private  static  String accessKeyId = "LTAIFUl1eyqqM1YV";

    private  static  String accessKeySecret = "WqfX6x0roPIEy9Y9WBJ28hhMyoEBrk";

    private  static String bucketName = "fayancha";

//    private  String objectName=null;
//    public DownloadPic(String objectName){
//        this.objectName=objectName;
//    }

    public void download(String objectName){

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

//        String []ary=url.split("=");
//        System.out.println("长度======"+ary.length);
//        Ocr ocr=new Ocr();
//        int length=ary.length;
//
//        for(int ii=0;ii<length;ii++){
//            System.out.println("URL==="+ary[ii]);
//
//            String pic= ocr.DoOcr("/home/syl/文档/Docx/"+ary[ii]);


        //URL 解析

        String arr[]=objectName.split("=");

      //  System.out.println("存储图片的个数为========:"+arr.length);
        for(int i=0;i<arr.length;i++) {
            //LOGGER.info("处理前的图片URL是：===="+arr[i]);
            String rpath=arr[i].replaceAll("=","");

           //   LOGGER.info("处理后的图片URL是： "+rpath);
           String path = "/home/fyc/pact/" +rpath;

         //   String path = "/home/syl/文档/Docx/" +rpath;
          //  LOGGER.info("存储的路径是："+rpath);
            System.out.println();

            System.out.println("图片正在存储");
            System.out.println("图片存储路径------->" + path);
//            SaveUrl dosave=new SaveUrl();
//            dosave.saveUrl();
            //String style = "image/resize,p_40";
          //  LOGGER.info("图片压缩完成");

           String style="image/auto-orient,1/resize,m_lfit,h_888,limit_0/quality,Q_49";
           // GetObjectRequest request = new GetObjectRequest(bucketName, objectName);

            GetObjectRequest request = new GetObjectRequest(bucketName, rpath);



            request.setProcess(style);



            ossClient.getObject(request, new File(path));
          //  LOGGER.info("图片  "+arr[i]+"   已存储");

        }



        ossClient.shutdown();
        System.out.println("链接已关闭");
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//        String path = "/home/syl/文档/Docx/"+objectName;
//        System.out.println("图片存储路径------->"+path);
//        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(path));
//        System.out.println("图片已存储");
//        ossClient.shutdown();
//        System.out.println("链接已关闭");
    }



    public static void downloadFile(String objectName){

       // String path = "/home/syl/文档/"+objectName;
         String endpoint = "http://oss-cn-qingdao.aliyuncs.com";
         String accessKeyId = "LTAIFUl1eyqqM1YV";

        String accessKeySecret = "WqfX6x0roPIEy9Y9WBJ28hhMyoEBrk";

        String bucketName = "fayancha";

        String style="image/auto-orient,1/resize,m_lfit,h_888,limit_0/quality,Q_49";


       String path = "/home/fyc/pact/"+objectName;

      //          String path = " /home/syl/文档/Docx/"+objectName;
        System.out.println("文件存储路径------->"+path);





        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(path));
        System.out.println("文件已存储");
        ossClient.shutdown();
        System.out.println("链接已关闭");
    }



    public static void main(String[] args) {
//            DownloadPic downloadPic=new DownloadPic();
//            downloadPic.download("Picture/22iBCJNCPB.jpg");

//        String endpoint = "http://oss-cn-qingdao.aliyuncs.com";
//// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。




//
//        String objectName = "Picture/22iBCJNCPB.jpg";
//
//
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//// 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
//        System.out.println("xxxxxxxxxx");
//        String path = " /home/syl/文档/Docx/"+objectName;
//        System.out.println(path);
//        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(path));
//        System.out.println("ppppppppppppp");
//// 关闭OSSClient。
//        ossClient.shutdown();





    }
}
