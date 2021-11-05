package com.choo.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;

public class bmiactivity extends AppCompatActivity {
    android.widget.Button recalculatebmi;

    TextView bmidisplay,bmicategory,gender;
    Intent intent;
    ImageView imageView;
    String bmi;
    float intbmi;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout background;
    private static final DecimalFormat df = new DecimalFormat("#.00");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color= \"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();

        bmidisplay=findViewById(R.id.bmidisplay);
        bmicategory=findViewById(R.id.bmicategory);
        gender=findViewById(R.id.genderdisplay);
        background=findViewById(R.id.contentlayout);
        imageView=findViewById(R.id.imageview);
        recalculatebmi=findViewById(R.id.recalculatebmi);


        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);

        bmi=Float.toString(intbmi);


        if (intbmi<16){
            bmicategory.setText("Severe Thiness");
            background.setBackgroundColor(Color.RED);
            Glide.with(this)
                    .load(R.drawable.cross)
                    .into(imageView);
        }
        else if (intbmi<16.9 && intbmi>16){
            bmicategory.setText("Moderate Thiness");
            background.setBackgroundColor(Color.RED);
            Glide.with(this)
                    .load(R.drawable.warning)
                    .into(imageView);
        }
        else if (intbmi<18.4 && intbmi>17){
            bmicategory.setText("Mild Thiness");
            background.setBackgroundColor(Color.RED);
            Glide.with(this)
                    .load(R.drawable.warning)
                    .into(imageView);
        }
        else if (intbmi<25 && intbmi>18.4){
            bmicategory.setText("Normal");
            //background.setBackgroundColor(Color.YELLOW);
            Glide.with(this)
                    .load(R.drawable.tick)
                    .into(imageView);
        }
        else if (intbmi<29.4 && intbmi>25){
            bmicategory.setText("OverWeight");
            background.setBackgroundColor(Color.RED);
            Glide.with(this)
                    .load(R.drawable.warning)
                    .into(imageView);
        }
        else {
            bmicategory.setText("Obese Class I");
            background.setBackgroundColor(Color.RED);
            Glide.with(this)
                    .load(R.drawable.warning)
                    .into(imageView);
        }


        gender.setText(intent.getStringExtra("gender"));
        bmidisplay.setText(df.format(Float.parseFloat(bmi)));












        recalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(bmiactivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}