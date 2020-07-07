package id.go.rembangkab.ngetest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.security.MessageDigest;

import id.go.rembangkab.ngetest.models.Resp_signature;
import id.go.rembangkab.ngetest.rest.ApiClient;
import id.go.rembangkab.ngetest.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static String valueSignature;
    ApiInterface apiService;
    public static Resp_signature sign;

    private static final int VALID = 0;

    private static final int INVALID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSubmit = (Button) findViewById(R.id.buttonTest);
        TextView textSignature = (TextView) findViewById(R.id.textSignature);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                postData();
            }
        });

        checkAppSignature(this);

        textSignature.setText(valueSignature);

    }

    //Testing

//    private void postData() {
//        apiService = ApiClient.getClient().create(ApiInterface.class);
//        Call<Resp_signature> call = apiService.postSignature();
//        call.enqueue(new Callback<Resp_signature>() {
//            @Override
//            public void onResponse(Call<Resp_signature> call, Response<Resp_signature> response) {
//                if (response != null && response.isSuccessful()) {
//
//
//                } else {
//                    Toast.makeText(getApplicationContext(), "Data does not exist", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<Resp_signature> call, Throwable t) {
//                Log.e("-- Gagal Load Data : ", t.toString());
//            }
//        });
//    }

    public static int checkAppSignature(Context context) {

        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);

            for (Signature signature : packageInfo.signatures) {

                byte[] signatureBytes = signature.toByteArray();

                MessageDigest md = MessageDigest.getInstance("SHA");

                md.update(signature.toByteArray());

                final String currentSignature = Base64.encodeToString(md.digest(), Base64.DEFAULT);

                Log.d("REMOVE ME", "Include this string as a value for SIGNATURE:" + currentSignature);
                valueSignature = currentSignature;

//                bal bla
                //compare signatures

//                if (SIGNATURE.equals(currentSignature)){
//
//                    return VALID;
//
//                };
            }

        } catch (Exception e) {
//          assumes an issue in checking signature., but we let the caller decide on what to do.
        }
        return INVALID;

    }
}
