package net.beans;

import java.util.Date;

public class image {
    private int ImageID;
    private int UID;
    private String PATH;
    private String author;//单独请求
    private String title;
    private String topic;
    private String description;
    private int hot;
    private String country;//单独请求
    private String Country_RegionCodeISO;
    private String city;//单独请求
    private int CityCode;
    private String publishTime;

    public image(int ImageID,int UID,String PATH,
                 String title,String topic,String description,
                 int hot, String publishTime,String Country_RegionCodeISO,int CityCode){
        this.ImageID=ImageID;
        this.UID=UID;
        this.PATH=PATH;
        this.author=author;
        this.title=title;
        this.topic=topic;
        this.description=description;
        this.hot=hot;
        this.publishTime=publishTime;
        this.Country_RegionCodeISO=Country_RegionCodeISO;
        this.CityCode=CityCode;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }

    public String getCountry_RegionCodeISO() {
        return Country_RegionCodeISO;
    }

    public void setCountry_RegionCodeISO(String country_RegionCodeISO) {
        Country_RegionCodeISO = country_RegionCodeISO;
    }

    public int getCityCode() {
        return CityCode;
    }

    public void setCityCode(int cityCode) {
        CityCode = cityCode;
    }
}
