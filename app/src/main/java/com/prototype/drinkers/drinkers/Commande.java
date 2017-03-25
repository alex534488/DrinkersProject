package com.prototype.drinkers.drinkers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexandre on 2017-03-24.
 */

public class Commande implements Serializable {

    public String barName;
    public Date date;
    public List<Drink> commands = new ArrayList<Drink>();

    public Commande(String barName, Date date, List<Drink> commands){
        this.barName = barName;
        this.date = date;
        if(commands != null)
            this.commands = commands;
        else
            this.commands = new ArrayList<Drink>();
        //test
    }
}
