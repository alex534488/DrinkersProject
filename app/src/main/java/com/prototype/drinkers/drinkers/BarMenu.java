package com.prototype.drinkers.drinkers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandre on 2017-03-14.
 *
 * Structure de donnees pour les info du bar
 * et de son menu
 */

public class BarMenu implements Serializable {

    public String barName = "";
    public List<Drink> drinks = new ArrayList<Drink>();

    BarMenu(String barName, List<Drink> drinks){
        this.barName = barName;
        this.drinks = drinks;
    }

    public Drink GetDrinkByName(String name){
        for (int i = 0; i < drinks.size(); i++){
            if(drinks.get(i).drinkName == name)
                return drinks.get(i);
        }
        return null;
    }
}
