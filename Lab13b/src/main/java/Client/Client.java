package Client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.*;

public class Client extends JFrame implements ActionListener{
    private JButton send,clear,exit,login,logout,Connect;
    private JPanel p_login,p_chat,p_connect, Info;
    private JTextField nick,nick1,message,IP;
    private JTextArea msg,online;
    private Socket client;
    private ThreadClient dataStream;
    private DataOutputStream dos;
    private DataInputStream dis;
    private BufferedImage ImageToken;

    public Client (){

        super("Client Chat");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                exit();
            }
        });
        setSize(600, 400);
        addItem();
        setVisible(true);
    }
    //-----[ Tạo giao diện ]--------//
    private void addItem() {
        setLayout(new BorderLayout());

        exit = new JButton("Exit");
        exit.addActionListener(this);
        send = new JButton("Send");
        send.addActionListener(this);
        clear = new JButton("Clear");
        clear.addActionListener(this);
        login= new JButton("Login");
        login.addActionListener(this);
        logout= new JButton("Logout");
        logout.addActionListener(this);

        p_chat = new JPanel();
        p_chat.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        nick = new JTextField(20);
        p1.add(new JLabel("Your nickname: "));
        p1.add(nick);
        p1.add(exit);

        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());

        JPanel p22 = new JPanel();
        p22.setLayout(new FlowLayout(FlowLayout.CENTER));
        p22.add(new JLabel("Online List"));
        p2.add(p22,BorderLayout.NORTH);

        online = new JTextArea(10,10);
        online.setEditable(false);
        p2.add(new JScrollPane(online),BorderLayout.CENTER);
        p2.add(new JLabel("     "),BorderLayout.SOUTH);
        p2.add(new JLabel("     "),BorderLayout.EAST);
        p2.add(new JLabel("     "),BorderLayout.WEST);

        msg = new JTextArea(10,20);
        msg.setEditable(false);

        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3.add(new JLabel("Messages"));
        message = new JTextField(30);
        p3.add(message);
        p3.add(send);
        p3.add(clear);

        p_chat.add(new JScrollPane(msg),BorderLayout.CENTER);
        p_chat.add(p1,BorderLayout.NORTH);
        p_chat.add(p2,BorderLayout.EAST);
        p_chat.add(p3,BorderLayout.SOUTH);
        p_chat.add(new JLabel("     "),BorderLayout.WEST);

        p_chat.setVisible(false);
        add(p_chat,BorderLayout.SOUTH);
        //-------------------------


        p_login = new JPanel();
        p_login.setLayout(new FlowLayout(FlowLayout.CENTER));
        p_login.add(new JLabel("Your nickname: "));
        nick1=new JTextField(20);
        p_login.add(nick1);
        p_login.add(login);
        p_login.add(logout);
        p_login.setVisible(false);
        add(p_login,BorderLayout.NORTH);

        //----------Connect-----------//
        p_connect = new JPanel();
        p_connect.setLayout(new FlowLayout(FlowLayout.CENTER));
        p_connect.add(new JLabel("IP Sever : "));
        IP = new JTextField(20);
        p_connect.add(IP);
        Connect = new JButton("Connect");
        Connect.addActionListener(this);
        p_connect.add(Connect);
        add(p_connect,BorderLayout.LINE_START);
        //---------------
        Info = new JPanel();
        Info.setLayout(new FlowLayout(FlowLayout.CENTER));
        JTextArea T_info = new JTextArea();
        String a = "Demo Chat Client - Server";
        T_info.setText(a);
        Info.add(T_info);
        Info.setVisible(false);
        add(Info, BorderLayout.CENTER);

    }

    //Using socket and connect
    private void go(String IP) {
        try {

            client = new Socket(IP,2207);
            dos=new DataOutputStream(client.getOutputStream());
            dis=new DataInputStream(client.getInputStream());

            //client.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Connection Failed!","Message Dialog",JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Client();
    }
    private void sendMSG(String data){
        try {
            dos.writeUTF(data);

            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String getMSG(){
        String data=null;
        try {
            data=dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void getMSG(String msg1, String msg2){
        int stt = Integer.parseInt(msg1);
        switch (stt) {
            // Friends messages
            case 3:
                this.msg.append(msg2);

                break;
            // update online list
            case 4:
                this.online.setText(msg2);
                break;
            // server closed
            case 5:
                dataStream.stopThread();
                exit();
                break;
            default:
                break;
        }
    }
    //----------------------------------------------
    private void checkSend(String msg){
        if(msg.compareTo("\n")!=0){
            this.msg.append("Me: "+msg);
            sendMSG("1");
            sendMSG(msg);
        }
    }
    private boolean checkLogin(String nick){
        if(nick.compareTo("")==0)
            return false;
        else if(nick.compareTo("0")==0){
            return false;
        }
        else{
            sendMSG(nick);
            int sst = Integer.parseInt(getMSG());
            if(sst==0)
                return false;
            else return true;
        }
    }

    private void exit(){
        try {
            sendMSG("0");
            dos.close();
            dis.close();
            client.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.exit(0);
    }
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==exit){
            dataStream.stopThread();
            exit();
        }
        else if(e.getSource()==clear){
            message.setText("");
        }
        else if(e.getSource()==send){
            checkSend(message.getText()+"\n");
            message.setText("");
        }
        else if(e.getSource()==login){

            if(checkLogin(nick1.getText())){
                p_chat.setVisible(true);
                p_login.setVisible(false);
                Info.setVisible(false);
                nick.setText(nick1.getText());
                nick.setEditable(false);
                this.setTitle(nick1.getText());
                msg.append("Login Successful!\n");
                dataStream = new ThreadClient(this, this.dis);
            }

            else{JOptionPane.showMessageDialog(this,"Nickname has been used. Re-enter another nickname","Message Dialog",JOptionPane.WARNING_MESSAGE);}

        }
        else if(e.getSource() == Connect){
            go(IP.getText());
            p_login.setVisible(true);
            Info.setVisible(true);
            p_connect.setVisible(false);
        }
        else if(e.getSource()==logout){
            exit();
        }
    }

}
