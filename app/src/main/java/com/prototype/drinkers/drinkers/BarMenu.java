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


}
