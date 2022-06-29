package com.example.cs160cashew;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Budget implements Parcelable {

    private String name;
    private List<Category> categoryList = new ArrayList<Category>();
    private int limit;
    private double progress;
    public static int monthDay;

    public int didReset;
    Budget(String n, Category c, int l, double p, int m){
        name = n;
        categoryList.add(c);
        limit = l;
        progress = p;
        monthDay = m;
    }

    Budget(String n, int l, double p, int m){
        name = n;
        limit = l;
        progress = p;
        monthDay = m;
    }

    public void setMonthDay(int m){ monthDay = m; }

    public int getMonthDay(){
        return monthDay;
    }

    public void setName(String s){
        name = s;
    }

    public void setLimit(int i){
        limit = i;
    }

    public int amountSpent(){
        int sum = 0;
        for(int i = 0; i < categoryList.size(); i++){
            sum += categoryList.get(i).spending;
        }

        return sum;
    }

    protected Budget(Parcel in) {

        name = in.readString();
        in.readTypedList(categoryList, Category.CREATOR);
        limit = in.readInt();
        progress = in.readDouble();
        monthDay = in.readInt();

    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeTypedList(categoryList);
        dest.writeInt(limit);

        dest.writeDouble(progress);
        dest.writeInt(monthDay);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Budget> CREATOR = new Creator<Budget>() {
        @Override
        public Budget createFromParcel(Parcel in) {
            return new Budget(in);
        }

        @Override
        public Budget[] newArray(int size) {
            return new Budget[size];
        }
    };

    public void addCategory(Category c){
        categoryList.add(c);
    }

    public void updateProgress(double newProgress){progress -= newProgress;}

    public String getName(){
        return name;
    }

    public int getLimit(){
        return limit;
    }

    public double getProgress(){
        return progress;
    }



    public List<Category> getCategoryList(){
        return categoryList;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
