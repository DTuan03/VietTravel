package com.httt.viettravel.Model;

import android.widget.TextView;

public class Term {
    String title, description;
    boolean isVisible;

    public Term(String title, String description, boolean isVisible) {
        this.title = title;
        this.description = description;
        this.isVisible = isVisible;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
