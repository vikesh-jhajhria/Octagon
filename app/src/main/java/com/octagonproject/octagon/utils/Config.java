package com.octagonproject.octagon.utils;

/**
 * Created by Vikesh on 10/21/2016.
 */

public class Config {

    public static final int PAYPAL_REQUEST_CODE = 123;

    public final static int SPLASH_TIME = 2000;
    public final static String YOUTUBE_KEY = "AIzaSyCbTifD4vSnJTEpJSfVdlC1tr03iWcAMOE";
    public final static String USERNAME = "octagon";
    public final static String PASSWORD = "partridge";
    public final static String PAYPAL_CLIENT_ID = "AcyuFNqouOnsFZEgvNXWR2sWU1ywPzs2q9OdahND6-6NlshCc5iTf20iESdVnFj37IM3r_iPN8vSNo9s";


    public final static String BASE_URL = "http://workbench.octagonproject.com/api/";
    public final static String LOGIN = BASE_URL + "user/generate_auth_cookie/?insecure=cool";
    public final static String SOCIAL_LOGIN = BASE_URL + "user/fb_connect/?insecure=cool";
    public final static String REGISTER = BASE_URL + "user/register/?insecure=cool";
    public final static String NONCE = BASE_URL + "get_nonce/?controller=user&method=register";


}
