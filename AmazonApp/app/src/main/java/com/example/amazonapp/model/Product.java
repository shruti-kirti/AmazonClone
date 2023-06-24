package com.example.amazonapp.model;

import java.math.BigDecimal;

public class Product {
    private int pId;
    private String pName;
    private BigDecimal pPrice;
    private String pDescription;
    private String pImageName;

    public Product() {
        super();
    }
    public Product(int pId, String pName, BigDecimal pPrice, String pDescription, String pImageName) {
        setpId(pId);
        setpName(pName);
        setpPrice(pPrice);
        setpDescription(pDescription);
        setpImageName(pImageName);
    }



//    @Override
//    public boolean equals(Object o) {
//        if (o == null) return false;
//        if (!(o instanceof Product)) return false;
//
//        return (this.pId == ((Product) o).getId());
//    }

//    public int hashCode() {
//        final int prime = 31;
//        int hash = 1;
//        hash = hash * prime + pId;
//        hash = hash * prime + (pName == null ? 0 : pName.hashCode());
//        hash = hash * prime + (pPrice == null ? 0 : pPrice.hashCode());
//        hash = hash * prime + (pDescription == null ? 0 : pDescription.hashCode());
//
//        return hash;
//    }


    public int getpId() {
        return pId;
    }

    public void setpId(int id) {
        this.pId = id;
    }

    public BigDecimal getpPrice() {
        return pPrice;
    }

    public String getpName() {
        return pName;
    }

    public void setpPrice(BigDecimal price) {
        this.pPrice = price;
    }

    public void setpName(String name) {
        this.pName = name;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getpImageName() {
        return pImageName;
    }

    public void setpImageName(String imageName) {
        this.pImageName = imageName;
    }
}
