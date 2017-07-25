package com.junk.application.androidtween;

import android.view.View;
import android.widget.RelativeLayout;

/**
 * The view component is the component parser of all the components on android.
 * @author Elmerhd
 */
public class ViewComponent {
    private float x, y;
    private View view;
    /**
     * the view component to parse
     * @param view the component
     */
    public ViewComponent(View view) {
          this.view = view;
    }
    /**
     * Get the x location
     * @return the x location
     */
    public float getX() {
        x = view.getX();
        return x;
    }
    public float getRotationX(){
        return view.getRotationX();
    }
    public float getRotationY(){
        return view.getRotationY();
    }
    public float getScaleX(){
        return view.getScaleX();
    }
    public float getScaleY(){
        return view.getScaleY();
    }
    public float getOpacity(){
        return view.getAlpha();
    }
    public void setOpacity(float value){
        view.setAlpha(value);
    }
    public void setScaleY(float value){
        view.setScaleY(value);
    }
    public void setScaleX(float value){
        view.setScaleX(value);
    }
    public void setRotationY(float value){
            view.setRotationY(value);
    }
    public void setRotationX(float value){
            view.setRotationX(value);
    }
    /**
     * Gets the y position
     * @return the y position
     */
    public float getY() {
            y = view.getY();
        return y;
    }
    /**
     * Sets the x position
     * @param x the x position
     */
    public void setX(float x) {
        this.x = x;
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)view.getLayoutParams();
        params.leftMargin= (int)x;
        view.setLayoutParams(params);
    }
    /**
     * SetY position
     * @param y the y position
     */
    public void setY(float y) {
        this.y = y;
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)view.getLayoutParams();
        params.topMargin = (int)y;
        view.setLayoutParams(params);

    }
}