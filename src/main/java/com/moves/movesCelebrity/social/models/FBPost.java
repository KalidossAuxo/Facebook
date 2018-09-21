package com.moves.movesCelebrity.social.models;

public class FBPost {

    String postId;
    String postContent;
    Integer likesCount;
    Integer shareCount;
    Integer commentsCount;

    public FBPost(String postId, String postContent, Integer likesCount, Integer shareCount, Integer commentsCount) {
        this.postId = postId;
        this.postContent = postContent;
        this.likesCount = likesCount;
        this.shareCount = shareCount;
        this.commentsCount = commentsCount;
    }

    public FBPost() {
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }
}
