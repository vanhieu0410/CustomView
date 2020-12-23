package hieu.vn.customview;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMainFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Metrics> metricsList = new ArrayList<>();

    MyCallback callback;

    private final MetricsAdapter.MetricsItemClick metricsItemClick = new MetricsAdapter.MetricsItemClick() {
        @Override
        public void onClick(Metrics metrics) {
            callback.callbackCall(metrics);
            Log.d("xxx","item click on recyclerview: " + metrics.getmTitle());
            ((MainActivity)getActivity()).changeTitle(metrics);
            if (getFragmentManager() != null) {
                ((HealthFragment)getFragmentManager().findFragmentByTag(HealthFragment.class.toString())).setImgAvatar(metrics);
                ((HealthFragment)getFragmentManager().findFragmentByTag(HealthFragment.class.toString())).setLblDetail(metrics);

            }
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        assert getArguments() != null;
        metricsList = getArguments().getParcelableArrayList("list");
        Log.d("xxx","item on recycler: " + metricsList.get(1).getmTitle());
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_matrics);

        bindDataRecyclerView(metricsList);
    }

    public void bindDataRecyclerView(List<Metrics> metricsList) {
        MetricsAdapter metricsAdapter = new MetricsAdapter(metricsList);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
            metricsAdapter.setMetricsItemClick(metricsItemClick);
            recyclerView.setAdapter(metricsAdapter);
    }


}
