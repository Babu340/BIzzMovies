package com.example.bizzmovies.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.example.bizzmovies.Dto.MovieDTO;
import com.example.bizzmovies.R;
import com.example.bizzmovies.Util.AppConstants;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> implements AppConstants {

    private RequestOptions requestOptions;
    List<MovieDTO.Datup> datadriver;
    private Context context;
    private ArrayList<MovieDTO.Datup> deliveryDTOArrayList;
    private String buttonname;

    public MoviesAdapter(Context context, List<MovieDTO.Datup> datadriver){
        this.datadriver=datadriver;
        this.context = context;
        this.buttonname=buttonname;
        requestOptions = new RequestOptions();
        requestOptions.centerCrop();
        requestOptions.override(150, 150);
        requestOptions.placeholder(R.drawable.user_praba);
        requestOptions.error(R.drawable.user_praba);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.mvname.setText(datadriver.get(position).getTitle());//account name
        viewHolder.mvdate.setText(datadriver.get(position).getRelease_date());//account number
        viewHolder.mvdesc.setText(datadriver.get(position).getOverview());//shit code
       viewHolder.mvrating.setText(datadriver.get(position).getVote_average());//routing number

    }

    @Override
    public int getItemCount() {
        return datadriver.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mvname,mvdesc,mvdate,mvrating;

        //   private ImageView ivedit;
        public ViewHolder( View itemView) {
            super(itemView);

            mvname=(TextView)itemView.findViewById(R.id.mv_name);
            mvdate=(TextView)itemView.findViewById(R.id.mv_date);
            mvdesc   =(TextView)itemView.findViewById(R.id.mv_desc);
            mvrating=(TextView)itemView.findViewById(R.id.mv_rating);

    }
}

}
