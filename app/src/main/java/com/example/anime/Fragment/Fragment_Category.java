package com.example.anime.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.anime.R;

public class Fragment_Category extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtxemthem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_category,container,false);
        anhxa();
        return view;

    }

    private void anhxa() {
        horizontalScrollView = view.findViewById(R.id.hozizontalscroview);
        txtxemthem = view.findViewById(R.id.textviewxemthemCategory);
    }
}
