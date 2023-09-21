package com.example.quadraticequationsolver;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticequationsolver.databinding.ActivityMainBinding;

public class MyEquation extends BaseObservable {

    String a, b, c;

    ActivityMainBinding binding;

    public MyEquation(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public MyEquation() {
    }

    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void solveEquation(View view) {

        //converting strings to int
        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        //calculate the discriminants
        double discriminant = ((b*b) - 4*(a*c));

        //Finding the solution
        double root1, root2;

        if(discriminant > 0) {

            root1 = (-b + Math.sqrt(discriminant))/(2*a);
            root2 = (-b - Math.sqrt(discriminant))/(2*a);

            //Display the results in the textview
            binding.textViewResult.setText("Root 1 = "+root1+", Root 2 = "+root2);

        } else if (discriminant > 0) {
            // no real roots
            binding.textViewResult.setText("No real roots");
        } else {
            // one real root
            root1 = -b / (2*a);
            binding.textViewResult.setText("Root = "+root1);
        }


    }
}
