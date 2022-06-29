package com.example.cs160cashew;

import android.os.Parcel;
import android.os.Parcelable;


public class Transaction implements Parcelable {

    String name = "untitled";
    int value = 0;

    Transaction(String s, int i){
        name = s;
        value = i;
    }


    protected Transaction(Parcel in) {
        name = in.readString();
        value = in.readInt();
    }



    public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel in) {
            return new Transaction(in);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(name);
        parcel.writeInt(value);

    }

    public String getName() {
        return name;
    }


    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }



}
