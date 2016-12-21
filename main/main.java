package main;

import rmi.remotehelper;



/**
 * Created by huihantao on 2016/11/26.
 */
public class main  {


    public main() {
        new remotehelper();
    }

    public static void main(String[] args) {
        new main();
    }
//    public static void main(String[] args){
//        new remotehelper();
//        userserviceimpl m=new userserviceimpl();
//        UserPo x=new UserPo(0,"天",140,"1213");
//        UserPo y=new UserPo(12,"sb",92,"1213");
//        UserPo z=new UserPo(13,"shit",92,"1213");
//        System.out.print(m.userinsert(x,"abc".toCharArray()));
//        System.out.print(m.userinsert(x,"dafe".toCharArray()));
//
//
//    }
}
