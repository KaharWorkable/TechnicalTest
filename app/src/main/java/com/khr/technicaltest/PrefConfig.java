package com.khr.technicaltest;

import java.lang.reflect.Type;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.khr.technicaltest.PayHistory;
import com.google.gson.stream.JsonReader;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrefConfig {
    private static final String LIST_KEY = "list_key100";

    public static void writeListInPref(Context context, ArrayList<PayHistory> payArray) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(payArray);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY, jsonString);
        editor.apply();
    }

    public static ArrayList<PayHistory> readListFromPref(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<PayHistory>>() {}.getType();
        ArrayList<PayHistory> payArray = gson.fromJson(jsonString, type);
        return payArray;
    }
}
