package com.example.jjcrow.cursoandroidespolsesin1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLOutput;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    EditText et_usuario, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_usuario= (EditText) findViewById(R.id.et_usuario);
        et_password= (EditText) findViewById(R.id.et_password);
        btn_login= (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Boton TOCADO!!!");
                String usuario= et_usuario.getText().toString();
                String password= et_password.getText().toString();
                if(usuario.equals("admin") && password.equals("1234")){
                    //Toast.makeText(LoginActivity.this, "USUARIO VALIDO!", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("usuario",usuario);
                    startActivity(intent);
                    //LoginActivity.this.finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "USUARIO INVALIDO! Ingrese de nuevo", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
