package com.prototype.drinkers.drinkers;

import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alex on 2017-03-12.
 */

public class CommandeFragment extends Fragment{

    private static final String MENU_KEY = "menu_key";
    private BarMenu myMenu;

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.commande_layout,container, false);

        myMenu = (BarMenu) getArguments().getSerializable(MENU_KEY);

        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i = 0; i < myMenu.drinks.size(); i++){
            HashMap<String,String> hm = new HashMap<String, String>();
            hm.put("Name",myMenu.drinks.get(i).drinkName);
            hm.put("Price",myMenu.drinks.get(i).drinkPrice.toString());
            aList.add(hm);
        }

        String[] from = {"drinkName","drinkPrice"};

        int[] to = {R.id.textView3,R.id.textView4};

        SimpleAdapter adapter = new SimpleAdapter(myView.getContext(), aList, R.layout.listview_commande_layout, from, to);

        ListView listView = (ListView) myView.findViewById(R.id.listView);

        listView.setAdapter(adapter);

        return myView;
    }

    public static CommandeFragment newInstance(BarMenu menu){
        CommandeFragment fragment = new CommandeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MENU_KEY,menu);
        fragment.setArguments(bundle);
        return fragment;
    }
}
