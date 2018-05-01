package interfaces;

import java.util.List;

import entities.Livreur;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Hajar on 23/04/2018.
 */

public interface ApiLivreurInterface {
    @GET("login.php")
    Call<Livreur> login(@Query("login") String login, @Query("mdp") String mdp);

    @POST("registerLivreur.php")
    Call<Livreur> createLivreur(@Body Livreur livreur);

    @GET("getLivreurs.php")
    Call<List<Livreur>> getLivreurs();
}
