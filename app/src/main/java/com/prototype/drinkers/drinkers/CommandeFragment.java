package com.prototype.drinkers.drinkers;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alex on 2017-03-12.
 */

public class CommandeFragment extends Fragment{

    private static final String ACCOUNT_KEY = "account_key";
    private ClientAccount account;

    View myView;

    public class DrinksAdapter extends ArrayAdapter<Drink> {

        public DrinksAdapter(Context context, ArrayList<Drink> drinks) {
            super(context, 0, drinks);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Drink drink = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_standard_layout, parent, false);
            }
            // Lookup view for data population
            TextView drinkName = (TextView) convertView.findViewById(R.id.textView3);
            TextView drinkPrice = (TextView) convertView.findViewById(R.id.textView4);
            // Populate the data into the template view using the data object
            drinkName.setText(drink.drinkName);
            drinkPrice.setText(drink.drinkPrice.toString());
            // Return the completed view to render on screen
            return convertView;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.commande_layout,container, false);

        account = (ClientAccount) getArguments().getSerializable(ACCOUNT_KEY);

        ListView listView = (ListView) myView.findViewById(R.id.listView);

        ArrayList<Drink> arrayOfDrinks = new ArrayList<Drink>();

        DrinksAdapter adapter = new DrinksAdapter(myView.getContext(), arrayOfDrinks);

        for(int i = 0; i < account.selectedBar.drinks.size(); i++)
            adapter.add(account.selectedBar.drinks.get(i));

        if(adapter != null)
            listView.setAdapter(adapter);

        return myView;
    }

    public static CommandeFragment newInstance(ClientAccount account){
        CommandeFragment fragment = new CommandeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ACCOUNT_KEY,account);
        fragment.setArguments(bundle);
        return fragment;
    }
}
