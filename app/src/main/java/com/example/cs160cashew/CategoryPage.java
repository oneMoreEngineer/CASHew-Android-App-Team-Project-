package com.example.cs160cashew;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;

public class CategoryPage extends AppCompatActivity {
    private RecyclerView budgetListRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    Category category;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_page);


        Intent intentApp = getIntent();
        category = intentApp.getParcelableExtra("categoryItem");

        TextView welcomeText = (TextView) findViewById(R.id.WelcomeText);
        TextView budgetLimit = (TextView) findViewById(R.id.budgetLimit);

        welcomeText.setText(category.getName());
        budgetLimit.setText("$" + category.getSpending());

        budgetListRecyclerView = (RecyclerView) findViewById(R.id.my_budget_list);


        budgetListRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        budgetListRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyThirdAdapter(category.getTransactionList());


        budgetListRecyclerView.setAdapter(mAdapter);
        Calendar c = Calendar.getInstance();

        int monthDay = Budget.monthDay;
        System.out.println("Day of month: " + monthDay);

        if(monthDay > Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH))
            monthDay = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        if(monthDay == c.get(Calendar.DAY_OF_MONTH)){
            category.setSpending(0);

        }

        Button addButton = (Button) findViewById(R.id.addTransactionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alertDialog = new AlertDialog.Builder(CategoryPage.this).create();
                alertDialog.setTitle("Add a Transaction");

                LinearLayout layout1 = new LinearLayout(CategoryPage.this);
                layout1.setOrientation(LinearLayout.VERTICAL);
                final EditText input = new EditText(CategoryPage.this);
                final EditText input2 = new EditText(CategoryPage.this);

                input.setHint("memo");
                input2.setHint("0");

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                input2.setInputType(InputType.TYPE_CLASS_NUMBER);


                layout1.addView(input);
                layout1.addView(input2);
                alertDialog.setView(layout1);

                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        String s = "no memo";

                        if(!TextUtils.isEmpty(input.getText().toString())){
                           s = input.getText().toString();
                        }
                        Transaction t = new Transaction(s, Integer.parseInt(input2.getText().toString()));
                        category.addTransaction(t);
                        budgetListRecyclerView.setAdapter(mAdapter);
                        budgetLimit.setText("$" + category.getSpending());

                    }
                });


                alertDialog.setButton(Dialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alertDialog.show();


            }
        });




        Button editButton = (Button) findViewById(R.id.editCategory);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alertDialog = new AlertDialog.Builder(CategoryPage.this).create();
                alertDialog.setTitle("Edit Category");

                LinearLayout layout1 = new LinearLayout(CategoryPage.this);
                layout1.setOrientation(LinearLayout.VERTICAL);
                final EditText input = new EditText(CategoryPage.this);


                input.setHint(category.getName());




                input.setInputType(InputType.TYPE_CLASS_TEXT);




                layout1.addView(input);
                alertDialog.setView(layout1);



                alertDialog.setButton(Dialog.BUTTON_POSITIVE, "Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(!TextUtils.isEmpty(input.getText().toString())){
                            category.setName(input.getText().toString());
                            welcomeText.setText(category.getName());
                        }

                    }
                });


                alertDialog.setButton(Dialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });




                alertDialog.show();


            }


        });






        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_OK,
                        new Intent().putExtra("categoryItem", category));
                finish();
            }
        });





    }



}