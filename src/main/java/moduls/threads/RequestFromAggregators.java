package moduls.threads;

import moduls.Hiber;
import moduls.HiberHelper;
import moduls.entitys.Aggregator;
import moduls.entitys.Order;
import moduls.entitys.Searchforaggregator;

import java.util.List;

public class RequestFromAggregators extends Thread{

    HiberHelper hp = new HiberHelper();
    Order ord;

    public void setOrd(Order ord) {
        this.ord = ord;
    }

    @Override
    public void run() {
        hp.startSess();
        Hiber.save(ord);
        //Add survey for aggregators
        List<Aggregator> la = Hiber.sess.createQuery("from Aggregator").list();
        for(Aggregator a:la){
            //Receive price with API. Random for now. Save in db

            int price = Integer.parseInt(String.valueOf(Math.random()*1000));
            hp.save(new Searchforaggregator(a,ord,price));
        }
        //save info about results
        hp.deleteSess();
    }

}
