package com.httt.viettravel.TabHistory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.httt.viettravel.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReviewFragment extends Fragment {

    private ImageView imageView;
    private TextView locationView;
    private TextView routineView;
    private TextView timeView;
    private TextView priceView;
    private TextView vehicleView;
    private TextView placeView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ReviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReviewFragment newInstance(String param1, String param2) {
        ReviewFragment fragment = new ReviewFragment();
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

        View view = inflater.inflate(R.layout.fragment_review, container, false);

        imageView = view.findViewById(R.id.imageView);
        locationView = view.findViewById(R.id.textViewLocation);
        routineView = view.findViewById(R.id.textViewRoutine);
        timeView = view.findViewById(R.id.textViewTime);
        priceView = view.findViewById(R.id.textViewPrice);
        vehicleView = view.findViewById(R.id.textViewVehicle);
        placeView = view.findViewById(R.id.textViewPlace);

        Bundle bundle = getArguments();
        if (bundle != null) {
            imageView.setImageResource(bundle.getInt("pic"));
            locationView.setText(bundle.getString("location"));
            routineView.setText(bundle.getString("routine"));
            timeView.setText(bundle.getString("time"));
            priceView.setText(bundle.getString("price"));
            vehicleView.setText(bundle.getString("vehicle"));
            placeView.setText(bundle.getString("place"));
        }

        // Handle review submission here

        return view;
    }
}