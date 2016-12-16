package com.neiliner.mymovie.ui.discover;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.neiliner.mymovie.bean.Movie;
import com.neiliner.mymovie.bean.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vam on 2016/12/12.
 */

public class SearchPresenter{

    SearchViewer viewer;
    Context context;

    public SearchPresenter(SearchViewer viewer, Context context){
        this.context = context;
        this.viewer = viewer;
    }

    public void search(String str){
        String url = null;
        try {
            url = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest("http://api.douban.com/v2/movie/search?q="+url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject json = new JSONObject(response);
                            JSONArray array = json.getJSONArray("subjects");
                            List<Movie> movieList = new ArrayList<Movie>();
                            Log.i("MyInfo", json.getString("title"));
                            for(int i = 0; i<array.length(); i++){
                                JSONObject movieObj = array.getJSONObject(i);

                                // id
                                String id = movieObj.getString("id");

                                // 链接
                                String alt = movieObj.getString("alt");

                                // 评分
                                JSONObject ratingObj = movieObj.getJSONObject("rating");
                                String ratingAverage = ratingObj.getString("average");

                                // 片名
                                String title = movieObj.getString("title");

                                // 年份
                                String year = movieObj.getString("year");

                                // 被收藏次数
                                String collectCount = movieObj.getString("collect_count");

                                // 演员
                                JSONArray castsArr = movieObj.getJSONArray("casts");
                                List<Person> castsList = new ArrayList<Person>();
                                for(int j = 0; j < castsArr.length(); j++){
                                    JSONObject castObj = castsArr.getJSONObject(j);
                                    String castId = castObj.getString("id");
                                    String name = castObj.getString("name");
                                    String castAlt = castObj.getString("alt");
                                    String avatarsSmall = null;
                                    String avatarsMedium = null;
                                    String avatarsLarge = null;

                                    if(!castObj.isNull("avatars")){
                                        JSONObject avatarsObj = castObj.getJSONObject("avatars");
                                        avatarsSmall = avatarsObj.getString("small");
                                        avatarsMedium = avatarsObj.getString("medium");
                                        avatarsLarge = avatarsObj.getString("large");
                                    }
                                    Person castPerson = new Person(castId, name, castAlt, avatarsSmall, avatarsMedium, avatarsLarge);
                                    castsList.add(castPerson);
                                }

                                // 导演
                                JSONArray directorsArr = movieObj.getJSONArray("directors");
                                List<Person> directorsList = new ArrayList<Person>();
                                for(int k = 0; k < directorsArr.length(); k++){
                                    JSONObject directorObj = directorsArr.getJSONObject(k);
                                    String directorId = directorObj.getString("id");
                                    String name = directorObj.getString("name");
                                    String directorAlt = directorObj.getString("alt");

                                    String avatarsSmall = null;
                                    String avatarsMedium = null;
                                    String avatarsLarge = null;

                                    if(!directorObj.isNull("avatars")){
                                        JSONObject avatarsObj = directorObj.getJSONObject("avatars");
                                        avatarsSmall = avatarsObj.getString("small");
                                        avatarsMedium = avatarsObj.getString("medium");
                                        avatarsLarge = avatarsObj.getString("large");
                                    }

                                    Person directorPerson = new Person(directorId, name, directorAlt, avatarsSmall, avatarsMedium, avatarsLarge);
                                    directorsList.add(directorPerson);
                                }

                                // 封面海报
                                JSONObject imagesObj = movieObj.getJSONObject("images");
                                String imagesSmall = imagesObj.getString("small");
                                String imagesMedium = imagesObj.getString("medium");
                                String imagesLarge = imagesObj.getString("large");

                                Movie movie = new Movie(id, alt, ratingAverage, title, year, collectCount, castsList, directorsList,
                                        imagesSmall, imagesMedium, imagesLarge);
                                movieList.add(movie);
                            }
                            viewer.setListAdapter(movieList);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("MyInfo", error.getMessage(), error);
            }
        });
        mQueue.add(stringRequest);
    }

}
