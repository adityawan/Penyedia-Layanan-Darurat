package com.example.windyseptaa.penyedialayanandarurat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RumahSakitFragment extends Fragment {

    public static final String TITLE = "Rumah Sakit";

    public static RumahSakitFragment newInstance() {

        return new RumahSakitFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rumah_sakit, container, false);
    }
}
