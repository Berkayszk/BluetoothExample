package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Set;

public class BluetoothList extends AppCompatActivity {

    Button button;
    ListView listView;
    BluetoothAdapter myBluetoothAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_list);
        button = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listview);
        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        exeButton();
    }

    private void exeButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Set<BluetoothDevice> bt = myBluetoothAdapter.getBondedDevices();
                    String[] strings = new String[bt.size()];
                    int index=0;
                    if (bt.size()>0)
                    {
                        for (BluetoothDevice device : bt)
                        {
                            strings[index] = device.getName();
                            index++;
                        }
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.activity_list_item ,strings);
                        listView.setAdapter(arrayAdapter);
                    }
                }catch (SecurityException e)
                {

                }

            }
        });
    }
}