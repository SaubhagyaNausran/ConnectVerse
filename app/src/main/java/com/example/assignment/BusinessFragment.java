package com.example.assignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class BusinessFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<itemsofcardview> itemsofcardviewArrayList;
    private int[] profileImageResourceId;
    private int[] distanceOfStudentImageResourceId;
    private String[] name;
    private String[] address;
    private String[] distance;
    private String[] bio;
    private String[] description;
    private RecyclerView recyclerview;

    private FloatingActionButton fab;

    private int previousScrollPosition = 0;
    private static final int HIDE_THRESHOLD = 20;


    public BusinessFragment() {
        // Required empty public constructor
    }

    public static PersonalFragment newInstance(String param1, String param2) {
        PersonalFragment fragment = new PersonalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bussiness, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitilaize();
        fab = view.findViewById(R.id.floating_action_button);
        recyclerview = view.findViewById(R.id.recyclerView);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        BusinessFragmentAdapter myAdapter = new BusinessFragmentAdapter(getContext(), itemsofcardviewArrayList);
        recyclerview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!recyclerView.canScrollVertically(-1)) {
                    // Scrolled to the top
                    Animation myAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_down);
                    fab.startAnimation(myAnim);
                    fab.show();
                } else  if (dy > 0 && fab.isShown()) {
                    // Scrolled to the bottom
                    Animation myAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_up);
                    fab.startAnimation(myAnim);
                    fab.hide();
                }

            }
        });
    }

    public void dataInitilaize() {

        itemsofcardviewArrayList = new ArrayList<>();

        name = new String[]{
                "Ethan",
                "Daniel",
                "Olivia",
                "Isabella",
                "Samuel",
                "Emma",
                "Noah",
                "Charlotte",
        };

        address = new String[]{
                "Bangalore | Student",
                "Chandigarh | Fresher",
                "Noida | Software Developer",
                "Delhi | Fresher",
                "Gurgaon | Software Tester",
                "Pune | Student",
                "Mumbai | Manual Testing",
                "Bangalore | Student",


        };

        distance = new String[]{
                "with in 100 m",
                "with in 100-200 m",
                "with in 300-400 m",
                "with in 300-400 m",
                "with in 400-500 m",
                "with in 500-600 m",
                "with in 600-700 m",
                "with in 700-800 m",


        };

        bio = new String[]{
                "Coffee | Business | Friendship",
                "Coffee | Business | Hobbies",
                "Coffee | Business | Movies",
                "Coffee | Business | Friendship",
                "Coffee | Business | Friendship",
                "Coffee | Business | Friendship",
                "Coffee | Business | Friendship",
                "Coffee | Business | Friendship",


        };

        description = new String[]{
                "Hi community! I am open to new connections",
                "Hi community! I am open to new connections",
                "Hi community! I am open to new connections",
                "Hi community! I am open to new connections",
                "Hi community! I am open to new connections",
                "Hi community! I am open to new connections",
                "Hi community! I am open to new connections",
                "Hi community! I am open to new connections",


        };


        profileImageResourceId = new int[]{
                R.drawable.profile2,
                R.drawable.profile3,
                R.drawable.profile1,
                R.drawable.profile5,
                R.drawable.profile4,
                R.drawable.profile6,
                R.drawable.profile2,
                R.drawable.profile1,


        };

        distanceOfStudentImageResourceId = new int[]{
                R.drawable.distanceofstudent,
                R.drawable.distanceofstudent,
                R.drawable.distanceofstudent,
                R.drawable.distanceofstudent,
                R.drawable.distanceofstudent,
                R.drawable.distanceofstudent,
                R.drawable.distanceofstudent,
                R.drawable.distanceofstudent,


        };


        for (int i = 0; i < name.length; i++) {

            itemsofcardview itemsofcardview = new itemsofcardview(name[i], address[i], distance[i], bio[i], description[i], profileImageResourceId[i], distanceOfStudentImageResourceId[i]);
            itemsofcardviewArrayList.add(itemsofcardview);


        }

    }
}