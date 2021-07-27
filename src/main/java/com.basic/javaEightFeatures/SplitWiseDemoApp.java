package com.basic.javaEightFeatures;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public class SplitWiseDemoApp {
    // person magesh, 50, bala
    // person bala, 20, magesh
    // person jaga, 100, magesh
    // person bala, 30, jaga
    // magesh owe 50 getsback 120
    // bala owe 50 getsback 50
    // jaga owe 100 getsback 30
    public static void main(String[] args) {
        //Magesh 90 Bala
        User magesh = new User("MB2123", "Magesh");
        User bala = new User("BS898", "Bala");
        magesh.addOweToThisUser(bala);
        bala.addOweToThisUser(magesh);
        System.out.println("Completed");
    }
}

class User {
    String id;
    String name;
    BigDecimal oweTotal;
    ArrayList<User> owesTo = new ArrayList<>();

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    BigDecimal getsBackTotal;
    Map<User, BigDecimal> owesToUsers;
    Map<User, BigDecimal> getsBackFromUsers;

    public void addOweToThisUser(User owe){
        owesTo.add(owe);
    }
}
