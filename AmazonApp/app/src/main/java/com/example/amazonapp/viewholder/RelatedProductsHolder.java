package com.example.amazonapp.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amazonapp.Interfaces.ItemClickListener;
import com.example.amazonapp.R;

public class RelatedProductsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView relatedProdName, relatedProdPrice;
    private ItemClickListener itemClickListener;
    public ImageView relatedProdImg;

    public RelatedProductsHolder(@NonNull View itemView) {
        super(itemView);

        relatedProdName=itemView.findViewById(R.id.relatedProdName);
        relatedProdPrice=itemView.findViewById(R.id.relatedProdPrice);
        relatedProdImg=itemView.findViewById(R.id.relatedProdImg);
    }
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
