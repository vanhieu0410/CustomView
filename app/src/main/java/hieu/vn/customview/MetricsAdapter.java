package hieu.vn.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MetricsAdapter extends RecyclerView.Adapter<MetricsAdapter.MyViewHolder> {

    private final Context mContext;
    private final List<Metrics> mData;

    public MetricsAdapter(Context mContext, List<Metrics> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MetricsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.layout_item_metrics,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MetricsAdapter.MyViewHolder holder, int position) {
        holder.lblTitleCard.setText(mData.get(position).getmTitle());
        holder.lblDescriptionCard.setText(mData.get(position).getmDescription());
        holder.lblLastUpdateCard.setText(mData.get(position).getmLastUpdate());
        holder.imgCard.setImageResource(mData.get(position).getmImage());
        holder.lblNumber.setText(mData.get(position).getmNumber());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView lblTitleCard,lblNumber, lblDescriptionCard,lblLastUpdateCard;
        ImageView imgCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            lblTitleCard = itemView.findViewById(R.id.lbl_title_card);
            lblDescriptionCard = itemView.findViewById(R.id.lbl_description_card);
            lblLastUpdateCard = itemView.findViewById(R.id.lbl_last_update_card);
            imgCard = itemView.findViewById(R.id.img_card);
            lblNumber = itemView.findViewById(R.id.lbl_num_description_card);
        }
    }

}





