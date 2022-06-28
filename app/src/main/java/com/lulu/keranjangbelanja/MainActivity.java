package com.lulu.keranjangbelanja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements KeranjangBelanjaListener{

    public RecyclerView rvKatalogFoto;
    public KatalogFotoListAdapter adapter;
    private Button btnKeranjangBelanja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KatalogFotoUtil.init();
        OrderFotoUtil.init();

        rvKatalogFoto = findViewById(R.id.rv_katalog_foto);
        adapter = new KatalogFotoListAdapter(this);

        rvKatalogFoto.setAdapter(adapter);
        rvKatalogFoto.setLayoutManager(new LinearLayoutManager(this));

        btnKeranjangBelanja = findViewById(R.id.btn_keranjang_belanja);
        orderChanged();
        btnKeranjangBelanja.setOnClickListener(this::onClick);
        OrderFotoUtil.addKbListener(this);
    }

    @Override
    public void orderChanged() {
        String kbCountStr = "Keranjang Belanja: " + OrderFotoUtil.getOrderCount();
        btnKeranjangBelanja.setText(kbCountStr);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "App telah di-resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "App dipause", Toast.LENGTH_SHORT).show();
    }

    private void onClick(View view) {
        Intent intent = new Intent(this,
                com.lulu.keranjangbelanja.KeranjangBelanjaActivity.class);
        startActivity(intent);
    }
}