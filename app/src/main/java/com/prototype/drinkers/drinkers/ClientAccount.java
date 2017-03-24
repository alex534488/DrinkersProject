package com.prototype.drinkers.drinkers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2017-03-24.
 */

public class ClientAccount implements Serializable  {

    public BarMenu selectedBar;
    public List<Commande> historiqueBill = new ArrayList<Commande>();

    public ClientAccount(BarMenu selectedBar){
        this.selectedBar =  selectedBar;
    }

    public Commande CreateBill(Commande commande) {
        historiqueBill.add(commande);
        return historiqueBill.get(historiqueBill.size()-1);
    }
}
