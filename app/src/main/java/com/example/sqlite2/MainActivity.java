package com.example.sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private DatabaseHandler dbHandler;
    private AddressAdapter adapter;
    private ArrayList arrayList;
    private ArrayList<Address> addressList;


    private Button btn_add,btn_cancel;
    private  ImageButton btn_remove,btn_edt;
    private EditText pt;
    int index=-1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        dbHandler = new DatabaseHandler(MainActivity.this);
        btn_add = findViewById(R.id.btnAdd);
        btn_cancel = findViewById(R.id.btnCancel);
        pt = findViewById(R.id.pt);
        listView = findViewById(R.id.lv);
        addressList = new ArrayList<>();

        adapter = new AddressAdapter(addressList, MainActivity.this, dbHandler);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                index = position;
//                for (int i = 0; i < parent.getChildCount(); i++) {
//                    parent.getChildAt(i).setBackgroundColor(Color.WHITE);
//                }
//                view.setBackgroundColor(Color.argb(100, 255, 165, 0));
//            }
//        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address address = new Address(pt.getText().toString().trim());
                if (!address.getName().trim().isEmpty()) {
                    dbHandler.addAddress(address);
                    adapter.notifyDataSetChanged();
                    pt.setText("");
                }
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pt.setText("");
                adapter.notifyDataSetChanged();
            }
        });

    }

}