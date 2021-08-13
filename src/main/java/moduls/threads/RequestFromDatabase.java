package moduls.threads;

import moduls.HiberHelper;
import moduls.entitys.Order;
import moduls.entitys.Searchforaggregator;

import java.util.List;

public class RequestFromDatabase extends Thread{

    private HiberHelper hp = new HiberHelper();
    private List<Searchforaggregator> ls;
    private Order ord;

    public void setOrd(Order ord) {
        this.ord = ord;
    }

    @Override
    public void run() {
        hp.startSess();
        ls = hp.sess.createQuery("from Searchforaggregator where idOrder = "+ord.getIdOrder()).list();
        hp.deleteSess();
    }

    public List<Searchforaggregator> getLs() {
        return ls;
    }
}
