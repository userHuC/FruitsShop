package com.shop.pojo;

public class OrderFrom {
    private String fruitsName;
    private String price;
    private String lei;
    private String site;
    private String state;
    private String username;

    public OrderFrom(String fruitsName, String price, String lei, String site, String state, String username) {
        this.fruitsName = fruitsName;
        this.price = price;
        this.lei = lei;
        this.site = site;
        this.state = state;
        this.username = username;
    }

    public OrderFrom() {
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

    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "OrderFrom{" +
                "fruits_name='" + fruitsName + '\'' +
                ", price='" + price + '\'' +
                ", lei='" + lei + '\'' +
                ", site='" + site + '\'' +
                ", state='" + state + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
