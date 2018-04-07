package android.demo.quanlychitieu_hdh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SunShine on 4/2/2018.
 */

public class MoneyLogAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<HashMap<String, MoneyLog>> itemList;
    private int layout;

    public MoneyLogAdapter(Context context, ArrayList<HashMap<String, MoneyLog>> itemList, int layout) {
        this.context = context;
        this.itemList = itemList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView name = view.findViewById(R.id.txtContent);
        TextView amount = view.findViewById(R.id.txtAmount);
        TextView note = view.findViewById(R.id.txtNote);
        TextView date = view.findViewById(R.id.txtDate);
        TextView type = view.findViewById(R.id.txtStatus);

        for (String key : itemList.get(i).keySet()) {
            name.setText(itemList.get(i).get(key).getName());
            amount.setText(itemList.get(i).get(key).getAmount() + "");
            note.setText(itemList.get(i).get(key).getNote());
            date.setText(itemList.get(i).get(key).getDate());
            type.setText(itemList.get(i).get(key).getType() + "");
        }


        return view;
    }
}
