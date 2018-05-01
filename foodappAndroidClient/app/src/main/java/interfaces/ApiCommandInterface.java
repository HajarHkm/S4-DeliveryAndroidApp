package interfaces;

import java.util.List;

import entities.Commande;
import entities.LigneCommande;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Hajar on 25/04/2018.
 */

public interface ApiCommandInterface {

    @GET("getNewCommands.php")
    Call<List<Commande>> getNewCommands();

    @GET("getLivreurCommands.php")
    Call<List<Commande>> getLivreurCommands(@Query("idlivreur") int idlivreur);

    @POST("addCommand.php")
    Call<Commande> addCommande(@Body Commande commande);

    @POST("addLigneCommand.php")
    Call<LigneCommande> addLigneCommande(@Body LigneCommande commande);

}
