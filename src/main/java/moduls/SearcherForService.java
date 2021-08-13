package moduls;

import moduls.entitys.Geo;
import moduls.entitys.Order;
import moduls.entitys.Searchforaggregator;
import moduls.threads.RequestFromAggregators;
import moduls.threads.RequestFromDatabase;

import java.util.Date;
import java.util.List;

public class SearcherForService {

    public static void createRequestFromAggregators(String addressStart, String addressEnd, Date dateTime){
        Geo start = new Geo(addressStart.split(", "));
        Geo end = new Geo(addressEnd.split(", "));
        Hiber.save(start);
        Hiber.save(end);
        Order order = new Order(MainClass.user, start,end,dateTime);
        Hiber.save(order);
        RequestFromAggregators th = new RequestFromAggregators();
        th.setOrd(order);
        th.run();
    }

    public static List<Searchforaggregator> getRequestFromDatabase(Order order){
        RequestFromDatabase th = new RequestFromDatabase();
        th.setOrd(order);
        th.run();
        while(th.isAlive()){}
        return th.getLs();
    }
}
