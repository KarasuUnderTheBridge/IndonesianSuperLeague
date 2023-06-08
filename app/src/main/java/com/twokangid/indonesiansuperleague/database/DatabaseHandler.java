package com.twokangid.indonesiansuperleague.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "KlubManager";
    private static final String CLUB_TABLE = "klub";

    private static final String KEY_ID = "id";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_KOTA = "kota";
    private static final String KEY_JUMLAH_MAIN = "jumlah_main";
    private static final String KEY_JUMLAH_MENANG = "jumlah_menang";
    private static final String KEY_JUMLAH_SERI = "jumlah_seri";
    private static final String KEY_JUMLAH_KALAH = "jumlah_kalah";
    private static final String KEY_JUMLAH_GOAL = "jumlah_goal";
    private static final String KEY_JUMLAH_KEBOBOLAN = "jumlah_kebobolan";
    private static final String KEY_POIN = "poin";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

        @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String CREATE_CLUB_TABLE = "CREATE TABLE " + CLUB_TABLE + "("
                    + KEY_ID + " INTEGER PRIMARY KEY,"
                    + KEY_NAMA + " TEXT,"
                    + KEY_KOTA + " TEXT,"
                    + KEY_JUMLAH_MAIN + " TEXT,"
                    + KEY_JUMLAH_MENANG + " TEXT,"
                    + KEY_JUMLAH_SERI + " TEXT,"
                    + KEY_JUMLAH_KALAH + " TEXT,"
                    + KEY_POIN + " TEXT,"
                    + KEY_JUMLAH_GOAL + " TEXT,"
                    + KEY_JUMLAH_KEBOBOLAN + ")";
            sqLiteDatabase.execSQL(CREATE_CLUB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CLUB_TABLE);
        onCreate(sqLiteDatabase);
    }



    public boolean addRecord(ModelDataKlub modelDataKlub){
        SQLiteDatabase db  = getWritableDatabase();


        if(CheckIsDataAlreadyInDBorNot(CLUB_TABLE, modelDataKlub.getNama())){
            return true;
        }else{
            ContentValues values = new ContentValues();
            values.put(KEY_NAMA, modelDataKlub.getNama());
            values.put(KEY_KOTA, modelDataKlub.getKota());
            values.put(KEY_JUMLAH_MAIN, modelDataKlub.getJumlahMain());
            values.put(KEY_JUMLAH_MENANG, modelDataKlub.getJumlahMenang());
            values.put(KEY_JUMLAH_SERI, modelDataKlub.getJumlahSeri());
            values.put(KEY_JUMLAH_KALAH, modelDataKlub.getJumlahKalah());
            values.put(KEY_JUMLAH_GOAL, modelDataKlub.getJumlahGoal());
            values.put(KEY_JUMLAH_KEBOBOLAN, modelDataKlub.getJumlahKebobolan());
            values.put(KEY_POIN, modelDataKlub.getPoin());

            db.insert(CLUB_TABLE, null, values);
            return false;
        }
    }

     public boolean CheckIsDataAlreadyInDBorNot(String TableName, String fieldValue) {
        SQLiteDatabase sqldb = this.getWritableDatabase();
        String Query = "Select * from " + TableName + " where nama = ?";
        Cursor cursor = sqldb.rawQuery(Query, new String[] {fieldValue});
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public ArrayList<String> getAllClub(){
        ArrayList<String> listClub = new ArrayList<String>();
        String selectQuery = "SELECT nama FROM " + CLUB_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        if (cursor.moveToFirst()) {
            do {
                String namaKlub = cursor.getString(0);
               listClub.add(namaKlub);
            } while (cursor.moveToNext());
        }

        return listClub;
    }

    public ModelDataKlub getClubRecord(String nama){
        ModelDataKlub modelDataKlub = new ModelDataKlub();
        String selectQuery = "SELECT * FROM " + CLUB_TABLE + " WHERE " +  KEY_NAMA+ "= ? ";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{nama});

        if (cursor.moveToFirst()) {
            do {
                modelDataKlub.setNama(cursor.getString(1));
                modelDataKlub.setKota(cursor.getString(2));
                modelDataKlub.setJumlahMain(Integer.parseInt(cursor.getString(3)));
                modelDataKlub.setJumlahMenang(Integer.parseInt(cursor.getString(4)));
                modelDataKlub.setJumlahSeri(Integer.parseInt(cursor.getString(5)));
                modelDataKlub.setJumlahKalah(Integer.parseInt(cursor.getString(6)));
                modelDataKlub.setPoin(Integer.parseInt(cursor.getString(7)));
                modelDataKlub.setJumlahGoal(Integer.parseInt(cursor.getString(8)));
                modelDataKlub.setJumlahKebobolan(Integer.parseInt(cursor.getString(9)));
            } while (cursor.moveToNext());
        }
        return modelDataKlub;
    }

    public List<ModelDataKlub> getAllRecord() {
        List<ModelDataKlub> clubList = new ArrayList<ModelDataKlub>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + CLUB_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelDataKlub modelDataKlub = new ModelDataKlub();
                modelDataKlub.setNama(cursor.getString(1));
                modelDataKlub.setKota(cursor.getString(2));
                modelDataKlub.setJumlahMain(Integer.parseInt(cursor.getString(3)));
                modelDataKlub.setJumlahMenang(Integer.parseInt(cursor.getString(4)));
                modelDataKlub.setJumlahSeri(Integer.parseInt(cursor.getString(5)));
                modelDataKlub.setJumlahKalah(Integer.parseInt(cursor.getString(6)));
                modelDataKlub.setPoin(Integer.parseInt(cursor.getString(7)));
                modelDataKlub.setJumlahGoal(Integer.parseInt(cursor.getString(8)));
                modelDataKlub.setJumlahKebobolan(Integer.parseInt(cursor.getString(9)));
                clubList.add(modelDataKlub);
            } while (cursor.moveToNext());
        }
        return clubList;
    }

    public int updateRecord(ModelDataKlub modelDataKlub){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, modelDataKlub.getNama());
        values.put(KEY_KOTA, modelDataKlub.getKota());
        values.put(KEY_JUMLAH_MAIN, modelDataKlub.getJumlahMain());
        values.put(KEY_JUMLAH_MENANG, modelDataKlub.getJumlahMenang());
        values.put(KEY_JUMLAH_SERI, modelDataKlub.getJumlahSeri());
        values.put(KEY_JUMLAH_KALAH, modelDataKlub.getJumlahKalah());
        values.put(KEY_JUMLAH_GOAL, modelDataKlub.getJumlahGoal());
        values.put(KEY_JUMLAH_KEBOBOLAN, modelDataKlub.getJumlahKebobolan());
        values.put(KEY_POIN, modelDataKlub.getPoin());

        // updating row
        return db.update(CLUB_TABLE, values, KEY_NAMA + " = ?",
                new String[] { modelDataKlub.getNama() });
    }
}
