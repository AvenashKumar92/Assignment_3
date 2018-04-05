package com.example.avenash_2.walmartstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<User> users=new ArrayList<>();
    EditText txtEmail;
    EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        txtEmail=findViewById(R.id.txtEmail);
        txtPass=findViewById(R.id.txtPassword);
    }

    private void initList()
    {
        users.add(new User("Avenash", "123"));
        users.add(new User("Rahul", "321"));
        users.add(new User("Rajesh", "123"));
        users.add(new User("Malik", "321"));
        users.add(new User("Osman", "123"));
    }

    private void resetEmailPassword(){
        txtEmail.setText("");
        txtPass.setText("");
    }
    public void OnSignIn(View view) {
        UtilityClass.hideSoftKeyboard(this);
        User loginUser=new User(txtEmail.getText().toString().trim(), txtPass.getText().toString().trim());
        if(!validateUser(loginUser)) {
            Toast.makeText(getApplicationContext(), "Invalid login email or password!",
                    Toast.LENGTH_LONG).show();
            resetEmailPassword();
            return;
        }
        Intent intent = new Intent(this,ShoppingCategory.class);
        intent.putExtra(String.valueOf(R.id.txtEmail), loginUser.getEmail());
        startActivity(intent);
    }

    private boolean validateUser(User loginUser){
        for(User user:users){
            if(user==loginUser){
                return true;
            }
        }
        return false;
    }
}
