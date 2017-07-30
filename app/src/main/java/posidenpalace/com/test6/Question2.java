package posidenpalace.com.test6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class Question2 extends AppCompatActivity {
    private static final String TAG = "question 2" ;
    RecyclerView recy;
    RecycleAdapter adapt;
    RecyclerView.ItemAnimator animator;
    RecyclerView.LayoutManager layoutManager;
    List<MoviesList> movies = new ArrayList<>();
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

    public void setUpRecycler(List<MoviesList> results){
        adapt = new RecycleAdapter(results);
        recy.setAdapter(adapt);
        recy.setItemAnimator(animator);
        recy.setLayoutManager(layoutManager);
    }




    public void search(View view) {
        if(movies!= null){
            movies.clear();
        }
        retrofit2.Call<Movies> moviesCall = RetroHelper.SearchCall(search.getText().toString(),1);
        moviesCall.enqueue(new retrofit2.Callback<Movies>() {



            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                for (int i = 0; i < response.body().getResults().size(); i++) {

                    Log.d(TAG, "onResponse: " +
                                  "vote Average: " +  response.body().getResults().get(i).getVoteAverage()+
                            "title: "+response.body().getResults().get(i).getTitle()+
                            "Poster Path: "+response.body().getResults().get(i).getPosterPath()+
                            "Overview: "+response.body().getResults().get(i).getOverview()+
                            "Date: "+response.body().getResults().get(i).getReleaseDate()+
                            "votes"+response.body().getResults().get(i).getVoteCount());
                    MoviesList movie = new MoviesList(response.body().getResults().get(i).getTitle(),
                            response.body().getResults().get(i).getVoteAverage(),
                            response.body().getResults().get(i).getPosterPath(),
                            response.body().getResults().get(i).getOverview(),
                            response.body().getResults().get(i).getReleaseDate(),
                            response.body().getResults().get(i).getVoteCount(),
                            response.body().getResults().get(i).getOriginalLanguage());
                    Log.d(TAG, "onResponse: " + movie.getTitle());
                   movies.add(movie);

                }
                setUpRecycler(movies);


            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.toString());

            }
        });
    }
}
