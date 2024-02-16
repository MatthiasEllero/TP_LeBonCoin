package com.example.tp_leboncoin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.List;

public class AdListViewActivity extends AppCompatActivity {

    List<AdModel> adList = AdListManager.adList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_list_view);

        AdAdapter adAdapter = new AdAdapter(this, adList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adAdapter);
    }
}
class AdAdapter extends BaseAdapter {

    Context context;
    List<AdModel> adList = AdListManager.adList();
    private final LayoutInflater inflater;
    public AdAdapter(Context context, List<AdModel> adModelArrayList) {
        inflater = (LayoutInflater.from(context));
        this.context = context;
    }
    @Override
    public int getCount() { return adList.size() ; }
    @Override
    public AdModel getItem(int i) { return adList.get(i); }
    @Override
    public long getItemId(int i) { return adList.get(i).getId(); }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        AdModel ad = getItem(i) ;
        view = inflater.inflate(R.layout.item_listview_ad, null);

        ImageView imageIV = view.findViewById(R.id.adImage) ;
        TextView titleTV = view.findViewById(R.id.adName) ;
        TextView addressTV = view.findViewById(R.id.adAddress) ;
        CardView cardView = view.findViewById(R.id.cardView);

        imageIV.setImageResource(ad.getImage());
        titleTV.setText(ad.getTitle());
        addressTV.setText(ad.getAddress());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click action to show detailed page
                // Start the activity and pass the AdModel object
                Intent intent = new Intent(context, AdViewActivity.class);
                intent.putExtra("ad_id", ad.getId());
                intent.putExtra("ad_title", ad.getTitle());
                intent.putExtra("ad_address", ad.getAddress());
                intent.putExtra("ad_image", ad.getImage());
                context.startActivity(intent);
            }
        });

        return view;
    }
}
