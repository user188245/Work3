package com.example.user.work3;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ImageView imageView;
    TextView textState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        setTitle("치킨과 스파게티");
        linearLayout = (LinearLayout)findViewById(R.id.l1);
        textState = (TextView)findViewById(R.id.textState);
        imageView = (ImageView)findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemRed:
                linearLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.itemBlue:
                linearLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.itemYellow:
                linearLayout.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.itemRotation:
                imageView.setRotation(imageView.getRotation()+30.0f);
                break;
            case R.id.itemMagnify:
                if(item.isChecked()){
                    item.setChecked(false);
                    imageView.setScaleX(1f);
                    imageView.setScaleY(1f);
                }else{
                    item.setChecked(true);
                    imageView.setScaleX(1.414f);
                    imageView.setScaleY(1.414f);
                }
                break;
            case R.id.itemShow:
                if(item.isChecked()){
                    item.setChecked(false);
                    imageView.setVisibility(View.INVISIBLE);}
                else{
                    item.setChecked(true);
                    imageView.setVisibility(View.VISIBLE);}
                break;
            case R.id.itemChichen:
                item.setChecked(true);
                imageView.setImageResource(R.drawable.chicken);
                textState.setText("치킨");
                break;
            case R.id.itemSpagetti:
                item.setChecked(true);
                imageView.setImageResource(R.drawable.pasta);
                textState.setText("스파게티");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
