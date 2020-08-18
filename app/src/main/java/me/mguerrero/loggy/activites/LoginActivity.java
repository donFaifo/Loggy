package me.mguerrero.loggy.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import me.mguerrero.loggy.R;
import me.mguerrero.loggy.app.Prefs;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private EditText eMail;
    private EditText password;
    private Switch remember;
    private Button buttonLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = getSharedPreferences(Prefs.DEFAULT_PREFERENCES, Context.MODE_PRIVATE);

        bindUI();

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidForm()) {
                    if (remember.isChecked()) {
                        setSharedPrefs();
                    }
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void bindUI() {
        eMail = findViewById(R.id.eMail);
        password = findViewById(R.id.password);
        remember = findViewById(R.id.remember);
        buttonLogIn = findViewById(R.id.buttonLogIn);

        if (preferences.contains(Prefs.EMAIL) && preferences.contains(Prefs.PASSWORD)) {
            eMail.setText(preferences.getString(Prefs.EMAIL,null));
            password.setText(preferences.getString(Prefs.PASSWORD, null));
            remember.setChecked(true);
        } else {
            remember.setChecked(false);
        }
    }

    private boolean isValidForm() {
        // TODO: validación de datos de Login
        return true;
    }

    private void setSharedPrefs() {
        preferences.edit()
                .putString(Prefs.EMAIL, eMail.getText().toString())
                .putString(Prefs.PASSWORD, password.getText().toString())
                .apply();
    }
}