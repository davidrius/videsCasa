package com.david.vides;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.david.vides.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    //P1

    int pocion = 0; //boton P+ del jugador 1
    int pocion2 = 0; //boton P- del jugador 1
    int vida = 0; //Aádir vida Jugador 1
    int vida2 = 0; //Quitar vida Jugador 1


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);


        reset();

        if(savedInstanceState != null){

            //P1

            pocion = savedInstanceState.getInt("buttonPMP1");
            pocion2 = savedInstanceState.getInt("buttonPMNP1");
            vida = savedInstanceState.getInt("imageButtonAddVidaP1");
            vida2 = savedInstanceState.getInt("imageButtonRemoveVidaP1");


        }

        updateCounters();

        return binding.getRoot();

    }

    private void updateCounters(){


        binding.textViewVidaPocionP1.setText(vida + "/" + pocion);
        binding.textViewVidaPocionP2.setText(vida2 + "/" + pocion2);


    }

    private void reset(){

        vida = 20;
        vida2 = 20;
        pocion = 0;
        pocion2 = 0;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       binding.imageButtonAddVidaP1.setOnClickListener(btn -> {

           vida++;
           updateCounters();

        });

        binding.imageButtonAddVidaP2.setOnClickListener(btn -> {

            vida2++;
            updateCounters();

        });

        binding.imageButtonRemoveVidaP1.setOnClickListener(btn -> {

            vida--;
            updateCounters();

        });

        binding.imageButtonRemoveVidaP2.setOnClickListener(btn -> {

            vida2--;
            updateCounters();

        });

        binding.buttonPMP1.setOnClickListener(btn -> {

            pocion++;
            updateCounters();

        });

        binding.buttonPMNP1.setOnClickListener(btn -> {

            pocion--;
            updateCounters();

        });

        binding.buttonPMP2.setOnClickListener(btn -> {

            pocion2++;
            updateCounters();

        });

        binding.buttonPMNP2.setOnClickListener(btn -> {

            pocion2--;
            updateCounters();

        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}