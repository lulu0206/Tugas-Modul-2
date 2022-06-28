package com.lulu.keranjangbelanja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class KeranjangBelanjaActivity extends AppCompatActivity implements KeranjangBelanjaListener {

    private RecyclerView rvOrderFoto;
    private OrderFotoListAdapter adapter;
    private TextView tvTotal;
    private TextView tvKosong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang_belanja);
        rvOrderFoto = findViewById(R.id.rv_order_foto);
        adapter = new OrderFotoListAdapter(this);

        rvOrderFoto.setAdapter(adapter);
        rvOrderFoto.setLayoutManager(new LinearLayoutManager(this));

        OrderFotoUtil.addKbListener(this);

        tvTotal = findViewById(R.id.tv_total_harga);
        tvKosong = findViewById(R.id.tv_keranjang_kosong);
        orderChanged();
    }

    @Override
    public void orderChanged() {
        if (OrderFotoUtil.getOrderCount() == 0){
            rvOrderFoto.setVisibility(View.GONE);
            tvKosong.setVisibility(View.VISIBLE);
        }
        else {
            rvOrderFoto.setVisibility(View.VISIBLE);
            tvKosong.setVisibility(View.GONE);
        }

        String totalStr = "Total Belanja: " + IdrFormatter.format(OrderFotoUtil.getTotalHarga());
        tvTotal.setText(totalStr);
    }
}