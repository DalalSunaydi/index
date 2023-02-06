package com.next.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.next.myapplication.MainActivity2;
import com.next.myapplication.MainActivity3;
import com.next.myapplication.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.ViewHolder> {

    private Context context;
    private List<String> departs;
    private boolean isTrue;


    public DepartmentAdapter(Context context,List<String> departs,boolean isTrue) {
        this.context = context;
        this.departs=departs;
        this.isTrue=isTrue;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.department_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



        holder.textViewName.setText(departs.get(position));

        holder.textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isTrue){
                    Log.i("aaaaaaaa", String.valueOf(holder.getAdapterPosition()));
                    Intent intent = new Intent(context.getApplicationContext(), MainActivity2.class);
                    intent.putExtra("deparment_id",String.valueOf(holder.getAdapterPosition()));
                    intent.putExtra("deparment_str",departs.get(holder.getAdapterPosition()));

                    context.startActivity(intent);
                }else {
                    Intent intent = new Intent(context.getApplicationContext(), MainActivity3.class);
                    intent.putExtra("deparment_str",departs.get(holder.getAdapterPosition()));
                    context.startActivity(intent);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return departs.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.dep_name);

        }
    }
}
