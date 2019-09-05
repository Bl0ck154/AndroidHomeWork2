package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class Task2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_task2);

        LinearLayout myLL = new LinearLayout(this);
        myLL.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams llParams
                = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
        llParams.gravity = Gravity.CENTER;


//        GridLayout.LayoutParams gridParams = new GridLayout.LayoutParams();
//        gridParams.setGravity(Gravity.CENTER);
//        gridParams.width = GridLayout.LayoutParams.MATCH_PARENT;
//        gridParams.height = GridLayout.LayoutParams.MATCH_PARENT;

        GridLayout grid = new GridLayout(this);
        grid.setLayoutParams(llParams);
        grid.setBackgroundColor(Color.rgb(208,224,208));

        GridLayout innerGrid = this.createGrid2x2(llParams);

        grid.addView(innerGrid);

        FrameLayout frameLL = new FrameLayout(this);
        frameLL.setLayoutParams(llParams);
        frameLL.setBackgroundColor(Color.rgb(224,208,208));

        GridLayout frameGrid = this.createGrid2x2(llParams);
        frameLL.addView(frameGrid);

        myLL.addView(grid);
        myLL.addView(frameLL);

        setContentView(myLL, llParams);
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

    GridLayout createGrid2x2(ViewGroup.LayoutParams llParams) {
        GridLayout innerGrid = new GridLayout(this);
        innerGrid.setLayoutParams(llParams);
        innerGrid.setRowCount(2);
        innerGrid.setColumnCount(2);

        for (int i = 1; i <= 4; i++) {
            Button btn = new Button(this);
            btn.setText(String.valueOf(i));
            innerGrid.addView(btn);
        }
        return innerGrid;
    }
}
