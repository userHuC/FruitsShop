package com.shop.pojo;

public class Fruits {

    private String fruitsName;
    private String price;
    private String explain;
    private String site;
    private String fruitsClass;

    public Fruits() {
    }

    public Fruits(String fruitsName, String price, String explain, String site, String fruitsClass) {
        this.fruitsName = fruitsName;
        this.price = price;
        this.explain = explain;
        this.site = site;
        this.fruitsClass = fruitsClass;
    }

    public String getFruitsName() {
        return fruitsName;
    }

    public void setFruitsName(String fruitsName) {
        this.fruitsName = fruitsName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getFruitsClass() {
        return fruitsClass;
    }

    public void setFruitsClass(String fruitsClass) {
        this.fruitsClass = fruitsClass;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "fruits_name='" + fruitsName + '\'' +
                ", price='" + price + '\'' +
                ", explain='" + explain + '\'' +
                ", site='" + site + '\'' +
                ", fruits_class='" + fruitsClass + '\'' +
                '}';
    }
}
