package com.example.avenash_2.walmartstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ShoppingActivity extends AppCompatActivity {

    TextView lblWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        lblWelcome=findViewById(R.id.lblWelcome);
        Intent intent = getIntent();
        String userEmail = intent.getStringExtra(String.valueOf(R.id.txtEmail));
        lblWelcome.setText(userEmail);
    }

    public void OnImageClick(View view) {
        //UtilityClass.hideSoftKeyboard(this);
        final int id=view.getId();
        String message="";
        switch(id){
            case R.id.ivBeauty:
                message="You have chosen the Beauty category of shopping";
                break;
            case R.id.ivClothing:
                message="You have chosen the Clothing category of shopping";
                break;
            case R.id.ivElectronics:
                message="You have chosen the Electronics category of shopping";
                break;
            case R.id.ivFood:
                message="You have chosen the Food category of shopping";
                break;
        }

        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_LONG).show();
    }
}
