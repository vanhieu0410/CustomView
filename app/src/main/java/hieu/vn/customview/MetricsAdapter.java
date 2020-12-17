package hieu.vn.customview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class MetricsAdapter extends RecyclerView.Adapter<MetricsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Metrics> mListMetrics;
    MetricsItemClick metricsItemClick;

    public MetricsAdapter(Context mContext, List<Metrics> mListMetrics) {
        this.mContext = mContext;
        this.mListMetrics = mListMetrics;
    }

    @NonNull
    @Override
    public MetricsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.layout_item_metrics, parent, false);
        return new MyViewHolder(view, metricsItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull MetricsAdapter.MyViewHolder holder, int position) {

        holder.bindDataMetrics(mListMetrics.get(position));

    }

    @Override
    public int getItemCount() {
        return mListMetrics.size();
    }


    public void setMetricsItemClick(MetricsItemClick metricsItemClick) {
        this.metricsItemClick = metricsItemClick;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView lblTitleCard;
        private TextView lblNumber;
        private TextView lblDescriptionCard;
        private TextView lblLastUpdateCard;
        private ImageView imgCard;
        private Metrics metrics;


        public MyViewHolder(@NonNull View itemView, final MetricsItemClick metricsItemClick) {
            super(itemView);

            lblTitleCard = itemView.findViewById(R.id.lbl_title_card);
            lblDescriptionCard = itemView.findViewById(R.id.lbl_description_card);
            lblLastUpdateCard = itemView.findViewById(R.id.lbl_last_update_card);
            imgCard = itemView.findViewById(R.id.img_card);
            lblNumber = itemView.findViewById(R.id.lbl_num_description_card);

            itemView.setOnClickListener(v -> {
                metricsItemClick.onClick(metrics);
                Log.d("xxx","metric in adapter " + metrics.getmTitle());
            });
        }

        public void bindDataMetrics(Metrics metrics) {
            this.metrics = metrics;
            lblTitleCard.setText(metrics.getmTitle());
            lblNumber.setText(metrics.getmNumber());
            lblDescriptionCard.setText(metrics.getmDescription());
            lblLastUpdateCard.setText(metrics.getmLastUpdate());
            imgCard.setImageResource(metrics.getmImage());
        }
    }

    public interface MetricsItemClick {
        void onClick(Metrics metrics);
    }

}





