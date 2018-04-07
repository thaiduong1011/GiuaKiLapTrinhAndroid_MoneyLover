package android.demo.quanlychitieu_hdh;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SunShine on 4/2/2018.
 */

public class MoneyLog {
    private int id;
    private String name;
    private int amount;
    private String note;
    private String date;
    private int type;
    public static final int outcome = 0;
    public static final int income = 1;

    public MoneyLog() {
    }

    public MoneyLog(String name, int amount, String note, String date, int type) {
        this.name = name;
        this.amount = amount;
        this.note = note;
        this.date = date;
        this.type = type;
    }

    public MoneyLog(String name, int amount, String note, int type) {
        this.name = name;
        this.amount = amount;
        this.note = note;
        this.type = type;
    }

    public MoneyLog(int id, String name, int amount, String note, String date, int type) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.note = note;
        this.date = date;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String toJSON() {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", null);
            jsonObject.put("name", getName());
            jsonObject.put("amount", getAmount() + "");
            jsonObject.put("note", getNote());
            jsonObject.put("type", getType() + "");

            return jsonObject.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }

    }
}
