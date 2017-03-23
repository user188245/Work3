package com.example.user.work3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    TabHost tabHost;
    TextView bmiResult,sizeResult;
    EditText bmiHeight,bmiWeight,sizeEditText;
    Button bmiButton,sizePtoS,sizeStoP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();

    }

    private void init(){
        setTitle("각종 계산기");
        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("1").setContent(R.id.tab1).setIndicator("BMI 측정기"));
        tabHost.addTab(tabHost.newTabSpec("2").setContent(R.id.tab2).setIndicator("면적 계산기"));

        bmiHeight = (EditText) findViewById(R.id.bmiHeight);
        bmiWeight = (EditText) findViewById(R.id.bmiWeight);
        bmiResult = (TextView) findViewById(R.id.bmiResult);
        bmiButton = (Button) findViewById(R.id.bmiButton);

        sizeEditText = (EditText) findViewById(R.id.sizeEditText);
        sizeResult = (TextView) findViewById(R.id.sizeResult);
        sizePtoS = (Button) findViewById(R.id.sizePtoS);
        sizeStoP = (Button) findViewById(R.id.sizeStoP);

    }

    public void onClickButton(View v){
        switch(v.getId()){
            case R.id.bmiButton:
                if(bmiHeight.getText().toString().isEmpty()||bmiWeight.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"키와 몸무게를 모두 입력하세요.",Toast.LENGTH_SHORT).show();
                else
                    findBMIButton(Float.parseFloat(bmiHeight.getText().toString()), Float.parseFloat(bmiWeight.getText().toString()));
                break;

            default:
                if(sizeEditText.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"빈 곳에 값을 입력하세요.",Toast.LENGTH_SHORT).show();
                else
                    if(v.getId() == R.id.sizePtoS)
                        sizeResult.setText(Float.parseFloat(sizeEditText.getText().toString()) * 3.305f +"제곱미터");
                    else
                        sizeResult.setText(Float.parseFloat(sizeEditText.getText().toString()) * 0.3025f +"평");
        }

    }

    private void findBMIButton(float height, float weight){
        height /= 100;
        float bmi = weight/(height*height);
        Toast.makeText(getApplicationContext(),"당신의 bmi는" +  bmi + "입니다", Toast.LENGTH_SHORT).show();
        if(bmi>=30){
            bmiResult.setText("비만입니다.");
            bmiResult.setTextColor(Color.RED);
        }
        else if(bmi>=25){
            bmiResult.setText("경도비만입니다.");
            bmiResult.setTextColor(Color.DKGRAY);
        }
        else if(bmi>=15){
            bmiResult.setText("정상입니다.");
            bmiResult.setTextColor(Color.GREEN);
        }
        else if(bmi<15){
            bmiResult.setText("저체중입니다.");
            bmiResult.setTextColor(Color.LTGRAY);
        }
    }
}
