package com.moves.movesCelebrity.utils;

import com.moves.movesCelebrity.configuration.MovesConfiguration;

public class Constants {

    public static final String FACEBOOK_GRAPH_API_URL = "https://graph.facebook.com/v3.1/";
    public static final String FACEBOOK_GRAPH_VIDEO_API_URL = "https://graph-video.facebook.com/v3.1/";
    public static final String FACEBOOK_FETCH_ACCOUNTS_USER_PAGES = FACEBOOK_GRAPH_API_URL + "me/accounts/?access_token="+MovesConfiguration.FB_ACC_TOKEN;
    public static final String FACEBOOK_FETCH_ACCOUNTS_LIKED_PAGES = FACEBOOK_GRAPH_API_URL + "me/likes/?access_token="+MovesConfiguration.FB_ACC_TOKEN;
    public static final String FACEBOOK_FETCH_ACCOUNTS_USER_GROUPS = FACEBOOK_GRAPH_API_URL + "me/admined_groups/?access_token="+MovesConfiguration.FB_ACC_TOKEN;
    public static final String FACEBOOK_FETCH_ACCOUNTS_LIKED_GROUPS = FACEBOOK_GRAPH_API_URL + "me/groups/?access_token="+MovesConfiguration.FB_ACC_TOKEN;
    public static final String FACEBOOK_FETCH_ACCOUNTS_USER_POSTS = FACEBOOK_GRAPH_API_URL + "me/feed/?access_token="+MovesConfiguration.FB_ACC_TOKEN;
    public static final String FACEBOOK_FETCH_ACCOUNTS_USER_TIMELINE_POSTS = FACEBOOK_GRAPH_API_URL + "me/home/?access_token="+MovesConfiguration.FB_ACC_TOKEN;
    public static final String FACEBOOK_FETCH_USER_DETAILS = FACEBOOK_GRAPH_API_URL + "me/?access_token="+MovesConfiguration.FB_ACC_TOKEN;

    public static final String FB_PAGE_POSTS = FACEBOOK_GRAPH_API_URL +MovesConfiguration.FB_PAGE_ID+"/feed?access_token="+ MovesConfiguration.FB_PAGE_ACCESS_TOKEN_EXTENDED;
    public static final String FB_PAGE_POSTS_MEDIA = FACEBOOK_GRAPH_API_URL +MovesConfiguration.FB_PAGE_ID+"/photos?access_token="+ MovesConfiguration.FB_PAGE_ACCESS_TOKEN_EXTENDED;
    public static final String FB_PAGE_POSTS_VIDEO = FACEBOOK_GRAPH_VIDEO_API_URL +MovesConfiguration.FB_PAGE_ID+"/videos?access_token="+ MovesConfiguration.FB_PAGE_ACCESS_TOKEN_EXTENDED;

    public static final String FACEBOOK_ACCOUNT_INSIGHTS_URL = FACEBOOK_GRAPH_API_URL + "%1$s/insights";
    public static final String FACEBOOK_MEDIA_INSIGHTS_URL = FACEBOOK_GRAPH_API_URL + "%1$s/insights";
    public static final String FB_PAGE_AUTH_EXTENSION = FACEBOOK_GRAPH_API_URL+"/oauth/access_token? grant_type=fb_exchange_token& client_id=%1$s& client_secret=&%2$s fb_exchange_token=%3$s";//{app-id},{app-secret},{short-lived-token}



    public static final String FACEBOOK_FETCH_ACCOUNT_INSIGHTS = "https://graph.facebook.com/v3.1/%1$s/insights/?metric=page_fan_adds_unique,page_fan_adds&access_token="+MovesConfiguration.FB_PAGE_ACCESS_TOKEN_EXTENDED;
    public static final String FB_LIKED_PAGE_POST_UPLOAD = FACEBOOK_GRAPH_API_URL +MovesConfiguration.FB_LIKED_PAGE_ID+"/feed?access_token="+ MovesConfiguration.FB_LIKED_PAGE_ACCESS_TOKEN_EXTENDED;

}