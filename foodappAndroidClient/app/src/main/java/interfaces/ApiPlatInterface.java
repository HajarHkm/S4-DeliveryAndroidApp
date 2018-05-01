package interfaces;

import java.util.List;

import entities.Plat;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface ApiPlatInterface {

    @GET("getMenu.php")
    Call<List<Plat>> getMenu(@Query("restau") String restau);

}
