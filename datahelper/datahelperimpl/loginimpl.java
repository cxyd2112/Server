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
        String sql="SELECT password FROM login WHERE id="+id;

        return run.read(sql);

    }
}
