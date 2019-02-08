package org.Download;

import org.JdbcUtil.JdbcPool;
import org.apache.log4j.Logger;
import org.mainServer.OutHandler;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveUrl {
    private static Logger log = Logger.getLogger(OutHandler.class);

    public void saveUrl(int userid, String url,int heongid) {

         String mmm=String.valueOf(heongid)+" "+url;
        Jedis jedis6387 = new Jedis("127.0.0.1", 6387);
            jedis6387.set(String.valueOf(userid), mmm);

        log.info("将userid，Url存入reids");
        jedis6387.close();

    }

    public int saveurlhetong(int userid, String hetongid, String url) {
        Connection coon = (Connection) JdbcPool.get();
        PreparedStatement pstm = null;
//           int uu=userid;
//           String hetongii=hetongid;
//           String uur=url;

        String sql = "insert into  manage(userid,hetongid,url) values (?,?,?);";
        log.info("这是在SaveUrl里面存储的数据是："+userid+hetongid+url);

        log.info("mysql---------->" + sql);
        log.info("userid::"+userid+"hetongid::"+hetongid+"url::"+url);

        try {
            pstm = coon.prepareStatement(sql);
            pstm.setInt(1, userid);
            pstm.setString(2, String.valueOf(hetongid));
            pstm.setString(3, url);
            pstm.executeUpdate();
            log.info("url插入mysql成功");

        } catch (SQLException e) {

           log.error("this is an errror  when create statement  ",e);

        }
        try {
            pstm.close();
            coon.close();
        } catch (SQLException e) {
          log.error("this is an error when close ",e);
        }
        return 0;
    }

}


//        PreparedStatement ps = null;
//
//        Connection connection = (Connection) JdbcPool.get();
//        String sql = "insert into consumer(userid,hetongid,url) values (?,?,?);";
//        log.info("mysql---------->" + sql);
//        try {
//            ps = connection.prepareStatement(sql);
//            ps.setInt(1, userid);
//            ps.setString(2,hetongid);
//            ps.setString(3, url);
//            ps.executeUpdate();
//            log.info("url插入mysql成功");
//        } catch (SQLException e) {
//            log.error("创建statement--",e);
//
//          jedis6387.close();
//
//            try {
//                connection.close();
//                ps.close();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//
//            log.info("url插入mysql失败");
//
//
//        }
//    }
//}