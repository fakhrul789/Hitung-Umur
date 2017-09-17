package com.cuitanprogrammer.hitungumur.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cuitanprogrammer.hitungumur.HitunUmurApplication;
import com.cuitanprogrammer.hitungumur.R;
import com.cuitanprogrammer.hitungumur.model.Umur;
import com.cuitanprogrammer.hitungumur.model.UmurDiscover;
import com.cuitanprogrammer.hitungumur.rest.ApiClient;

import org.w3c.dom.Text;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by islam on 16/09/17.
 */

public class UmurDialogFrament extends DialogFragment {
    ImageView imageView;
    TextView nama;
    TextView harilahir;
    TextView ultah;
    TextView usia;
    TextView zodiak;

    UmurDiscover data;

    public UmurDialogFrament() {

    }

    public static UmurDialogFrament newInstance(String nama, String tanggal) {
        UmurDialogFrament fragment = new UmurDialogFrament();
        Bundle bundle = new Bundle();
        bundle.putString("nama", nama);
        bundle.putString("tanggal", tanggal);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.umur_dialog_fragment, container, false);
        imageView = (ImageView) view.findViewById(R.id.imagezodiak);
        nama = (TextView) view.findViewById(R.id.txtnama);
        harilahir = (TextView) view.findViewById(R.id.txtharilahir);
        ultah = (TextView) view.findViewById(R.id.txtultah);
        usia = (TextView) view.findViewById(R.id.txtultah);
        usia = (TextView) view.findViewById(R.id.txtusia);
        zodiak = (TextView) view.findViewById(R.id.txtzodiak);
        getData();
        return view;
    }

    private void getData() {
        ApiClient client = new ApiClient();
        client.get(HitunUmurApplication.getContext()).getData("AKfycbw7gKzP-WYV2F5mc9RaR7yE3Ve1yN91Tjs91hp_jHSE02dSv9w",
                this.getArguments().getString("nama"),
                this.getArguments().getString("tanggal")).enqueue(new Callback<UmurDiscover>() {
            @Override
            public void onResponse(Call<UmurDiscover> call, Response<UmurDiscover> response) {
                Umur umur = response.body().getData();
                int resID = HitunUmurApplication.getContext().getResources().getIdentifier(umur.getZodiak() + ".jpg", "assets", HitunUmurApplication.getContext().getPackageName());
                imageView.setImageResource(resID);
                nama.setText(umur.getNama());
                harilahir.setText(umur.getLahir());
                ultah.setText(umur.getUltah());
                usia.setText(umur.getUsia());
                zodiak.setText(umur.getZodiak());
            }

            @Override
            public void onFailure(Call<UmurDiscover> call, Throwable throwable) {

            }
        });
    }
}
