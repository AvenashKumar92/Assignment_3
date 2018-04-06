package com.example.avenash_2.lab4_q2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumber=findViewById(R.id.editText);
    }

    boolean isNumberEmpty(){
        if(String.valueOf(txtNumber.getText()).isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Please type the number", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


    public void OnCall(View view) {

        if(!isNumberEmpty())
            return;

        Intent intent = new Intent(Intent.ACTION_DIAL);
        String number= "tel:"+String.valueOf(txtNumber.getText());
        intent.setData(Uri.parse(number));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Dial intend is not available in the device", Toast.LENGTH_LONG).show();
        }
    }

    public void OnSendSMS(View view) {

        if(!isNumberEmpty())
            return;
        String number = String.valueOf(txtNumber.getText());
        Intent intent = new Intent(Intent.ACTION_VIEW,  Uri.fromParts("sms", number, null));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "SMS intend is not available in the device", Toast.LENGTH_LONG).show();
        }
        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
    }

    public void OnClickWhatsapp(View view) {

        if(!isNumberEmpty())
            return;
        String number = String.valueOf(txtNumber.getText());
        Uri uri = Uri.parse("smsto:" + number);
        Intent intent = new Intent(Intent.ACTION_SEND, uri);
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Whatsapp intend is not available in the device", Toast.LENGTH_LONG).show();
        }
    }

    public void OnEmailNumber(View view) {

        if(!isNumberEmpty())
            return;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        String number= String.valueOf(txtNumber.getText());
        intent.putExtra(Intent.EXTRA_TEXT, "Please call me at "+number);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Email intend is not available in the device", Toast.LENGTH_LONG).show();
        }
    }
}
