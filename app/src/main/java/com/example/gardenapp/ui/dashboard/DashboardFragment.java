package com.example.gardenapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gardenapp.R;
import com.example.gardenapp.data.plant.PlantAPIHandler;
import com.example.gardenapp.databinding.FragmentDashboardBinding;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textShow;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView results = view.findViewById(R.id.text_show);
        EditText filterValue = view.findViewById(R.id.filter_value);
        Button searchButton = view.findViewById(R.id.search_button);
        PlantAPIHandler api = new PlantAPIHandler();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commonName;
                try {
                    commonName = URLEncoder.encode(filterValue.getText().toString(), "UTF-8");
                    JSONObject obj = api.findPlantsByName(commonName);
                    results.setText(obj.toString());
                }

                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}