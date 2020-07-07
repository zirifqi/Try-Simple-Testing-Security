package id.go.rembangkab.ngetest.rest;


import id.go.rembangkab.ngetest.models.Resp_signature;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("index")
    Call<Resp_signature> postSignature(@Header("signature") String signature);

}
