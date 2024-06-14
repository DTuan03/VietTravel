package com.httt.viettravel.DistanceItem;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final int space;

    public SpaceItemDecoration(Context context, int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//        outRect.left = space;
        outRect.right = space;

        // Add top margin only for the first item to avoid double space between items
//        if (parent.getChildAdapterPosition(view) == 0) {
//            outRect.top = space;
//        } else {
//            outRect.top = 0;
//        }

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = 0;
        } else {
            outRect.left = space;
        }
    }
}
