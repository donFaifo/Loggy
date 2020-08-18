package me.mguerrero.loggy.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import me.mguerrero.loggy.activites.LoginActivity;
import me.mguerrero.loggy.activites.MainActivity;
import me.mguerrero.loggy.app.Prefs;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // TODO: Crear dibujo de splash screen
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(Prefs.DEFAULT_PREFERENCES, Context.MODE_PRIVATE);

        if (preferences != null && checkLogIn()) {
            goToActivity(MainActivity.class);
        } else {
            goToActivity(LoginActivity.class);
        }

    }

    private boolean checkLogIn() {
        return preferences.contains(Prefs.EMAIL) && preferences.contains(Prefs.PASSWORD);
    }

    private <T> void goToActivity(Class<T> activityClass) {
        Intent intent = new Intent(this, activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}