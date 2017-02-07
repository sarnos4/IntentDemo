package com.example.sam.intentdemo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import static com.example.sam.intentdemo.utils.Utils.AGE_MSG_KEY;
import static com.example.sam.intentdemo.utils.Utils.NAME_MSG_KEY;
import static com.example.sam.intentdemo.utils.Utils.CLASS_MSG_KEY;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private EditText editText1;
    private EditText editText2;
    private ListView lsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsView = (ListView) findViewById(R.id.ls_view1_ma1);

        final String[] myItems = getResources().getStringArray(R.array.my_itm_lst);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myItems);
        lsView.setAdapter(adapter);

        lsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /* reference source:  http://stackoverflow.com/a/30050942 */

                for (int i = 0; i < lsView.getChildCount(); i++) {
                    if (position == i) {
                        lsView.getChildAt(i).setBackgroundColor(Color.BLUE);
                    } else {
                        lsView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
            }
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra(CLASS_MSG_KEY,"Class : " + myItems[position]);
                startActivity(intent);
            }
        });

        editText2 = (EditText) findViewById(R.id.name_name);
        editText1 = (EditText) findViewById(R.id.edttxt_ma1);
        btn1 = (Button) findViewById(R.id.btn1_ma1);

        btn1.setOnClickListener(new View.OnClickListener() {
             @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    Bundle strings = new Bundle();
                    strings.putString(AGE_MSG_KEY, "Age is: " + editText1.getText());
                    strings.putString(NAME_MSG_KEY, "Name is: " + editText2.getText());
                    intent.putExtras(strings);

                    startActivity(intent);
                }
            });
        }

    }

