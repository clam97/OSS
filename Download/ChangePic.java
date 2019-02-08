package org.Download;

import org.Ocr.Ocr;
import org.apache.log4j.Logger;

/**
 * @Author: yanshilong
 * @Date: 18-9-21 下午5:00
 * @Version 1.0
 */
public class ChangePic {
    private  static Logger LOGGER=Logger.getLogger(ChangePic.class);

//    //调用XwpfTest拿到一个docx文档的String
//    String docx="离婚合同协议的文档";
//
//    //调用张鹏的方法拿到一个String的URL集合
//    String fh="";
//    //int i=0;
//    String json=null;


//    HandlePic handlePic=new HandlePic();
//    String url=handlePic.handle(json);




    public String ChangePic(String url){//url----path
        String fh="";
        LOGGER.info("这是OCR传入的URL===================================================================="+url);
        String []ary=url.split("=");
        System.out.println("长度======"+ary.length);
        Ocr ocr=new Ocr();
        int length=ary.length;

        for(int ii=0;ii<length;ii++){
         // LOGGER.info("处理前的URL： "+ary[ii]);
          String rpath=ary[ii].replaceAll("=","");

          LOGGER.info("处理以后的URL是： "+rpath);
//

         //  LOGGER.info("这是我查询本地的URL======:"+"/home/fyc/pact/"+rpath);
            //String pic= ocr.DoOcr("/home/syl/文档/Docx/"+rpath);
             String pic= ocr.DoOcr("/home/fyc/pact/"+rpath);

             // String pic= ocr.DoOcr("/home/fyc/pact/"+rpath);
            LOGGER.info("这是第： "+ii+"  个图片转化的文字是："+pic);




           // LOGGER.info("这是我进行OCR的图片地："+"/home/syl/文档/Docx/"+rpath);




           // LOGGER.info("这是我查询本地的URL======:"+"/home/fyc/pact"+ary[ii]);
            fh+=pic;
           // ii++;


            //did   userid pic pic pic pic pic
            //did2 userid pic po cpi c

//未,户糖、出、违的,觉得见到你就OK大家都能见到你,办、完、过户,房、交付、费。结
// 清、期、违约,中介、买方、买卖协议、不一致,奖学金你的意思了吗你是不是傻啊你了吧到吧面
// ,迁出、户口,未、划入,曲付、道期、日、 zhi zhcisf解ahq,除、违约,这是一个二手房合同,赌
// 博和四级觉得你说什么,时候的吗你是个,部不打扮了吧你大几了吗简单机械呢奖学金大家,都能你部拿
// 觉得见到你觉得好的吧见到你等,买卖协议定金好使通对吧D内华东交大违,价格,而积价
// 格房屋标的晗比低价不动产地白望纪房,定金价款,亡],18
        }
        return fh;
    }
//    //可以拿到文件和图片的String集合
//    public String Changedocx(){
//        ChangePic changePic=new ChangePic();
//        String pic=changePic.ChangePic(url);
//        String handler=docx+" "+pic;
//
//        return handler;
//    }
}
