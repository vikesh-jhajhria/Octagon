package com.octagonproject.octagon.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.octagonproject.octagon.R;
import com.octagonproject.octagon.TourDetailActivity;

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

    public static void jumpToAnyTour(final Activity activity) {

        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.layout_jump_to_tour_popup);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.txt_popup_tour_1:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",1));
                        break;
                    case R.id.txt_popup_tour_2:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",2));
                        break;
                    case R.id.txt_popup_tour_3:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",3));
                        break;
                    case R.id.txt_popup_tour_4:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",4));
                        break;
                    case R.id.txt_popup_tour_5:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",5));
                        break;
                    case R.id.txt_popup_tour_6:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",6));
                        break;
                    case R.id.txt_popup_tour_7:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",7));
                        break;
                    case R.id.txt_popup_tour_8:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",8));
                        break;
                    case R.id.txt_popup_tour_9:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",9));
                        break;
                    case R.id.txt_popup_tour_10:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",10));
                        break;
                    case R.id.txt_popup_tour_11:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",11));
                        break;
                    case R.id.txt_popup_tour_12:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",12));
                        break;
                    case R.id.txt_popup_tour_13:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",13));
                        break;
                    case R.id.txt_popup_tour_14:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",14));
                        break;
                    case R.id.txt_popup_tour_15:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",15));
                        break;
                    case R.id.txt_popup_tour_16:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",16));
                        break;
                    case R.id.txt_popup_tour_17:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",17));
                        break;
                    case R.id.txt_popup_tour_18:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",18));
                        break;
                    case R.id.txt_popup_tour_19:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",19));
                        break;
                    case R.id.txt_popup_tour_20:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",20));
                        break;
                    case R.id.txt_popup_tour_21:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",21));
                        break;
                    case R.id.txt_popup_tour_22:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",22));
                        break;
                    case R.id.txt_popup_tour_23:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",23));
                        break;
                    case R.id.txt_popup_tour_24:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",24));
                        break;
                    case R.id.txt_popup_tour_25:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",25));
                        break;
                    case R.id.txt_popup_tour_26:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",26));
                        break;
                    case R.id.txt_popup_tour_27:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",27));
                        break;
                    case R.id.txt_popup_tour_28:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",28));
                        break;
                    case R.id.txt_popup_tour_29:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",29));
                        break;
                    case R.id.txt_popup_tour_30:
                        activity.startActivity(new Intent(activity,TourDetailActivity.class).putExtra("TOUR_ID",30));
                        break;
                }
                dialog.dismiss();
            }
        };
        dialog.findViewById(R.id.img_close).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_1).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_2).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_3).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_4).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_5).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_6).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_7).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_8).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_9).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_10).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_11).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_12).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_13).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_14).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_15).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_16).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_17).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_18).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_19).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_20).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_21).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_22).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_23).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_24).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_25).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_26).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_27).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_28).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_29).setOnClickListener(clickListener);
        dialog.findViewById(R.id.txt_popup_tour_30).setOnClickListener(clickListener);


        
    }
}
