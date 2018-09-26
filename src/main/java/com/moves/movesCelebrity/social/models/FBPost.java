package com.moves.movesCelebrity.social.models;

public class FBPost {

    String postId;
    String postContent;
    Long likesCount;
    Long shareCount;
    Long commentsCount;

    public FBPost(String postId, String postContent, Long likesCount, Long shareCount, Long commentsCount) {
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

    public Long getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Long likesCount) {
        this.likesCount = likesCount;
    }

    public Long getShareCount() {
        return shareCount;
    }

    public void setShareCount(Long shareCount) {
        this.shareCount = shareCount;
    }

    public Long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Long commentsCount) {
        this.commentsCount = commentsCount;
    }
}
