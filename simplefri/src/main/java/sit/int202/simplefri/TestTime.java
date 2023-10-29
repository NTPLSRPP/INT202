package sit.int202.simplefri;

import java.util.Date;

public class TestTime {
    public static void main(String[] args) {
        Date d1 = new Date(1000*60);
        Date d2 = new Date(1000*60*60*24);
        Date today = new Date(1694145292870L);
        Date tomorrow = new Date(1694145292870L + 1000*60*60*24);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(System.currentTimeMillis());
        System.out.println(today);
        System.out.println(tomorrow);
    }
}
