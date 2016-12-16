package com.neiliner.mymovie.ui.discover;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.neiliner.mymovie.R;
import com.neiliner.mymovie.adapter.MovieListAdapter;
import com.neiliner.mymovie.bean.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by vam on 2016/11/18.
 */
public class SearchFragment extends Fragment implements SearchViewer<SearchPresenter>{

    @BindView(R.id.list)
    ListView list;
    @BindView(R.id.et_search)
    TextView searchEt;
    @BindView(R.id.btn_search)
    Button searchBtn;

    SearchPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter = new SearchPresenter(this, getActivity().getBaseContext());

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = searchEt.getText().toString();
                presenter.search(str);
            }
        });
    }

    public void setListAdapter(List<Movie> movieList){
        MovieListAdapter adapter = new MovieListAdapter(getActivity(), movieList);
        list.setAdapter(adapter);
    }
}
