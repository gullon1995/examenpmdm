package com.example.examenpmdm;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String datospersonales = "datospersonales";
        public static final String NOMBRE= "NOMBRE";
        public static final String APELLIDO= "APELLIDO";
    }
}

