package com.example.bizzmovies.Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDTO {
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("total_results")
    @Expose
    private String totalresults;
    @SerializedName("total_pages")
    @Expose
    private String totalpages;

    @SerializedName("results")
    @Expose
    private List<Datup> data = null;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(String totalresults) {
        this.totalresults = totalresults;
    }

    public String getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(String totalpages) {
        this.totalpages = totalpages;
    }

    public List<Datup> getData() {
        return data;
    }

    public void setData(List<Datup> data) {
        this.data = data;
    }

    public class Datup {


        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("vote_average")
        @Expose
        private String vote_average;
        @SerializedName("overview")
        @Expose
        private String overview;
        @SerializedName("release_date")
        @Expose
        private String release_date;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVote_average() {
            return vote_average;
        }

        public void setVote_average(String vote_average) {
            this.vote_average = vote_average;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }
    }

}
