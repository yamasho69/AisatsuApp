package jp.techacademy.shohei.yamamoto.aisatsuapp;

import android.app.TimePickerDialog;
import android.util.Log;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // ①メンバ変数を定義
    TextView mTextView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        // ②findViewByIdを使ってインスタンスを代入
        mTextView = (TextView) findViewById(R.id.textView);
        TimePicker timePicker = new TimePicker(this);
        timePicker.getCurrentHour();
        timePicker.getCurrentMinute();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.button1){
           showTimePickerDialog();
        }
    }
    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        if (hourOfDay >= 2 && hourOfDay <= 9) {
                            mTextView.setText("おはよう");
                        } else if(hourOfDay >= 10 && hourOfDay <= 17){
                            mTextView.setText("こんにちは");
                        } else {mTextView.setText("こんばんは");
                        }
                    }
                },
                13, //初期値（時間）
                0, //初期値（分）
                true);
        timePickerDialog.show();
    }
}
