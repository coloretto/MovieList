package com.neiliner.mymovie.bean;

/**
 * Created by vam on 2016/11/21.
 * 作用：人物bean
 */
public class Person {
    private String id;
    private String name;
    private String alt;             // 链接
    private String avatarsSmall;    // 小头像
    private String avatarsMedium;   // 中头像
    private String avatarsLarge;    // 大头像

    public Person(String id, String name, String alt, String avatarsSmall, String avatarsMedium, String avatarsLarge) {
        this.id = id;
        this.name = name;
        this.alt = alt;
        this.avatarsSmall = avatarsSmall;
        this.avatarsMedium = avatarsMedium;
        this.avatarsLarge = avatarsLarge;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlt() {
        return alt;
    }

    public String getAvatarsSmall() {
        return avatarsSmall;
    }

    public String getAvatarsMedium() {
        return avatarsMedium;
    }

    public String getAvatarsLarge() {
        return avatarsLarge;
    }
}
