package com.gmail.smjcrane.ultimateidle;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import java.util.List;

public class Counter extends ArrayAdapter<Integer> {
    private List<Integer> digitValues;
    private int incrementPosition;
    private int invalidatePosition;

    public Counter(Context context, List<Integer> ints){
        super(context, R.layout.digit);
        digitValues = ints;
        incrementPosition = Math.max(ints.size() - 4, 0);
    }

    public String getDigitString(){
        String s = "";
        for (int i : digitValues){
            s = s + Integer.toString(i);
        }
        return s;
    }

    public void increment(){
        int position = incrementPosition;
        int old = digitValues.get(position);
        while (old == 9){
            digitValues.set(position, 0);
            position++;
            if (position == digitValues.size()){
                digitValues.add(0);
                incrementPosition = Math.max(digitValues.size() - 4, 0);
            }
            old = digitValues.get(position);
        }
        digitValues.set(position, old + 1);
        invalidatePosition = position;
        notifyDataSetChanged();
    }

    public int getCount(){
        return digitValues.size();
    }

    public void setDigits(List<Integer> digits){
        this.digitValues = digits;
        notifyDataSetChanged();
    }

    public View getView(int position, View view, ViewGroup parent) {

        position = digitValues.size() - position - 1;
        if (view == null){
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                view = vi.inflate(R.layout.digit, null);
        }

        int val = digitValues.get(position);
        boolean blurred = position > incrementPosition  + 2;

        TextSwitcher digit = view.findViewById(R.id.digit);
        digit.setInAnimation(getContext(), R.anim.slide_down_in);
        digit.setOutAnimation(getContext(), R.anim.slide_down_out);

        ImageView blurImage = view.findViewById(R.id.blur);

        if (blurred){
            digit.setVisibility(View.INVISIBLE);
            blurImage.setVisibility(View.VISIBLE);
        } else {
            digit.setVisibility(View.VISIBLE);
            blurImage.setVisibility(View.INVISIBLE);
            if (!Integer.toString(val).equals(((TextView) digit.getCurrentView()).getText().toString())){
                digit.setText(Integer.toString(val));
            }
        }

        return view;
    }

}
