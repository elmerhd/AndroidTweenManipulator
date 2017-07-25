package com.junk.application.androidtween;

import aurelienribon.tweenengine.TweenAccessor;
/**
 * The view component accessor access the view class values and attributes
 * @author Elmerhd
 */
public class ViewComponentAccessor implements TweenAccessor<ViewComponent> {
    
  /**
   * the position X
   */
  public static final int POSITION_X = 1;
  /**
   * the position Y
   */
  public static final int POSITION_Y = 2;
  /**
   * the position X and Y
   */
  public static final int POSITION_XY = 3;
  /**
   * the opacity
   */
  public static final int OPACITY = 4;
  /**
   * the rotation X
   */
  public static final int ROTATION_X = 5;
  /**
   * the rotation Y
   */
  public static final int ROTATION_Y = 6;
  /**
   * the rotation X and Y
   */
  public static final int ROTATION_XY = 7;
  /**
   * the scale X
   */
  public static final int SCALE_X = 8;
  /**
   * the scale Y
   */
  public static final int SCALE_Y = 9;
  /**
   * the scale X and Y
   */
  public static final int SCALE_XY = 10;
    /**
     * gets all the values of the view class
     * @param target the view component target
     * @param tweenType the tweentype
     * @param returnValues the return values
     * @return the values returned
     */
    @Override
    public int getValues(ViewComponent target, int tweenType, float[] returnValues) {
        switch (tweenType) {
            case POSITION_X: returnValues[0] = target.getX(); return 1;
            case POSITION_Y: returnValues[0] = target.getY(); return 1;
            case POSITION_XY:
                returnValues[0] = target.getX();
                returnValues[1] = target.getY();
                return 2;
            case ROTATION_X:
                returnValues[0] = target.getRotationX();return 1;
            case ROTATION_Y:
                returnValues[0] = target.getRotationY(); return 1;
            case ROTATION_XY:
                returnValues[0] = target.getRotationX();
                returnValues[1] = target.getRotationY();
                return 2;
            case SCALE_X:
                returnValues[0] = target.getScaleX();return 1;
            case SCALE_Y:
                returnValues[0] = target.getScaleY();return 1;
            case SCALE_XY:
                returnValues[0] = target.getScaleX();
                returnValues[1] = target.getScaleY();
                return 2;
            case OPACITY:
                returnValues[0] = target.getOpacity();return 1;
            default: assert false; return -1;
        }
    }
    
    /**
     * Sets the values of the view
     * @param target the target value  
     * @param tweenType the tweentype
     * @param newValues the newValue
     */
    @Override
    public void setValues(ViewComponent target, int tweenType, float[] newValues) {
        switch (tweenType) {
        case POSITION_X: target.setX(newValues[0]); break;
        case POSITION_Y: target.setY(newValues[0]); break;
        case POSITION_XY:
            target.setX(newValues[0]);
            target.setY(newValues[1]);
            break;
        case ROTATION_X:
            target.setRotationX(newValues[0]);break;
        case ROTATION_Y:
            target.setRotationY(newValues[0]);break;
        case ROTATION_XY:
            target.setRotationX(newValues[0]);
            target.setRotationY(newValues[1]);
            break;
        case SCALE_X:
            target.setScaleX(newValues[0]);break;
        case SCALE_Y:
            target.setScaleY(newValues[0]);break;
        case SCALE_XY:
            target.setScaleX(newValues[0]);
            target.setScaleY(newValues[1]);
            break;
        case OPACITY:
            target.setOpacity(newValues[0]);break;
            default: assert false; break;
        }
  }
}