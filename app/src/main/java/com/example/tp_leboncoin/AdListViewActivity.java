package com.example.tp_leboncoin;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AdListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_list_view);

        AdAdapter adAdapter = new AdAdapter(this, adList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adAdapter);
    }
}
public class AdAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<AdModel> adModelArrayList;
    private final LayoutInflater inflater;
    // Constructor
    public AdAdapter(Context context, ArrayList<AdModel> adModelArrayList) {
        this.context = context;
        this.adModelArrayList = adModelArrayList;
        inflater = (LayoutInflater.from(context));
    }
    @Override
    public int getCount() { return adList.size() ; } // Return ad number
    @Override
    public Object getItem(int i) { return adList[i] ; } // Return ad number i
    @Override
    public long getItemId(int i) { return adList[i].id ; } // Return ad id i
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
// Get ad number i
        AdModel ad = adList[i] ;
        view = inflater.inflate(R.layout.item_listview_ad, null);
// Get the image view and both text views
        ImageView imageIV = view.findViewById(R.id.adImage) ;
        TextView titleTV = view.findViewById(R.id.adName) ;
        TextView addressTV = view.findViewById(R.id.adAddress) ;
        imageIV.setImageResource(ad.image);
        titleTV.setText(ad.title);
        addressTV.setText(ad.address);
        return view;
    }
}
