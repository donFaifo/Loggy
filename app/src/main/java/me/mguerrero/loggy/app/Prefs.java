package me.mguerrero.loggy.app;

import android.content.SharedPreferences;

public class Prefs {
    public static String EMAIL = "email";
    public static String PASSWORD = "password";
    public static String REMEMBER = "remember";
    public static String DEFAULT_PREFERENCES = "preferences";

    public static String getMail(SharedPreferences preferences) {
        return preferences.getString(EMAIL, null);
    }

    public static String getPassword(SharedPreferences preferences) {
        return preferences.getString(PASSWORD, null);
    }

    public static boolean isRemembered(SharedPreferences preferences) {
        return preferences.getBoolean(REMEMBER, false);
    }
}
