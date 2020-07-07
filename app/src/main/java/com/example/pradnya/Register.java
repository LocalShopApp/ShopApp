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

public class Register extends AppCompatActivity {

    private EditText rname,rpass,rmail,login;
    private Button register;
    private FirebaseAuth firebaseAuth;
    private TextView alogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();

        alogin=(TextView) findViewById(R.id.alogin);
        rmail = (EditText) findViewById(R.id.rmail);
        rpass = (EditText) findViewById(R.id.rpass);
        rname = (EditText) findViewById(R.id.rname);
        register = (Button) findViewById(R.id.register);

   register.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

               String uemail=rmail.getText().toString().trim();
               String upass=rpass.getText().toString().trim();
               firebaseAuth.createUserWithEmailAndPassword(uemail,upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()) {
                           Toast.makeText(Register.this, "Registration Succcesful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this,MainActivity.class));
                       }
                       else
                           Toast.makeText(Register.this, "Registration Failed ", Toast.LENGTH_SHORT).show();
                       }
               });
           }

   });


   alogin.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           startActivity(new Intent(Register.this,MainActivity.class));
       }
   });

    }
}