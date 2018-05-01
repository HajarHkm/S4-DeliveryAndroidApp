package interfaces;

import entities.Client;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Hajar on 23/04/2018.
 */

public interface ApiClientInterface {

    @GET("login.php")
    Call<Client> login(@Query("login") String login, @Query("mdp") String mdp);

    @POST("registerClient.php")
    Call<Client> createClient(@Body Client client);

}
