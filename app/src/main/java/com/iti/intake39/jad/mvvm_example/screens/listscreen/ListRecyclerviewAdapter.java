package com.iti.intake39.jad.mvvm_example.screens.listscreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iti.intake39.jad.mvvm_example.R;
import com.iti.intake39.jad.mvvm_example.data.model.AnimatedCharacter;

import java.util.List;

public class ListRecyclerviewAdapter extends RecyclerView.Adapter<ListRecyclerviewAdapter.MainViewHolder> {

    private List<AnimatedCharacter> characters;
    private Context context;

    public ListRecyclerviewAdapter(List<AnimatedCharacter> characters, Context context) {
        this.characters = characters;
        this.context = context;
    }

    @NonNull
    @Override
    public ListRecyclerviewAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview_listactivity, viewGroup, false);
        MainViewHolder viewHolder = new MainViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder viewHolder, int i) {
        viewHolder.characterName.setText(characters.get(i).getName());
        RequestOptions defaultOption = new RequestOptions()
                .error(R.drawable.ic_broken_image_24dp)
                .placeholder(R.drawable.ic_launcher_foreground);
        Glide.with(context).setDefaultRequestOptions(defaultOption)
                .load(characters.get(i).getImageUrl())
                .into(viewHolder.characterImage);
    }

    @Override
    public int getItemCount() {
        return characters==null? 0 : characters.size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {
        TextView characterName;
        ImageView characterImage;

        public MainViewHolder(View view) {
            super(view);
            characterName = view.findViewById(R.id.characterName);
            characterImage = view.findViewById(R.id.characterImage);
        }
    }
}
