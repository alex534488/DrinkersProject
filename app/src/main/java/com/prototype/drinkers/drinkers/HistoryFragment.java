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

public class HistoryFragment extends Fragment{

    private static final String ACCOUNT_KEY = "account_key";
    private ClientAccount account;

    View myView;

    public class HistoryAdapter extends ArrayAdapter<Commande> {

        public HistoryAdapter(Context context, ArrayList<Commande> commandes) {
            super(context, 0, commandes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Commande commandes = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_standard_layout, parent, false);
            }
            // TODO: AJOUTER UN CLICK LISTENER

            // Lookup view for data population
            TextView barName = (TextView) convertView.findViewById(R.id.textView3);
            TextView date = (TextView) convertView.findViewById(R.id.textView4);
            // Populate the data into the template view using the data object
            barName.setText(commandes.barName);
            date.setText(commandes.date.toString());
            // Return the completed view to render on screen
            return convertView;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.history_layout,container, false);

        account = (ClientAccount) getArguments().getSerializable(ACCOUNT_KEY);

        ListView listView = (ListView) myView.findViewById(R.id.listView);

        ArrayList<Commande> arrayOfCommande = new ArrayList<Commande>();

        HistoryAdapter adapter = new HistoryAdapter(myView.getContext(), arrayOfCommande);

        for(int i = 0; i < account.historiqueBill.size(); i++)
            adapter.add(account.historiqueBill.get(i));

        if(adapter != null)
            listView.setAdapter(adapter);

        return myView;
    }

    public static HistoryFragment newInstance(ClientAccount account){
        HistoryFragment fragment = new HistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ACCOUNT_KEY,account);
        fragment.setArguments(bundle);
        return fragment;
    }
}
