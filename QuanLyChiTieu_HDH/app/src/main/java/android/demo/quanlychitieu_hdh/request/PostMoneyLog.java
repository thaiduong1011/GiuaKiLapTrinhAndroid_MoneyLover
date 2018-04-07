package android.demo.quanlychitieu_hdh.request;

import android.content.Context;
import android.demo.quanlychitieu_hdh.AddActivity;
import android.demo.quanlychitieu_hdh.MoneyLog;
import android.os.AsyncTask;

import java.util.HashMap;

/**
 * Created by SunShine on 4/6/2018.
 */

public class PostMoneyLog extends AsyncTask<String, Void, String> {
    String url = "http://172.20.10.10:2000/api/MoneyLog/insertLog";
    Context context;
    MoneyLog moneyLog;


    public PostMoneyLog(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        WebRequest webreq = new WebRequest();

// Making a request to url and getting response

        HashMap<String, String> params =  new HashMap<>();

        //String json = moneyLog.toJSON();
        params.put("name", moneyLog.getName());
        params.put("amount", moneyLog.getAmount() +"");
        params.put("type", moneyLog.getType() +"");
        params.put("note", moneyLog.getNote());
        webreq.makeWebServiceCall(url, WebRequest.POSTRequest, params);

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        int type = MoneyLog.outcome;
        if (AddActivity.radioIncome.isChecked())
            type = MoneyLog.income;

        moneyLog = new MoneyLog(AddActivity.edtName.getText().toString(),
                Integer.parseInt(AddActivity.edtAmount.getText().toString()),
                AddActivity.edtNote.getText().toString(), type);
        //Log.d("AA","onpre " + moneyLog.getName());
    }

}
