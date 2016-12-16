package com.neiliner.mymovie.bean;

import java.util.List;

/**
 * Created by vam on 2016/11/21.
 * 作用：电影bean
 */

public class Movie {
    private String id;
    private String alt;                 // 豆瓣链接
    private String ratingAverage;       // 平均分
    private String title;               // 片名
    private String year;                // 年份
    private String collectCount;        // 被收藏次数
    private List<Person> castsList;     // 演员列表
    private List<Person> directorsList; // 导演列表
    private String imagesSmall;         // 封面海报小图
    private String imagesMedium;        // 封面海报中图
    private String imagesLarge;         // 封面海报大图

    public Movie(String id, String alt, String ratingAverage, String title, String year, String collectCount,
                 List<Person> castsList, List<Person> directorsList,
                 String imagesSmall, String imagesMedium, String imagesLarge) {
        this.id = id;
        this.alt = alt;
        this.ratingAverage = ratingAverage;
        this.title = title;
        this.year = year;
        this.collectCount = collectCount;
        this.castsList = castsList;
        this.directorsList = directorsList;
        this.imagesSmall = imagesSmall;
        this.imagesMedium = imagesMedium;
        this.imagesLarge = imagesLarge;
    }

    public String getId() {
        return id;
    }

    public String getAlt() {
        return alt;
    }

    public String getRatingAverage() {
        return ratingAverage;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getCollectCount() {
        return collectCount;
    }

    public List<Person> getCastsList() {
        return castsList;
    }

    public List<Person> getDirectorsList() {
        return directorsList;
    }

    public String getImagesSmall() {
        return imagesSmall;
    }

    public String getImagesMedium() {
        return imagesMedium;
    }

    public String getImagesLarge() {
        return imagesLarge;
    }
}
