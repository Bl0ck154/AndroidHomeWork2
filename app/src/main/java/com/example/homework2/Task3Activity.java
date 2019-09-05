package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Task3Activity extends AppCompatActivity {

    LinearLayout myLL;
    CheckBox red, green, blue;
    TextView textView;
    int[] currentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        myLL = this.findViewById(R.id.myLayout);
        red = this.findViewById(R.id.chkRed);
        green = this.findViewById(R.id.chkGreen);
        blue = this.findViewById(R.id.chkBlue);
        textView = this.findViewById(R.id.textView);

        currentColor = new int[] { 0, 0, 0};
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void checkBoxOnClick(View view) {
        CheckBox clickedCheckbox = (CheckBox)view;
        int invertColor = 0;
        if(clickedCheckbox == red) {
            currentColor[0] = currentColor[0] == 255 ? 0 : 255;
        }
        else if(clickedCheckbox == green) {
            currentColor[1] = currentColor[1] == 255 ? 0 : 255;
        }
        else if(clickedCheckbox == blue) {
            currentColor[2] = currentColor[2] == 255 ? 0 : 255;
        }

        myLL.setBackgroundColor(Color.rgb(currentColor[0], currentColor[1], currentColor[2]));
        invertColor = Color.rgb(currentColor[0] == 255 ? 0 : 255,currentColor[1] == 255 ? 0 : 255,currentColor[2] == 255 ? 0 : 255);

        red.setTextColor(invertColor);
        green.setTextColor(invertColor);
        blue.setTextColor(invertColor);
        
        textView.setTextColor(invertColor);
    }
}
