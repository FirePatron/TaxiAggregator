package moduls;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HiberHelper {

    public  Session sess;
    private  Transaction tr;

    public void startSess() {
        this.sess = Hiber.getSessionFactory().openSession();
    }

    public void deleteSess(){
        this.sess.close();
    }

    public void save(Object o){
        try {
            tr=sess.beginTransaction();
            sess.save(o);
            tr.commit();
            System.out.println("Всё хорошо");
        } catch (Exception e) {
            tr.rollback();
            System.out.println("Всё плохо");
        }
    }
    public void delete(Object o){
        try {
            tr=sess.beginTransaction();
            sess.delete(o);
            tr.commit();
            System.out.println("Всё хорошо");
        } catch (Exception e) {
            tr.rollback();
            System.out.println("Всё плохо");
        }
    }
}
