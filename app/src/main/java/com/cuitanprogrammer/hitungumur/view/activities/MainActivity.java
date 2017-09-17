package com.cuitanprogrammer.hitungumur.view.activities;

import android.app.DatePickerDialog;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.cuitanprogrammer.hitungumur.HitunUmurApplication;
import com.cuitanprogrammer.hitungumur.R;
import com.cuitanprogrammer.hitungumur.model.UmurDiscover;
import com.cuitanprogrammer.hitungumur.presenter.MainPresenter;
import com.cuitanprogrammer.hitungumur.view.fragments.UmurDialogFrament;
import com.cuitanprogrammer.hitungumur.view.interfaces.MainView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.btnsubmit)
    Button btnsubmit;
    @BindView(R.id.txtnama)
    EditText txtnama;
    @BindView(R.id.txttanggal)
    EditText txttanggal;

    private UmurDialogFrament dialogFrament = null;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);
        dialogFrament = new UmurDialogFrament();

        txttanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        txttanggal.setText(i2 + "-" + (i1 + 1) + "-" + i);
                    }
                }, mYear, mMonth, mDay);

                datePickerDialog.show();

            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getData(txtnama.getText().toString(), txttanggal.getText().toString());
            }
        });
    }

    @Override
    public void setData(UmurDiscover data) {

    }

    @Override
    public void tampilDialog(String nama, String tanggal) {
        UmurDialogFrament dialogFrament = UmurDialogFrament.newInstance(nama,tanggal);
        dialogFrament.show(getSupportFragmentManager(),"dialog");
    }
}
