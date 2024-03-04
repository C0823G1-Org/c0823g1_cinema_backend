package com.example.c0823g1_movie_backend.dto;

public class FacebookDTO {
    private String id;
    private String name;
    private String email;
    private PictureData picture;

    public FacebookDTO(String id, String name, String email, PictureData picture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public FacebookDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PictureData getPicture() {
        return picture;
    }

    public void setPicture(PictureData picture) {
        this.picture = picture;
    }

    public static class PictureData {
        private PictureUrl data;

        public PictureUrl getData() {
            return data;
        }

        public void setData(PictureUrl data) {
            this.data = data;
        }
    }

    public static class PictureUrl {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
