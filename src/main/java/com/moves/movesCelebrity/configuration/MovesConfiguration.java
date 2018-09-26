package com.moves.movesCelebrity.configuration;

import io.dropwizard.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MovesConfiguration extends Configuration {

    public static final String COLLECTIONS_ACCOUNTS_USER_PAGES_LIST = "fb_user_pages";
    public static final String COLLECTIONS_ACCOUNTS_LIKED_PAGES_LIST = "fb_liked_pages";
    public static final String COLLECTIONS_ACCOUNTS_USER_GROUPS_LIST = "fb_user_groups";
    public static final String COLLECTIONS_ACCOUNTS_LIKED_GROUPS_LIST = "fb_liked_groups";
    public static final String COLLECTIONS_ACCOUNTS_USER_POSTS = "fb_user_posts";
    public static final String COLLECTIONS_ACCOUNTS_USER_FEED_POSTS = "fb_userFeed_posts";
    public static final String COLLECTIONS_ACCOUNTS_USER_POSTED_PAGE_POSTS = "fb_userPage_posts";
    public static final String COLLECTIONS_USER_DETAILS = "fb_user_basic_details";
    public static final String FB_ACC_TOKEN = "EAAOpRugcj9MBAOeWbuGiI1J2PWRGyR3D5XhmEWOOSMEGsH7BfUbwOFQ6IyNkLqq2IBwv1IUqZCgpzpRlUZBpjUp3ZAAg1Uim0RLTqxr22I21dgSWufi7sDGlfZAAlqxttrqZBDWIKnplBN0j0yYKj4ZC5AyBN95ucLwiWotFSXOAZDZD";
    public static final String FB_PAGE_ID = "145143946118972";
    public static final String FB_APP_SECRET = "362308f4c8c529c4dc6b1304b9f8172b";
    public static final String FB_APP_ID = "2092026187719318";
    public static final String FB_PAGE_ACCESS_TOKEN_EXTENDED = "EAAOpRugcj9MBAHJsdipaJpd3r5voMcwbZBwWEz22kZCZCA6nr1Sr8XFm3ykTXDlMRKgxe5dBHjXbZAdFUUirsyvm2gcwKElzbqzEz5YLIJ7f5RPGlFyg7ZCfYpfwNsahr7aZBR4TgmuCZBVqlasF6YPX4HGrZBFMkLb8Jo1cZCZAiocQZDZD";


    public static final String FB_LIKED_PAGE_ID = "";
    public static final String FB_LIKED_PAGE_ACCESS_TOKEN_EXTENDED = "";
    public static final String FB_LIKED_GROUP_ID = "";
    public static final String FB_LIKED_GROUP_ACCESS_TOKEN_EXTENDED = "";

     public static final String COLLECTION_FB_USER_DETAILS = "fbUserDetails";
     public static final String COLLECTION_FB_USER_POSTS = "fbUserPosts1";

    public static final String DB_NAME = "movesCelebrity";
    public static final Map<String, String> PLATFORM_MAP;

    static {
        HashMap<String, String> aMap = new HashMap<>();
        aMap.put("twitter", "dulquer");
        aMap.put("instagram", "408096151.9437cac.ab7a30150efe44fb81d5dc83ffa16543");
        aMap.put("twitter.trends", "Mumbai");
        aMap.put("instagram.trends", "lat=48.858844&lng=2.294351");
        PLATFORM_MAP = Collections.unmodifiableMap(aMap);
    }
}
