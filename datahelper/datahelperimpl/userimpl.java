package datahelper.datahelperimpl;

/**
 * Created by huihantao on 2016/11/28.
 */
import datahelper.user;

public class userimpl implements user {
    private runner run;


    public userimpl(){
        run=new runner();
    }


    @Override
    public String find(int id){
        String sql="SELECT * FROM user WHERE id="+id;
        return run.read(sql);
    }

    @Override
    public boolean insert(String values,String log){
        String sql1="INSERT INTO user(userid, name ,credit,number,birthday,company) VALUES("+values+");";
        String sql2="INSERT INTO login(id, password,online) VALUES("+log+");";
        int i=run.write(sql1);
        int j=run.write(sql2);

        return (i==1)&&(j==1);
    }

    @Override
    public boolean update(String values) {

        String sql="REPLACE  INTO user(userid, name ,credit,number,birthday,company) VALUES("+values+");";
        int i=run.write(sql);
        return (i==2);
    }




}
