package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    TextView tv_orderItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        String order = "Order: " + intent.getStringExtra(MainActivity.orderMessage_Extra);

        tv_orderItem = findViewById(R.id.tv_orderItem);

        tv_orderItem.setText(order);

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radio_sameDay:
                if(checked){
                    displayToast(getString(R.string.same_day_delivery));
                }
                break;
            case R.id.radio_nextDay:
                if(checked){
                    displayToast(getString(R.string.next_day_delivery));
                }
                break;
            case R.id.radio_pickup:
                if(checked){
                    displayToast(getString(R.string.in_store_pickup));
                }
                break;
            default:
                break;
        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}