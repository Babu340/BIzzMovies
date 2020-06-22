package com.example.bizzmovies.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.bizzmovies.Adapter.MoviesAdapter;
import com.example.bizzmovies.Apis.APIClient;
import com.example.bizzmovies.Apis.APIInterface;
import com.example.bizzmovies.Dto.MovieDTO;
import com.example.bizzmovies.R;
import com.example.bizzmovies.Util.Utilities;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {


    private LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerViewlist;
    private List<MovieDTO.Datup> dataas;
    MoviesAdapter moviesAdapter;
    private Utilities utilities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        //activityMainBinding = DataBindingUtil.setContentView(this, R.layout.list_activity);
        recyclerViewlist=(RecyclerView)findViewById(R.id.rv_deliveries);
        utilities = Utilities.getInstance(this);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewlist.setLayoutManager(linearLayoutManager);
        setValues();

    }
    public void setValues() {
        if (!utilities.isNetworkAvailable()) {
            utilities.dialogOK(this, "", this.getResources().getString(R.string.network_error), this.getString(R.string.ok), false);
        }   else {
            final ProgressDialog mProgressDialog;
            mProgressDialog = ProgressDialog.show(this, null, null);
            mProgressDialog.setContentView(R.layout.progress_loader);
            mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mProgressDialog.setCancelable(false);

            Map<String, String> map = new HashMap<>();

            APIInterface apiInterface = APIClient.getClient();

            Call<MovieDTO> call = apiInterface.getMovieDetails();

            call.enqueue(new Callback<MovieDTO>() {
                @Override
                public void onResponse(Call<MovieDTO> call, Response<MovieDTO> response) {
                    if (mProgressDialog != null && mProgressDialog.isShowing())
                        mProgressDialog.dismiss();
                    boolean bbb=response.isSuccessful();
                    if (response.isSuccessful()) {
                        System.out.println(" gsfjhshfjgjs--->----> " + new Gson().toJson(response.body()));
                        dataas = response.body().getData();
                        System.out.println("new_Gson_Data" + new Gson().toJson(response.body().getData()));
                        moviesAdapter = new MoviesAdapter(getApplicationContext(), dataas);
                        recyclerViewlist.setAdapter(moviesAdapter);
                    }
                }

                @Override
                public void onFailure(Call<MovieDTO> call, Throwable t) {
               //     utilities.dialogOK(context, "", context.getResources().getString(R.string.server_error), context.getResources().getString(R.string.ok), false);
                    Log.e(TAG, t.toString());
                    System.out.println("sdfffff---->" + t.toString());
                }
            });

        }
    }


}
