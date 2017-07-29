package posidenpalace.com.test6;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetroHelper {
 //full url
//  https://api.themoviedb.org/3/search/movie?api_key=b8f0c47ae5efc85b418f482cafeb6459&language=en-US&query=magical&page=1&include_adult=false
 public static final String BASE_URL ="https://api.themoviedb.org/";

 public static Retrofit create() {

  Retrofit retro = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
  return retro;
 }

 public static Call<Movies> InitialCall(){
  Retrofit retrofit = create();
  Services services = retrofit.create(Services.class);
  return services.tempCall("",1,false);
 }

 public static Call<Movies> SearchCall(String type, int page){
  Retrofit retrofit = create();
  Services services = retrofit.create(Services.class);
  return services.tempCall(type,page,false);
 }

 interface Services{
  @GET("3/search/movie?api_key=b8f0c47ae5efc85b418f482cafeb6459&language=en-US")
  Call<Movies> tempCall(@Query("query")String type, @Query("page") int page, @Query("include_adult") boolean adult);
 }
}
