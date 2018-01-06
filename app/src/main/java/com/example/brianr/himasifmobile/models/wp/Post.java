package com.example.brianr.himasifmobile.models.wp;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Post {

    @SerializedName("date")
    private String date;

    @SerializedName("template")
    private String template;

    @SerializedName("_links")
    private Links links;

    @SerializedName("link")
    private String link;

    @SerializedName("type")
    private String type;

    @SerializedName("title")
    private Title title;

    @SerializedName("content")
    private Content content;

    @SerializedName("featured_media")
    private int featuredMedia;

    @SerializedName("_embedded")
    private Embedded embedded;

    @SerializedName("modified")
    private String modified;

    @SerializedName("id")
    private int id;

    @SerializedName("categories")
    private List<Integer> categories;

    @SerializedName("date_gmt")
    private String dateGmt;

    @SerializedName("slug")
    private String slug;

    @SerializedName("modified_gmt")
    private String modifiedGmt;

    @SerializedName("author")
    private int author;

    @SerializedName("format")
    private String format;

    @SerializedName("comment_status")
    private String commentStatus;

    @SerializedName("tags")
    private List<Object> tags;

    @SerializedName("ping_status")
    private String pingStatus;

    @SerializedName("meta")
    private List<Object> meta;

    @SerializedName("sticky")
    private boolean sticky;

    @SerializedName("guid")
    private Guid guid;

    @SerializedName("excerpt")
    private Excerpt excerpt;

    @SerializedName("status")
    private String status;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public int getFeaturedMedia() {
        return featuredMedia;
    }

    public void setFeaturedMedia(int featuredMedia) {
        this.featuredMedia = featuredMedia;
    }

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public String getDateGmt() {
        return dateGmt;
    }

    public void setDateGmt(String dateGmt) {
        this.dateGmt = dateGmt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getModifiedGmt() {
        return modifiedGmt;
    }

    public void setModifiedGmt(String modifiedGmt) {
        this.modifiedGmt = modifiedGmt;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String getPingStatus() {
        return pingStatus;
    }

    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    public List<Object> getMeta() {
        return meta;
    }

    public void setMeta(List<Object> meta) {
        this.meta = meta;
    }

    public boolean isSticky() {
        return sticky;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    public Excerpt getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(Excerpt excerpt) {
        this.excerpt = excerpt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "Post{" +
                        "date = '" + date + '\'' +
                        ",template = '" + template + '\'' +
                        ",_links = '" + links + '\'' +
                        ",link = '" + link + '\'' +
                        ",type = '" + type + '\'' +
                        ",title = '" + title + '\'' +
                        ",content = '" + content + '\'' +
                        ",featured_media = '" + featuredMedia + '\'' +
                        ",_embedded = '" + embedded + '\'' +
                        ",modified = '" + modified + '\'' +
                        ",id = '" + id + '\'' +
                        ",categories = '" + categories + '\'' +
                        ",date_gmt = '" + dateGmt + '\'' +
                        ",slug = '" + slug + '\'' +
                        ",modified_gmt = '" + modifiedGmt + '\'' +
                        ",author = '" + author + '\'' +
                        ",format = '" + format + '\'' +
                        ",comment_status = '" + commentStatus + '\'' +
                        ",tags = '" + tags + '\'' +
                        ",ping_status = '" + pingStatus + '\'' +
                        ",meta = '" + meta + '\'' +
                        ",sticky = '" + sticky + '\'' +
                        ",guid = '" + guid + '\'' +
                        ",excerpt = '" + excerpt + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}