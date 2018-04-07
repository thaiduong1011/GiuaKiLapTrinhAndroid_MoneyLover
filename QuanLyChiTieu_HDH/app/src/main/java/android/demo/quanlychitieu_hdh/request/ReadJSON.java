package android.demo.quanlychitieu_hdh.request;

import android.demo.quanlychitieu_hdh.MoneyLog;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SunShine on 4/5/2018.
 */

public class ReadJSON {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String AMOUNT = "amount";
    public static final String DATE = "created_at";
    public static final String NOTE = "note";
    public static final String TYPE = "type";


    public static ArrayList<HashMap<String, MoneyLog>> readJSON(String json) {

        if (json != null) {
            try {
// Hashmap for ListView
                ArrayList<HashMap<String, MoneyLog>> moneyLogList = new ArrayList<>();

// Getting JSON Array node
                JSONArray moneyLogs = new JSONArray(json);

// looping through All Students
                for (int i = 0; i < moneyLogs.length(); i++) {
                    JSONObject c = moneyLogs.getJSONObject(i);

                    Integer id = c.getInt(ID);
                    String name = c.getString(NAME);
                    int amount = c.getInt(AMOUNT);
                    String date= c.getString(DATE);
                    int type = c.getInt(TYPE);
                    String note = c.getString(NOTE);

                    MoneyLog moneyLog = new MoneyLog(id, name, amount, note, date, type);

// tmp hashmap for single student
                    HashMap<String, MoneyLog> moneyLog1 = new HashMap<>();

// adding every child node to HashMap key => value
                    moneyLog1.put(id +"", moneyLog);

// adding student to students list
                    moneyLogList.add(moneyLog1);
                }
                return moneyLogList;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            Log.e("ServiceHandler", "No data received from HTTP request");
            return null;
        }
    }
}
