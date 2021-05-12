package com.example.sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    CustomAdapter adt;
    ArrayList arrayList;
    ArrayList<Place> list;

    dataPlace dataPlace;
    Button btn_add;
    ImageButton btn_remove,btn_edt;
    EditText pt;
    ArrayList idList;
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = new ArrayList<>();
        list.add(new Place("long"));
        list.add(new Place("long1"));
        list.add(new Place("long2"));
        list.add(new Place("long3"));



        lv = findViewById(R.id.lv);

        arrayList = new ArrayList<>();
        dataPlace = new dataPlace(this,"placedb.sqlite",null,1);

        idList = new ArrayList();
        getNameList();


        btn_edt = findViewById(R.id.btnSua);
        btn_add =findViewById(R.id.btnAdd);
        btn_remove =findViewById(R.id.btnXoa);
        pt = findViewById(R.id.pt);
        lv= findViewById(R.id.lv);

        btn_add.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                dataPlace.addUser(new Place(pt.getText().toString()));
                getNameList();
                adt.notifyDataSetChanged();
            }
        });


        adt = new CustomAdapter(this, R.layout.listview, list);

        lv.setAdapter(adt);




    }private ArrayList getNameList(){
        arrayList.clear();
        idList.clear();

        for (Iterator iterator = dataPlace.getAll().iterator(); iterator.hasNext();){
            Place place = (Place)iterator.next();

            arrayList.add(place.getName());
            idList.add(place.getId());
        }

        return arrayList;
    }

}