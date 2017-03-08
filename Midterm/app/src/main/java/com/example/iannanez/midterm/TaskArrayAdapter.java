package com.example.iannanez.midterm;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//import edu.amherst.cs.myamherst.Task;

/**
 * Created by aprasad on 1/29/17.
 */

public class TaskArrayAdapter extends ArrayAdapter<Task> {

    private final Context context;
//    private final String[] values;

    String priorType = "";
    String priorSection = "";

    ArrayList<Task> items;

    public TaskArrayAdapter(Context ctx, ArrayList<Task> items)
    {
        super(ctx, R.layout.task_layout);
        this.context = ctx;
       // items = FileUtil.readFromFile(context);

        this.items = items;
        Log.d("TaskArrayAdapter", "Read " + items.size() + " items");
    }

    public View getView (final int position, View convertView, ViewGroup parent)
    {

        final TextView textView1;
        final TextView textView2;
        final TextView textView3;
        CheckBox check;


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.task_layout, null);
            textView1 = (TextView) convertView.findViewById(R.id.task_priority);
            textView2 = (TextView) convertView.findViewById(R.id.task_title);
            textView3 = (TextView) convertView.findViewById(R.id.task_description);
            check = (CheckBox) convertView.findViewById(R.id.task_complete);





            //View rowView = inflater.inflate(R.layout.task_layout, parent, false);
            check.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    items.get(position).changeComplete();
                    //Planet planet = (Planet) cb.getTag();
                    if(items.get(position).isComplete()) {
                        Log.d("Checked", "isChecked");
                        textView1.setPaintFlags(textView1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        textView2.setPaintFlags(textView2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        textView3.setPaintFlags(textView3.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    }
                    else{
                        Log.d("Checked", "notChecked");
                        textView1.setPaintFlags(textView1.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                        textView2.setPaintFlags(textView2.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                        textView3.setPaintFlags(textView3.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    }
                }
            });

            Log.d("TaskArrayAdapter", "Row " + position);


            String priority_string = Integer.toString(items.get(position).getPriority());
            textView1.setText(priority_string);

            textView2.setText(items.get(position).getTitle());
            textView3.setText(items.get(position).getDescription());

            //        check.setOnClickListener(new View.OnClickListener() {
            //            public void onClick(View arg0) {
            //                items.get(position).changeComplete();
            //
            //                if(items.get(position).isComplete()) {
            //                    Log.d("Checked", "isChecked");
            //                }
            //                else{
            //                    Log.d("Checked", "notChecked");
            //                }
            //
            //                // Do something here.
            //            }
            //        });

        }

            return convertView;


    }



    //1
    @Override
    public int getCount() {
        return items.size();
    }

    //2
    @Override
    public Task getItem(int position) {
        return items.get(position);
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

//    //4
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // Get view for row item
//        View rowView = mInflater.inflate(R.layout.list_item_recipe, parent, false);
//
//        return rowView;
//    }

}
