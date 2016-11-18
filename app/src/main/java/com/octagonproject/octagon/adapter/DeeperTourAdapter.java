package com.octagonproject.octagon.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.octagonproject.octagon.R;
import com.octagonproject.octagon.utils.PicassoTrustAll;
import com.octagonproject.octagon.vo.DeeperTourVO;

import java.util.ArrayList;

/**
 * Created by Vikesh on 11/9/2016.
 */

public class DeeperTourAdapter extends RecyclerView.Adapter<DeeperTourAdapter.ViewHolder> {

    Context context;
    ArrayList<DeeperTourVO> list;

    public DeeperTourAdapter(Context context, ArrayList<DeeperTourVO> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem_deeper_tour, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getTitle());
        Log.v("OCTAGON", list.get(position).getImage());

        PicassoTrustAll.getInstance(context)
                .load(list.get(position).getImage())
                .placeholder(R.drawable.img_home_header)
                .into(holder.image);
        final DeeperTourVO deeperTourVO = list.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.layout_deeper_tour_popup);
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView detail = (TextView) dialog.findViewById(R.id.txt_detail);
                TextView title = (TextView) dialog.findViewById(R.id.txt_title);
                title.setText(deeperTourVO.getTitle());
                detail.setText(deeperTourVO.getDescription());
                ImageView image = (ImageView) dialog.findViewById(R.id.img_tour);
                image.setImageDrawable(holder.image.getDrawable());

                dialog.show();

                ImageView closeButton = (ImageView) dialog.findViewById(R.id.img_close);

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.txt_title);
            image = (ImageView) itemView.findViewById(R.id.img_tour);
        }
    }
}
