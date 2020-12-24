package hieu.vn.customview;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class HealthFragment extends Fragment {
    private ImageView imgAvatar;
    private TextView lblDetail;

    private List<Metrics> listData;
    RecyclerViewMainFragment recyclerViewMainFragment;
    MyCallback myCallback;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myCallback = ((MyCallback) context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_health, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

       listData = myCallback.getListData();
        Log.d("xxx"," " + listData.get(1).getmTitle());
    }

    private void initView(View view) {
        imgAvatar = view.findViewById(R.id.img_avatar);
        lblDetail = view.findViewById(R.id.lbl_healthScore);
    }

    public void setImgAvatar(Metrics metrics) {
        imgAvatar.setImageResource(metrics.getmImage());
    }

    public void setLblDetail(Metrics metrics) {
        lblDetail.setText(metrics.getmTitle());
    }


}