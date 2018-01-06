package com.example.brianr.himasifmobile.models.wp;

import com.google.gson.annotations.SerializedName;


public class AboutItem {

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return
                "AboutItem{" +
                        "href = '" + href + '\'' +
                        "}";
    }
}