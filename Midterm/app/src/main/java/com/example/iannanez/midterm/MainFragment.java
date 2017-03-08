package com.example.iannanez.midterm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {


    private TextView listTxt;

    ListView listview;
    Button search;
    Button clear;
    EditText searchTerm;
    TaskArrayAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_main, container, false);

        final Context ctx = this.getActivity();

        listview = (ListView) v.findViewById(R.id.listview);

        final ArrayList<Task> items = new ArrayList<Task>();
        items.add(new Task(12,"Mouse", "small"));
        items.add(new Task(3,"Donkey", "stubborn"));
        items.add(new Task(6,"Rhino", "direct"));
        items.add(new Task(5,"Zebra", "black or white"));
        items.add(new Task(4,"Antelope", "awesome"));

        Collections.sort(items);

        adapter = new TaskArrayAdapter (this.getActivity(), items);

        final ArrayList<Task> items2 = new ArrayList<Task>();

        searchTerm = (EditText) v.findViewById(R.id.search_term);


        search = (Button) v. findViewById(R.id.search_button);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a message by using a Toast
                String message = searchTerm.getText().toString();
                Log.d("Button",message);

                items2.clear();

                for(Task t : items) {
                    if (t.getDescription().contains(message)) {
                        Log.d("Contains", t.getDescription());
                        items2.add(t);
                    }
                    else if (t.getTitle().contains(message)) {
                        Log.d("Contains", t.getTitle());
                        items2.add(t);
                    }
                }
                adapter = new TaskArrayAdapter (ctx, items2);
                listview.setAdapter(adapter);

            }
        });

        clear = (Button) v. findViewById(R.id.clear_button);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a message by using a Toast
                Log.d("Button","Clear");

                adapter = new TaskArrayAdapter (ctx, items);
                listview.setAdapter(adapter);
            }
        });





        listview.setAdapter(adapter);


        return v;
    }



//
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
