package android.demo.quanlychitieu_hdh;

import android.demo.quanlychitieu_hdh.request.PostMoneyLog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddActivity extends AppCompatActivity {

    public static EditText edtName, edtAmount, edtNote;
    public static RadioButton radioIncome, radioOutCome;
    public static Button btnOk, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        AnhXa();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();

            }
        });
    }

    void AnhXa(){
        edtName = findViewById(R.id.edtName);
        edtAmount = findViewById(R.id.edtAmount);
        edtNote = findViewById(R.id.edtNote);
        btnCancel = findViewById(R.id.btnCancel);
        btnOk = findViewById(R.id.btnOk);
        radioIncome = findViewById(R.id.radioIncome);
        radioOutCome = findViewById(R.id.radioOutcome);
    }

    void add(){
        new PostMoneyLog(this).execute();
        //Toast.makeText(this, reponse, Toast.LENGTH_SHORT).show();

    }
}
