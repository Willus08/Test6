package posidenpalace.com.test6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Details extends AppCompatActivity {
    TextView title;
    TextView votes;
    TextView date;
    TextView overView;
    ImageView picture;
    RatingBar ratings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();
        MoviesList movie = bundle.getParcelable("movie");
        title = (TextView) findViewById(R.id.tvDetaileTitle);
        votes = (TextView) findViewById(R.id.tvVotes);
        date = (TextView) findViewById(R.id.tvReleaseDate);
        overView = (TextView) findViewById(R.id.tvDetailOverview);
        picture = (ImageView) findViewById(R.id.ivDetailPicture);
        ratings = (RatingBar) findViewById(R.id.rbRaitings);

        title.setText("Title: "+movie.getTitle());
        votes.setText("Votes: "+movie.getVotes());
        overView.setText("Overview: "+movie.getOverView());
        date.setText("Date Released: " + movie.getDate());

        Glide.with(this).load(movie.getPosterPath()).into(picture);

        ratings.setProgress((int) movie.getAverage());
    }
}
