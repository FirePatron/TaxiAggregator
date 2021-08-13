package moduls;

import moduls.entitys.Searchforaggregator;

public class Reservation {

    public static void reserv(Searchforaggregator s){
        s.setReserved((byte)1);
        Hiber.save(s);
    }

    public static void unreserv(Searchforaggregator s){
        s.setReserved((byte)0);
        Hiber.save(s);
    }
}
