package main;

import rmi.remotehelper;

import javax.swing.*;


/**
 * Created by huihantao on 2016/11/26.
 */
public class main  {


    public main() {
        gui();
        new remotehelper();

    }
    public void gui(){
        JFrame frame = new JFrame();
        frame.setSize(50, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel x=new JLabel("服务器");
        frame.add(x);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new main();
    }
}
