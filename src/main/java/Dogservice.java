import data.RandomDogResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Dogservice {
  @GET("breeds/image/random")
  Observable<RandomDogResponse> getRandomDog();

}
