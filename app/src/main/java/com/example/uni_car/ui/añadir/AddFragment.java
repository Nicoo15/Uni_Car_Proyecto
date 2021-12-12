package com.example.uni_car.ui.añadir;

import static com.example.uni_car.AccesoDatos.firebaseAuth;
import static com.example.uni_car.AccesoDatos.getPosts;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.uni_car.AccesoDatos;
import com.example.uni_car.R;
import com.example.uni_car.RegisterActivity;
import com.example.uni_car.databinding.FragmentAddBinding;

import java.util.Calendar;


public class AddFragment extends Fragment {

    private AddViewModel addViewModel;
    private FragmentAddBinding binding;
    private Button bfecha;
    private Button bhora;
    private EditText tfecha;
    private EditText thora;
    private int ano,mes,dia,hora,min;
    private EditText telf;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addViewModel =
                new ViewModelProvider(this).get(AddViewModel.class);

        binding = FragmentAddBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        bfecha = (Button)root.findViewById(R.id.addfecha);
        bhora = (Button)root.findViewById(R.id.addhora);
        thora = root.findViewById(R.id.edithora);
        tfecha = root.findViewById(R.id.editaddFecha);
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




        addViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                EditText origen;
                EditText destino;
                EditText fecha;
                EditText hora;
                EditText telfn;
                Button send;
                origen = root.findViewById(R.id.editOrigen);
                destino = root.findViewById(R.id.editDestino);
                fecha = root.findViewById(R.id.editaddFecha);
                hora = root.findViewById(R.id.edithora);
                telfn = root.findViewById(R.id.numtelf);
                send = root.findViewById(R.id.send);

                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String origenS, destinoS, fechaS, horaS,telfnS;
                        origenS = origen.getText().toString();
                        destinoS = destino.getText().toString();
                        fechaS = fecha.getText().toString();
                        horaS = hora.getText().toString();
                        telfnS = telfn.getText().toString();
                        String [] s = firebaseAuth.getCurrentUser().getEmail().split("@");
                        AccesoDatos.uploadData(origenS, destinoS, fechaS,s[0], horaS, telfnS);
                        getPosts();
                        Toast.makeText(root.getContext(), "Se Ha añadido Correctamente", Toast.LENGTH_LONG).show();
                        return;
                    }
                });
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