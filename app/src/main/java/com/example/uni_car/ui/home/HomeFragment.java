package com.example.uni_car.ui.home;

import static com.example.uni_car.AccesoDatos.firebaseAuth;
import static com.example.uni_car.AccesoDatos.getPosts;
import static com.example.uni_car.AccesoDatos.rec;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.uni_car.PerfilActivity;
import com.example.uni_car.R;
import com.example.uni_car.databinding.FragmentHomeBinding;
import com.example.uni_car.recycler.Post;

import java.util.ArrayList;

public class HomeFragment extends androidx.fragment.app.Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private ImageView logo;
    private ImageView perfil;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        perfil = root.findViewById(R.id.btn_perfil);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PerfilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });



        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                logo = root.findViewById(R.id.logounicar);

                rec = root.findViewById(R.id.recyclerHome);
                rec.setLayoutManager(new LinearLayoutManager(root.getContext()));
                ArrayList<Post>posts = new ArrayList<Post>();

                getPosts();
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