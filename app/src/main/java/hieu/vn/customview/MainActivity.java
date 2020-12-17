package hieu.vn.customview;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    List<Metrics> metricsList = new ArrayList<>();
    RecyclerView recyclerView;
    ImageView imgProfile,imgShopping,imgHeart,imgGame,imgChat;
    Animation animScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //remove notification bar
       // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        metricsList.add(new Metrics("HEART RATE","78" ,"beats/s", "last update 15h", R.drawable.heart2));
        metricsList.add(new Metrics("STEPS", "9,890","", "last update 3m", R.drawable.steps));
        metricsList.add(new Metrics("WATER", "750", "ml", "last update 20m", R.drawable.glass));
        metricsList.add(new Metrics("SUGGEST MEAL", "345", "cal", "last update 55m", R.drawable.weight));

        initView();
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        MetricsAdapter metricsAdapter = new MetricsAdapter(this,metricsList);
        recyclerView.setAdapter(metricsAdapter);


        imgProfile.setOnClickListener(this);
        imgShopping.setOnClickListener(this);
        imgHeart.setOnClickListener(this);
        imgGame.setOnClickListener(this);
        imgChat.setOnClickListener(this);

    }

    private void initView() {
        recyclerView =  findViewById(R.id.recyclerview_matrics);
        imgProfile =  findViewById(R.id.img_profile);
        imgShopping = findViewById(R.id.img_shopping);
        imgHeart = findViewById(R.id.img_heart);
        imgGame = findViewById(R.id.img_game);
        imgChat = findViewById(R.id.img_chat);
    }

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
        img.setColorFilter(ContextCompat.getColor(getBaseContext(),R.color.red));
    }

    private void unSelected(ImageView img) {
        img.setColorFilter(ContextCompat.getColor(getBaseContext(),R.color.black));
    }

}