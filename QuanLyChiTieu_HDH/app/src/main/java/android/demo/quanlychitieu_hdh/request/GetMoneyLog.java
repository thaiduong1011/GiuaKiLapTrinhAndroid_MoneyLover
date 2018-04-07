package android.demo.quanlychitieu_hdh.request;

import android.content.Context;
import android.demo.quanlychitieu_hdh.MainActivity;
import android.demo.quanlychitieu_hdh.MoneyLogAdapter;
import android.demo.quanlychitieu_hdh.R;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by SunShine on 4/5/2018.
 */

public class GetMoneyLog extends AsyncTask<Void, Void, Void> {

    String url = "http://172.20.10.10:2000/api/MoneyLog/getList";
    Context context;

    public GetMoneyLog(Context context){
        this.context = context;
    }


    @Override
    protected Void doInBackground(Void... voids) {
        Log.d("AA","dang o doMoneyLog");
        // Creating service handler class instance
        WebRequest webreq = new WebRequest();

// Making a request to url and getting response
        String jsonStr = webreq.makeWebServiceCall(url, WebRequest.GETRequest);

        MainActivity.itemList = ReadJSON.readJSON(jsonStr);
        Log.d("json", jsonStr);

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.adapter = new MoneyLogAdapter(context, MainActivity.itemList, R.layout.moneylog_row);
        MainActivity.listView.setAdapter(MainActivity.adapter);
    }
}
