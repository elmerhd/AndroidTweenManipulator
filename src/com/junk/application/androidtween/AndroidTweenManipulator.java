
package com.junk.application.androidtween;

import android.app.Activity;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenAccessor;
import aurelienribon.tweenengine.TweenManager;

/**
 * A tween manipulator manipulates every tween on android application(s) 
 * whats inside?
 * well actually a thread that updates {@link aurelienribon.tweenengine.TweenManager}
 * in every seconds of time.
 * @author Elmerhd
 */
public class AndroidTweenManipulator{
    
    private TweenManager tweenManager;
    private Activity activity;
    private boolean isRunningThreadAnimation = false;

    /**
     * Instantiate new Tween Manipulator
     * @param activity the current activity.
     */
    public AndroidTweenManipulator(Activity activity) {
        this.activity = activity;
    }
    /**
     * Register all the attributes of the android components.
     * @param clasz the class to register.
     * @param tweenAccessor the accessor of the class that has been register.
     * @param tweenManager the tweenmanager.
     */
    public void registerAttributes(Class<?>clasz,TweenAccessor<?> tweenAccessor,TweenManager tweenManager){
        Tween.registerAccessor(clasz, tweenAccessor);
        this.tweenManager = tweenManager;
    }
    /**
     * Sets the attrib limits if you have a combination of XYWH just set 4
     * @param attribLimits the attribute limits.
     */
    public void setCombineAttrLimits(int attribLimits){
        Tween.setCombinedAttributesLimit(attribLimits);
    }
    /**
     * Starts the thread.
     */
    public void start() {
        isRunningThreadAnimation = true;
        Thread animationThread = new Thread(new Runnable() {
            private long lastMillis = -1;

            @Override public void run() {
            while (isRunningThreadAnimation) {
                if (lastMillis > 0) {
                    long currentMillis = System.currentTimeMillis();
                    final float delta = (currentMillis - lastMillis) / 1000f;
                    activity.runOnUiThread(new Runnable() {

                        @Override public void run() {
                            tweenManager.update(delta);
                        }
                    });

                    lastMillis = currentMillis;
                }else{
                    lastMillis = System.currentTimeMillis();
                }
            }
            }
        });
        animationThread.start();
    }
    /**
     * Stops the thread
     */
    public void stop() {
        isRunningThreadAnimation = false;
    }
    /**
     * Returns if the thread is running.
     * @return true if running else if not.
     */
    public boolean isRunning(){
        return isRunningThreadAnimation;
    }
}