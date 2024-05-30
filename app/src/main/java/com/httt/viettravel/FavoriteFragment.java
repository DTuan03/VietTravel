package com.httt.viettravel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.httt.viettravel.Adapter.FavoriteAdapter;
import com.httt.viettravel.Model.Favorite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FavoriteFragment extends Fragment {

    private RecyclerView recyclerView;
    private FavoriteAdapter favoriteAdapter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    public static FavoriteFragment newInstance(String param1, String param2) {
        FavoriteFragment fragment = new FavoriteFragment();
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
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        init(view);

        favoriteAdapter = new FavoriteAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        favoriteAdapter.setData(getDataFavorite());

        recyclerView.setAdapter(favoriteAdapter);

        return view;
    }

    private void init(View view){
        recyclerView = view.findViewById(R.id.fragment_favorite_rv);
    }

    private List<Favorite> getDataFavorite(){
        List<Favorite> list = new ArrayList<>();

        list.add(new Favorite(R.drawable.img,"Tour 2N1D San may O Ta Xua - Song Lung Khung Long Khoi H ...","3.5","2,345,987"));
        list.add(new Favorite(R.drawable.img,"Tour 2N1D San may O Ta Xua - Song Lung Khung Long Khoi H ...","5.0","2,345,987"));
        list.add(new Favorite(R.drawable.img,"Tour 2N1D San may O Ta Xua - Song Lung Khung Long Khoi H ...","5.0","2,345,987"));
        list.add(new Favorite(R.drawable.img,"Tour 2N1D San may O Ta Xua - Song Lung Khung Long Khoi H ...","4.5","2,345,987"));
        list.add(new Favorite(R.drawable.img,"Tour 2N1D San may O Ta Xua - Song Lung Khung Long Khoi H ...","5.0","2,345,987"));
        list.add(new Favorite(R.drawable.img,"Tour 2N1D San may O Ta Xua - Song Lung Khung Long Khoi H ...","4.0","2,345,987"));
        list.add(new Favorite(R.drawable.img,"Tour 2N1D San may O Ta Xua - Song Lung Khung Long Khoi H ...","2.5","2,345,987"));
        list.add(new Favorite(R.drawable.img,"Tour 2N1D San may O Ta Xua - Song Lung Khung Long Khoi H ...","5.0","2,345,987"));
        list.add(new Favorite(R.drawable.img,"Tour 2N1D San may O Ta Xua - Song Lung Khung Long Khoi H ...","1.5","2,345,987"));
        list.add(new Favorite(R.drawable.img,"Tour 2N1D San may O Ta Xua - Song Lung Khung Long Khoi H ...","2.5","2,345,987"));
        list.add(new Favorite(R.drawable.img,"Tour 2N1D San may O Ta Xua - Song Lung Khung Long Khoi H ...","5.0","2,345,987"));
        return list;
    }
}