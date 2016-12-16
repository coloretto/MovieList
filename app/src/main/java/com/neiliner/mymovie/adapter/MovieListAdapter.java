package com.neiliner.mymovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.neiliner.mymovie.R;
import com.neiliner.mymovie.bean.Movie;

import java.util.List;

/**
 * Created by vam on 2016/11/21.
 */

public class MovieListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Movie> mMovies;
    private Context mContext;

    public MovieListAdapter(Context mContext, List<Movie> mMovies) {
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
        this.mMovies = mMovies;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listcell, null);
            holder = new ViewHolder();
            holder.mMovieIcon = (ImageView) convertView.findViewById(R.id.img);
            holder.mMovieTitle = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder)convertView.getTag();
        }

        final Movie movie = mMovies.get(position);

        Glide.with(mContext)
                .load(movie.getImagesSmall())
                .into(holder.mMovieIcon);
        holder.mMovieTitle.setText(movie.getTitle());

        return convertView;
    }

    final class ViewHolder{
        public ImageView mMovieIcon;
        public TextView mMovieTitle;
    }
}
