package com.myapp.test.listview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.CountedCompleter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        listView.setAdapter(new VickzAdapter(this));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,dialog.class);
        Viewholder holder = (Viewholder) view.getTag();
        Country text = (Country)holder.textView.getTag();
        Country texts = (Country)holder.imageView.getTag();
        intent.putExtra("CountryName",text.countryName);
        startActivity(intent);
    }
}

class Country{
    String countryName;
    int imageId;
    Country(String countryName,int imageId){
        this.countryName=countryName;
        this.imageId=imageId;
    }

}

class Viewholder{
    ImageView imageView;
    TextView textView;
    Viewholder(View v){
        imageView = v.findViewById(R.id.imageView);
        textView = v.findViewById(R.id.textView);


    }
}
 class VickzAdapter extends BaseAdapter{
    ArrayList<Country>list;
    Context c;
    VickzAdapter(Context context){
        this.c=context;
        list = new ArrayList<Country>();
        Resources res = context.getResources();
            String[] countryName=res.getStringArray(R.array.countryName);
        int[] imageId= {R.drawable.azerbaijan,R.drawable.bangladesh,R.drawable.bhutan,R.drawable.cambodia,R.drawable.china,R.drawable.cyprus,R.drawable.india,R.drawable.israel,R.drawable.japan,R.drawable.kazakhstan,R.drawable.kyrgyzstan,R.drawable.pakistan,R.drawable.south_korea,R.drawable.sri_lanka,R.drawable.yemen,R.drawable.zimbabwe};
        for(int i=0;i<countryName.length;i++){
            Country tempCountry = new Country(countryName[i],imageId[i]);
            list.add(tempCountry);
        }

    }


     @Override
     public int getCount() {
         return list.size();
     }

     @Override
     public Object getItem(int position) {
         return list.get(position);
     }

     @Override
     public long getItemId(int position) {
         return position;
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Viewholder holder = null;
        if(row ==null){
            LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, (ViewGroup) convertView,false);
            holder = new Viewholder(row);
            row.setTag(holder);

        }
        else{
            holder = (Viewholder) row.getTag();
        }
        Country temp = list.get(position);
        holder.imageView.setImageResource(temp.imageId);
        holder.textView.setText(temp.countryName);
        holder.textView.setTag(temp);
        holder.imageView.setTag(temp);
         return row;
     }
 }