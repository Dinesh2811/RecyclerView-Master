package com.dinesh.recyclerview.java.listadapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;
import java.util.UUID;

public class RvModel {
    private String id;
    private String name;
    private String rating;

    public RvModel(String name, String rating) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RvModel JMovie = (RvModel) o;
        return id.equals(JMovie.id) &&
                name.equals(JMovie.name) &&
                rating.equals(JMovie.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rating);
    }

    public static DiffUtil.ItemCallback<RvModel> itemCallback = new DiffUtil.ItemCallback<RvModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull RvModel oldItem, @NonNull RvModel newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull RvModel oldItem, @NonNull RvModel newItem) {
            return oldItem.equals(newItem);
        }
    };
}