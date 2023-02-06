package com.next.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.next.myapplication.MainActivity3;
import com.next.myapplication.R;
import com.next.myapplication.model.VideoModel;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.ViewHolder> {

    private Context ctx;
    private List<VideoModel> videoModels;
    private Uri uri;


    public ViewPager2Adapter(Context ctx, List<VideoModel> videoModels) {
        this.ctx = ctx;
        this.videoModels = videoModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.department_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final VideoModel videoModel=videoModels.get(position);

        holder.textVideoTitle.setText(videoModel.getTitle());

        holder.textVideoTitle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (videoModel.getUrl().length()!=0){
                    Intent intent = new Intent(ctx.getApplicationContext(), MainActivity3.class);
                    intent.putExtra("deparment_str",videoModel.getUrl());
                    ctx.startActivity(intent);
                }

            }
        });


//        uri = Uri.parse(videoModel.getUrl());
//        holder.videoView.setVideoURI(uri);
//        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                    mediaPlayer.start();
//
//
//            }
//        });
//
//        holder.videoView.setMediaController(new android.widget.MediaController(ctx));





    }

    @Override
    public int getItemCount() {
        return videoModels.size();
    }

    // The ViewHolder class holds the view
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textVideoTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textVideoTitle=itemView.findViewById(R.id.dep_name);
        }
    }
}
