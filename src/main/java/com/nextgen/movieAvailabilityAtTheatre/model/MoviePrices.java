package com.nextgen.movieAvailabilityAtTheatre.model;

public class MoviePrices {
    private String price;
    private String desc;
    private String availabilityClass;
    private String availabilityText;


    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
    }


    public String getDesc() {
        return desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getAvailabilityClass() {
        return availabilityClass;
    }


    public void setAvailabilityClass(String availabilityClass) {
        this.availabilityClass = availabilityClass;
    }


    public String getAvailabilityText() {
        return availabilityText;
    }


    public void setAvailabilityText(String availabilityText) {
        this.availabilityText = availabilityText;
    }

    @Override
    public String toString() {
        return "MoviePrices{" +
                "price='" + price + '\'' +
                ", desc='" + desc + '\'' +
                ", availabilityClass='" + availabilityClass + '\'' +
                ", availabilityText='" + availabilityText + '\'' +
                '}';
    }
}
