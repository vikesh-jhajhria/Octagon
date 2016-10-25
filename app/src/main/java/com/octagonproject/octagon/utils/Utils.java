package com.octagonproject.octagon.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.util.DisplayMetrics;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vikesh on 23-10-2016.
 */
public class Utils {


    public static HashMap getDeviceSize(Activity activity) {
        HashMap hashMap = new HashMap();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        hashMap.put("Height", displaymetrics.heightPixels);
        hashMap.put("Width", displaymetrics.widthPixels);
        return hashMap;
    }

    public static void setTypeface(Context context, TextView textview, String fontName, String style) {
        /*if (fontName.equalsIgnoreCase(Config.NEXA)) {
            if (style != null && style.equalsIgnoreCase(Config.BOLD)) {
                Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Bold.otf");
                textview.setTypeface(face);
            } else {
                Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Light.otf");
                textview.setTypeface(face);
            }
        }*/

    }

    public static boolean isNetworkConnected(Context context, boolean showToast) {
        ConnectivityManager conManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conManager.getActiveNetworkInfo();
        boolean isConnected = netInfo != null && netInfo.isConnected();
        if (!isConnected && showToast)
            Toast.makeText(context, "No connection", Toast.LENGTH_LONG).show();
        return (netInfo != null && netInfo.isConnected());
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }


    public static String getMonthName(int num) {
        String month = "";
        switch (num) {
            case 1:
                month = "Jan";
                break;
            case 2:
                month = "Feb";
                break;
            case 3:
                month = "Mar";
                break;
            case 4:
                month = "Apr";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "Jun";
                break;
            case 7:
                month = "Jul";
                break;
            case 8:
                month = "Aug";
                break;
            case 9:
                month = "Sep";
                break;
            case 10:
                month = "Oct";
                break;
            case 11:
                month = "Nov";
                break;
            case 12:
                month = "Dec";
                break;

        }
        return month;
    }

    public static void showAlertDialog(Context context, String title, String message, boolean isCancelable) {

        try {
            Builder alertDialogBuilder = new Builder(context);
            alertDialogBuilder.setTitle(title);
            alertDialogBuilder.setMessage(message);
            alertDialogBuilder.setCancelable(isCancelable);
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int arg1) {

                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDecisionDialog(Context context, String title, String message, final AlertCallback callbackListener) {

        try {
            Builder alertDialogBuilder = new Builder(context);
            alertDialogBuilder.setTitle(title);
            alertDialogBuilder.setMessage(message);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int arg1) {
                    callbackListener.callback();
                    dialog.dismiss();
                }
            });
            alertDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int arg1) {

                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface AlertCallback {
        void callback();
    }

}
