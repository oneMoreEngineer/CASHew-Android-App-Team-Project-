package com.example.cs160cashew;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class MyThirdAdapter  extends RecyclerView.Adapter<MyThirdAdapter.ViewHolder>{
    private List<Transaction> values;
    private int temp;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView spent;

        public View layout;
        private ImageView icon;
        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            spent = (TextView) v.findViewById(R.id.value);
        }
    }


    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyThirdAdapter(List<Transaction> myDataset) {
        values = myDataset;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public MyThirdAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyThirdAdapter.ViewHolder vh = new MyThirdAdapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyThirdAdapter.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String name = values.get(position).name;
        final int val =  values.get(position).value;
        final Transaction transaction = values.get(position);
        holder.txtHeader.setText(name);
        holder.spent.setText("$" + Integer.toString(val));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }


}

