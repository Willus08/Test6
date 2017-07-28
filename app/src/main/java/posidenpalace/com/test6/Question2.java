package posidenpalace.com.test6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class Question2 extends AppCompatActivity {
    RecyclerView recy;
    RecycleAdapter adapt;
    RecyclerView.ItemAnimator animator;
    RecyclerView.LayoutManager layoutManager;
    List<TempPojo> tempPojoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        recy = (RecyclerView) findViewById(R.id.rvHolder);
        animator = new DefaultItemAnimator();
        layoutManager = new LinearLayoutManager(this);


    }

    public void setUpRecycler(List<TempPojo> tempPojoList){
        adapt = new RecycleAdapter(tempPojoList);
        recy.setAdapter(adapt);
        recy.setItemAnimator(animator);
        recy.setLayoutManager(layoutManager);
    }


    public  void makeCall(){
        setUpRecycler(tempPojoList);

    }

    public void search(View view) {
    }
}
