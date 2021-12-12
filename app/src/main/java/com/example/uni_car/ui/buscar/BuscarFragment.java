package com.example.uni_car.ui.buscar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.uni_car.R;
import com.example.uni_car.databinding.FragmentBuscarBinding;
import com.google.firebase.database.core.view.CacheNode;

import java.util.Calendar;


public class BuscarFragment extends Fragment {

    private BuscarViewModel buscarViewModel;
    private FragmentBuscarBinding binding;
    private Button bfecha;
    private Button bhora;
    private EditText tfecha;
    private EditText thora;
    private int ano,mes,dia,hora,min;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        buscarViewModel =
                new ViewModelProvider(this).get(BuscarViewModel.class);

        binding = FragmentBuscarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        bfecha = (Button)root.findViewById(R.id.btnfecha);
        bhora = (Button)root.findViewById(R.id.btnhora);
        thora = root.findViewById(R.id.editexthora);
        tfecha = root.findViewById(R.id.editextfecha);
        bfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    final Calendar c = Calendar.getInstance();
                    dia= c.get(Calendar.DAY_OF_MONTH);
                    mes = c.get(Calendar.MONTH);
                    ano = c.get(Calendar.YEAR);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(root.getContext(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            tfecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                        }

                    } ,dia,mes,ano);
                    datePickerDialog.show();

                }

        });

        bhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                hora= c.get(Calendar.HOUR_OF_DAY);
                min = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(root.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        thora.setText(hourOfDay+":"+minute);
                    }
                },hora,min,false);
                timePickerDialog.show();
            }
        });


        buscarViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {


            }


        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}