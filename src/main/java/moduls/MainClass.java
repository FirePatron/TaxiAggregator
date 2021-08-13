package moduls;

import moduls.entitys.User;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainClass {

    public static User user;

    //Start from here
    public static void main(String[] args) {
    }
        //Read file for existing user
    private static String[] readFile(){
        try {
            FileReader fr = new FileReader(new File("src/main/resources/userinfo.txt"));
            Scanner sc =new Scanner(fr);
            String res = sc.nextLine();
            return res.split("=");
        } catch (FileNotFoundException | NoSuchElementException e) {
            return new String[]{new String("exception")};
        }
    }
        //Write new user into userinfo
    private static void writeFile(){
        try {
            FileWriter wf = new FileWriter(new File("src/main/resources/userinfo.txt"));
            wf.write("userid="+user.getIdUser());
            wf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        //set global user for program
    private static void setUser(String[] mas){
        if(mas.length<2){
            user=new User();
            Hiber.save(user);
            writeFile();
        }else{
            user = (User) Hiber.sess.createQuery("from User where idUser = "+mas[1]).list().get(0);
        }
    }

}
