package com.choo.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    android.widget.Button calculatebmi;

    TextView currentheight,currentweight,currentage;
    ImageView incrementage,incrementweight,decrementage,decrementweight,incrementheight,decrementheight;
    SeekBar seekbarforheight;
    RelativeLayout male,female;

    int intweight=55;
    int intage = 22;
    int intheight=170;
    int currentprogress;
    String intprogress="170";
    String typeofuser="0";
    String weight2="55";
    String age2="22";
    String height2="170";










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        calculatebmi=findViewById(R.id.calculatebmi);

        currentage=findViewById(R.id.currentage);
        currentweight=findViewById(R.id.currentweight);
        currentheight=findViewById(R.id.currentheight);
        incrementage=findViewById(R.id.incrementage);
        incrementheight=findViewById(R.id.incrementaheight);
        decrementheight=findViewById(R.id.decrementheight);
        decrementage=findViewById(R.id.decrementage);
        decrementweight=findViewById(R.id.decrementweight);
        incrementweight=findViewById(R.id.incrementweight);
        seekbarforheight=findViewById(R.id.seekbarforheight);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);


        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Female";
            }
        });
        seekbarforheight.setMax(300);
        seekbarforheight.setProgress(170);


        decrementheight.setOnTouchListener(new RepeatListener(400, 100, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // the code to execute repeatedly
                int heightnow = seekbarforheight.getProgress();
                heightnow=heightnow-1;
                height2=String.valueOf(heightnow);
                currentheight.setText(height2);

                seekbarforheight.setProgress(Integer.valueOf(heightnow));
            }
        }));



        incrementheight.setOnTouchListener(new RepeatListener(400, 100, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int heightnow = seekbarforheight.getProgress();
                heightnow=heightnow+1;
                height2=String.valueOf(heightnow);
                currentheight.setText(height2);

                seekbarforheight.setProgress(Integer.valueOf(heightnow));
            }
        }));
        seekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                intprogress=String.valueOf(currentprogress);
                currentheight.setText(intprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        incrementage.setOnTouchListener(new RepeatListener(400, 100, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // the code to execute repeatedly
                intage=intage+1;
                age2=String.valueOf(intage);
                currentage.setText(age2);
            }
        }));
        incrementweight.setOnTouchListener(new RepeatListener(400, 100, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // the code to execute repeatedly
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                currentweight.setText(weight2);
            }
        }));

        decrementweight.setOnTouchListener(new RepeatListener(400, 100, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // the code to execute repeatedly
                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                currentweight.setText(weight2);
            }
        }));
        decrementage.setOnTouchListener(new RepeatListener(400, 100, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // the code to execute repeatedly
                intage=intage-1;
                age2=String.valueOf(intage);
                currentage.setText(age2);
            }
        }));




        calculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (typeofuser.equals("0")){
                    Toast.makeText(getApplicationContext(),"Gender not selected",Toast.LENGTH_SHORT).show();
                }
                else if (intprogress.equals("0")){
                    Toast.makeText(getApplicationContext(),"Height not selected",Toast.LENGTH_SHORT).show();
                }
                else if (intage==0 || intage<0){
                    Toast.makeText(getApplicationContext(),"Invalid Age",Toast.LENGTH_SHORT).show();
                }
                else if (intweight==0 || intweight<0){
                    Toast.makeText(getApplicationContext(),"Invalid Weight",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i  = new Intent(MainActivity.this,bmiactivity.class);
                    i.putExtra("gender",typeofuser);
                    i.putExtra("height",intprogress);
                    i.putExtra("weight",weight2);
                    i.putExtra("age",age2);
                    startActivity(i);

                }











            }
        });
    }
}