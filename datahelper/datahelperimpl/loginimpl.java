package datahelper.datahelperimpl;

import datahelper.login;

/**
 * Created by huihantao on 2016/12/21.
 */
public class loginimpl implements login {
    private runner run;

    public loginimpl(){
        run=new runner();
    }

    @Override
    public String login(String id) {
        String sql="SELECT password,online FROM login WHERE id="+id;

        return run.read(sql);

    }

    @Override
    public boolean logout(String values) {
        String sql="REPLACE INTO login(id,online) VALUES("+values+")";
        return  false;
    }
}
