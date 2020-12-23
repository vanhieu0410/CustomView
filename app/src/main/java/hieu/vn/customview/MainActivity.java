package hieu.vn.customview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final List<Metrics> metricsList = new ArrayList<>();
    private ImageView imgProfile,imgShopping,imgHeart,imgGame,imgChat;
    private Animation animScale;
    private TextView lblName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        initView();
        metricsList.add(new Metrics("HEART RATE","78" ,"beats/s", "last update 15h", R.drawable.heart2));
        metricsList.add(new Metrics("STEPS", "9,890","", "last update 3m", R.drawable.steps));
        metricsList.add(new Metrics("WATER", "750", "ml", "last update 20m", R.drawable.glass));
        metricsList.add(new Metrics("SUGGEST MEAL", "345", "cal", "last update 55m", R.drawable.weight));

        //add fragment recyclerview
        Fragment recyclerFragment = new RecyclerViewMainFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_recycler_container, recyclerFragment,RecyclerViewMainFragment.class.toString())
                .addToBackStack(null)
                .commit();

        //send list<Metric> to recyclerFragment
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) metricsList);
        recyclerFragment.setArguments(bundle);

        //add fragment health
        Fragment healthFragment = new HealthFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.layout_health, healthFragment, HealthFragment.class.toString())
                .addToBackStack(null)
                .commit();



        imgProfile.setOnClickListener(this);
        imgShopping.setOnClickListener(this);
        imgHeart.setOnClickListener(this);
        imgGame.setOnClickListener(this);
        imgChat.setOnClickListener(this);

        animScale = AnimationUtils.loadAnimation(this,R.anim.scale);
    }

    private void initView() {
        imgProfile =  findViewById(R.id.img_profile);
        imgShopping = findViewById(R.id.img_shopping);
        imgHeart = findViewById(R.id.img_heart);
        imgGame = findViewById(R.id.img_game);
        imgChat = findViewById(R.id.img_chat);
        lblName = findViewById(R.id.lbl_name);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_profile:
                setSelected(imgProfile);
                unSelected(imgShopping);
                unSelected(imgHeart);
                unSelected(imgGame);
                unSelected(imgChat);
                break;
            case R.id.img_shopping:
                setSelected(imgShopping);
                unSelected(imgProfile);
                unSelected(imgHeart);
                unSelected(imgGame);
                unSelected(imgChat);
                break;
            case R.id.img_heart:
                setSelected(imgHeart);
                unSelected(imgShopping);
                unSelected(imgProfile);
                unSelected(imgGame);
                unSelected(imgChat);
                break;
            case  R.id.img_game:
                setSelected(imgGame);
                unSelected(imgShopping);
                unSelected(imgHeart);
                unSelected(imgProfile);
                unSelected(imgChat);
                break;
            case  R.id.img_chat:
                setSelected(imgChat);
                unSelected(imgShopping);
                unSelected(imgHeart);
                unSelected(imgGame);
                unSelected(imgProfile);
                break;
        }
    }

    private void setSelected(ImageView img) {
        img.setColorFilter(ContextCompat.getColor(getBaseContext(),R.color.red_primary));
        img.startAnimation(animScale);
    }

    private void unSelected(ImageView img) {
        img.setColorFilter(ContextCompat.getColor(getBaseContext(),R.color.black));
    }

    public void changeTitle(Metrics metrics) {
        lblName.setText(metrics.getmTitle());
    }

}