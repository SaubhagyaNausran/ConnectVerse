package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.assignment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView refine;
    private LinearLayout refineView;



    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar=findViewById(R.id.topAppBar);
        refineView=findViewById(R.id.refineView);

        refineView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open the new activity
                Intent intent = new Intent(MainActivity.this, RefineActivity.class);
                startActivity(intent);
            }
        });


        setSupportActionBar(toolbar);
        replaceFragment(new Explore());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.exploreBtn:
                    replaceFragment(new Explore());
                    break;


            }


            return true;
        });

    }

    private void replaceFragment(Fragment  fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}