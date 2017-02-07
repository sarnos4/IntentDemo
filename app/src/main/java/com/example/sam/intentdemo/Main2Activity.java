package com.example.sam.intentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.sam.intentdemo.utils.Utils.AGE_MSG_KEY;
import static com.example.sam.intentdemo.utils.Utils.NAME_MSG_KEY;

public class Main2Activity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1=(TextView)findViewById(R.id.tv1_ma2);
        String incomingMsg=getIntent().getExtras().getString(AGE_MSG_KEY);
        textView1.setText(incomingMsg);


        textView2=(TextView)findViewById(R.id.tv2_ma2);
        String incomingName=getIntent().getExtras().getString(NAME_MSG_KEY);
        textView2.setText(incomingName);

    }
}
