package com.khr.technicaltest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.khr.technicaltest.PayHistory;
import com.khr.technicaltest.R;

public class PayAdapter extends RecyclerView.Adapter<PayAdapter.pay_Holder> {
    //CardAdapter Class
    private Context context;
    private ArrayList<PayHistory> historys;

    public PayAdapter(Context context, ArrayList<PayHistory> historys) {
        this.context = context;
        this.historys = historys;
    }

    @NonNull
    @Override
    public pay_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new pay_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull pay_Holder holder, int position) {
        PayHistory pay = historys.get(position);
        holder.setDetail(pay);

        holder.cardView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition_animation));

    }
    @Override
    public int getItemCount() {
        return historys.size();
    }

    public class pay_Holder extends RecyclerView.ViewHolder{
        private TextView txtpayDate;
        CardView cardView;


        public pay_Holder(@NonNull View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.card_contain);
            txtpayDate = itemView.findViewById(R.id.text_date);

        }

        void setDetail(PayHistory history){
            txtpayDate.setText(history.getPayDate());
        }


    }
}
