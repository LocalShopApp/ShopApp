package com.example.pradnya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText mail,pass;
    private Button log;
    private TextView nreg;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth=FirebaseAuth.getInstance();

        FirebaseUser user= firebaseAuth.getCurrentUser();



        nreg=(TextView)findViewById(R.id.nreg);
        mail = (EditText) findViewById(R.id.mail);
        pass = (EditText) findViewById(R.id.pass);
        log = (Button) findViewById(R.id.log);


        log.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
         validate(mail.getText().toString(),pass.getText().toString());


            }
        });

         nreg.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(MainActivity.this,Register.class));
             }
         });

    }
    void validate(String m,String p)
    {
        firebaseAuth.signInWithEmailAndPassword(m,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(MainActivity.this,"Helooooo  ",Toast.LENGTH_SHORT).show();
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this,"login successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, Register.class));
                }
                else
                {
                    Toast.makeText(MainActivity.this,"login unsuccessful",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

}