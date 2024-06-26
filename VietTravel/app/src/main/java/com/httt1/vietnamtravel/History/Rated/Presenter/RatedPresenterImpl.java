package com.httt1.vietnamtravel.History.Rated.Presenter;

import android.os.AsyncTask;

import com.httt1.vietnamtravel.History.Rated.Model.Rated;
import com.httt1.vietnamtravel.History.Rated.Model.RatedRepository;

import java.util.List;

public class RatedPresenterImpl implements RatedContract.Presenter {
    private RatedContract.View view;
    private RatedRepository repository;

    public RatedPresenterImpl(RatedContract.View view) {
        this.view = view;
        this.repository = new RatedRepository();
    }

    @Override
    public void loadRatedTours() {
        view.showLoading();
        new LoadRatedToursTask().execute();
    }

    private class LoadRatedToursTask extends AsyncTask<Void, Void, List<Rated>> {
        private Exception exception;

        @Override
        protected List<Rated> doInBackground(Void... voids) {
            try {
                return repository.getAllFeedback();
            } catch (Exception e) {
                exception = e;
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Rated> rateds) {
            view.hideLoading();
            if (exception != null) {
                view.showError(exception.getMessage());
            } else if (rateds == null || rateds.isEmpty()) {
                view.showError("Không có đánh giá nào.");
            } else {
                view.showRatedTours(rateds);
            }
        }
    }
}
