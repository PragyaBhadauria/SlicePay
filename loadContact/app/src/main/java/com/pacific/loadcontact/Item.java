package com.pacific.loadcontact;



public class Item {

    String flowerListName;
    int flowerListImage;

    public Item(String flowerName,int flowerImage)
    {
        this.flowerListImage=flowerImage;
        this.flowerListName=flowerName;
    }
    public String getflowerName()
    {
        return flowerListName;
    }
    public int getflowerImage()
    {
        return flowerListImage;
    }
}
