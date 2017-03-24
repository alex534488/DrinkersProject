package com.prototype.drinkers.drinkers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexandre on 2017-03-24.
 */

public class Commande {

    public String barName;
    public Date date;
    public List<Drink> commands = new ArrayList<Drink>();

    public Commande(String barName, Date date, List<Drink> commands){
        this.barName = barName;
        this.date = date;
        this.commands = commands;
    }

    public void AddCommand(Drink drink){
        commands.add(drink);
    }
}
