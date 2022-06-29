package com.example.cs160cashew;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class User implements Parcelable {
    private String name = "default";
    //private BankAccount bankAccount = new BankAccount();
    private List<Budget> budgetList = new ArrayList<Budget>();

    public User(){

    }
    User(String s){
        name = s;
        budgetList.add(new Budget("Food Budget",300, 300, 1));
        budgetList.add(new Budget("Miscellaneous",500, 500, 1));
    }

    protected User(Parcel in) {
        name = in.readString();
        budgetList = in.createTypedArrayList(Budget.CREATOR);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public void addBudget(Budget b){
        budgetList.add(b);
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getBudgetList(){
        return budgetList;
    }

    public void setBudgetList(List budgetList) {
        this.budgetList = budgetList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(name);
        parcel.writeTypedList(budgetList);

    }
}
