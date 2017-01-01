package datahelper.datahelperimpl;

import datahelper.hotel;

/**
 * Created by huihantao on 2016/12/7.
 */
public class hotelimpl implements hotel {
    private runner run;
    public hotelimpl(){
        run=new runner();
    }
    @Override
    public String find(int hotelid) {
        if (hotelid!=0) {
            String sql = "SELECT * FROM homework.hotel WHERE hotelid=" + hotelid;
            return run.read(sql);
        }
        else
        {
            String sql = "SELECT * FROM homework.hotel ;";
            return run.read(sql);
        }
    }

    @Override
    public boolean insert(String values, String log) {

<<<<<<< HEAD
        String sql1="INSERT INTO hotel(hotelid,position,address,hotelname,avdachuangfang,avshuangrenfang,avsanrenjian,dachuangfangprice,shuangrenjianprice,sanrenjianprice,star,score,assess,description,scorenum) VALUES("+values+");";
        String sql2="INSERT INTO login(id, password,online) VALUES("+log+");";
=======
        String sql1="INSERT INTO homework.hotel(hotelid,position,address,hotelname,avdachuangfang,avshuangrenjian,avsanrenjian,dachuangfangprice,shuangrenjianprice,sanrenjianprice,star,score,assess,description,scorenum) VALUES("+values+");";
        String sql2="INSERT INTO homework.login(id, password,online) VALUES("+log+");";
>>>>>>> dacca3c751ed4303bffceec54ae9b00491dd35c3
        int i=run.write(sql1);
        int j=run.write(sql2);

        return (i==1)&&(j==1);
    }

    @Override
    public boolean update(String values) {
<<<<<<< HEAD
    	 String sql="REPLACE  INTO hotel(hotelid,position,address,hotelname,avdachuangfang,avshuangrenfang,avsanrenjian,dachuangfangprice,shuangrenjianprice,sanrenjianprice,star,score,assess,description,scorenum) VALUES("+values+");";
         int i=run.write(sql);
         return (i==2);
=======
        String sql1="REPLACE INTO homework.hotel(hotelid,position,address,hotelname,avdachuangfang,avshuangrenjian,avsanrenjian,dachuangfangprice,shuangrenjianprice,sanrenjianprice,star,score,assess,description,scorenum) VALUES("+values+");";
        int i=run.write(sql1);

        return i==2;
>>>>>>> dacca3c751ed4303bffceec54ae9b00491dd35c3
    }
}
