package com.example.asus.menuarray;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText editNama, editTahun;
    Spinner spKota, spProvinsi;
    TextView txtHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        editNama = (EditText)findViewById(R.id.editNama);
        editTahun = (EditText)findViewById(R.id.editTahun);
        spKota = (Spinner)findViewById(R.id.spKota);
        spProvinsi = (Spinner)findViewById(R.id.spProvinsi);
        txtHasil = (TextView)findViewById(R.id.txtHasil);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doProcess();
            }

            private  void doProcess()
            {
                if (isValid())
                {
                    String nama = editNama.getText().toString();
                    int tahun = Integer.parseInt(editTahun.getText().toString());
                    int Usia = 2019 - tahun;
                    txtHasil.setText("Nama Anda "+nama +"\n" + "Anda Berusia " +Usia+" Tahun"+"\n"+"Anda berasal dari Kota "+spKota.getSelectedItem().toString()+"\n"+"Provinsi " +spProvinsi.getSelectedItem().toString());
                }
            }
            private boolean isValid()
            {
                boolean valid = true;
                String nama = editNama.getText().toString();
                String tahun = editTahun.getText().toString();

                if (TextUtils.isEmpty(nama))
                {
                    editNama.setError("Nama Tidak Boleh Kosong");
                    valid = false;
                }
                else if (nama.length()<3)
                {
                    editNama.setError("Karakter Nama kurang dari 3");
                    valid = false;

                }

                if (TextUtils.isEmpty(tahun))
                {
                    editTahun.setError("Tahun Tidak Boleh Kosong");
                    valid = false;
                }
                else if (tahun.length()<3)
                {
                    editTahun.setError("Karakter Tahun kurang dari 1");
                    valid = false;

                }

            return valid;}
        });
    }


}
