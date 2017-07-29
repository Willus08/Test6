package posidenpalace.com.test6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class Question2 extends AppCompatActivity {
    private static final String TAG = "question 2" ;
    RecyclerView recy;
    RecycleAdapter adapt;
    RecyclerView.ItemAnimator animator;
    RecyclerView.LayoutManager layoutManager;
    List<Result> results;
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        recy = (RecyclerView) findViewById(R.id.rvHolder);
        search = (EditText) findViewById(R.id.etSearchBar);
        animator = new DefaultItemAnimator();
        layoutManager = new LinearLayoutManager(this);

      //  makeInitialCall();
    }

    public void setUpRecycler(List<Result> results){
        adapt = new RecycleAdapter(results);
        recy.setAdapter(adapt);
        recy.setItemAnimator(animator);
        recy.setLayoutManager(layoutManager);
    }


    public  void makeInitialCall(){

        retrofit2.Call<Movies> moviesCall = RetroHelper.InitialCall();
        moviesCall.enqueue(new retrofit2.Callback<Movies>() {


            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                for (int i = 0; i < response.body().getResults().size(); i++) {
                    results.add(new Result(response.body().getResults().get(i)));

                }
                setUpRecycler(results);
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

            }
        });


    }

    public void search(View view) {
        if(results!= null){
            results.clear();
        }
        retrofit2.Call<Movies> moviesCall = RetroHelper.SearchCall(search.getText().toString(),1);
        moviesCall.enqueue(new retrofit2.Callback<Movies>() {


            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                for (int i = 0; i < response.body().getResults().size(); i++) {
                   // results.add(new Result(response.body().getResults().get(i)));
                    Log.d(TAG, "onResponse: " + response.body().getResults().get(i).getTitle());
                    results.add(new Result(
                            response.body().getResults().get(i).getVoteAverage(),
                            response.body().getResults().get(i).getTitle(),
                            response.body().getResults().get(i).getPopularity(),
                            response.body().getResults().get(i).getPosterPath(),
                            response.body().getResults().get(i).getOriginalLanguage(),
                            response.body().getResults().get(i).getOverview(),
                            response.body().getResults().get(i).getReleaseDate()));


                    Log.d(TAG, "onResponse: " + response.body().getResults().get(i));
                }
                setUpRecycler(results);

            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.toString());

            }
        });
    }
}
