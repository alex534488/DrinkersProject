package com.prototype.drinkers.drinkers;

import java.io.Serializable;

/**
 * Created by Alexandre on 2017-03-24.
 */

public class Drink implements Serializable {

    public String drinkName;
    public Integer drinkPrice;

    Drink(String drinkName, Integer drinkPrice){
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
    }
}
