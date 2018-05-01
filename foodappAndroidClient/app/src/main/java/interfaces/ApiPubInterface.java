package interfaces;

import java.util.List;

import entities.Pub;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hajar on 25/04/2018.
 */

public interface ApiPubInterface {

    @GET("getPubs.php")
    Call<List<Pub>> getPubs();

}
