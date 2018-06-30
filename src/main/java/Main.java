import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Main {

  private static Dogservice dogservice;

  public static void main(String[] args) {
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(Level.BODY);
    OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor)
        .build();

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dog.ceo/api/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();

    dogservice = retrofit.create(Dogservice.class);
  }

}
