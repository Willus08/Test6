package posidenpalace.com.test6;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RetroHelper {
 public static final String BASE_URL ="";

 public static Retrofit create() {

  Retrofit retro = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
  return retro;
 }

 public static Call<TempPojo> tempPojoCall(){
  Retrofit retrofit = create();
  Services services = retrofit.create(Services.class);
  return services.tempCall();
 }


 interface Services{
  @GET("")
  Call<TempPojo> tempCall();
 }
}
