package com.neiliner.mymovie.ui.discover;

import com.neiliner.mymovie.bean.Movie;
import com.neiliner.mymovie.base.BaseView;

import java.util.List;

/**
 * Created by vam on 2016/12/12.
 */

public interface SearchViewer<T>{

    void setListAdapter( List<Movie> movieList);
}
