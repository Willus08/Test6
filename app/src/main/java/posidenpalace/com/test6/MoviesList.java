package posidenpalace.com.test6;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Android on 7/29/2017.
 */

public class MoviesList implements Parcelable {
    String title;
    double average;
    String posterPath;
    String overView;
    String date;
    int votes;
    String language;


    public MoviesList(String title, double average, String posterPath, String overView, String date, int votes, String language) {
        this.title = title;
        this.average = average;
        this.posterPath = posterPath;
        this.overView = overView;
        this.date = date;
        this.votes = votes;
        this.language = language;
    }

    protected MoviesList(Parcel in) {
        title = in.readString();
        average = in.readDouble();
        posterPath = in.readString();
        overView = in.readString();
        date = in.readString();
        votes = in.readInt();
        language = in.readString();
    }

    public static final Creator<MoviesList> CREATOR = new Creator<MoviesList>() {
        @Override
        public MoviesList createFromParcel(Parcel in) {
            return new MoviesList(in);
        }

        @Override
        public MoviesList[] newArray(int size) {
            return new MoviesList[size];
        }
    };

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeDouble(average);
        dest.writeString(posterPath);
        dest.writeString(overView);
        dest.writeString(date);
        dest.writeInt(votes);
        dest.writeString(language);
    }
}
