package io.nlopez.toolkit.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import io.nlopez.toolkit.utils.ViewEventListener;

/**
 * Created by mrm on 18/05/14.
 */
public abstract class BindableLayout<T> extends LinearLayout {

    protected ViewEventListener<T> viewEventListener;
    protected T item;
    protected int position;

    public BindableLayout(Context context) {
        super(context);
    }

    public BindableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BindableLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void bind(T item, int position) {
        this.item = item;
        this.position = position;
        bind(item);
    }

    public abstract void bind(T item);

    public ViewEventListener<T> getViewEventListener() {
        return viewEventListener;
    }

    public void setViewEventListener(ViewEventListener<T> viewEventListener) {
        this.viewEventListener = viewEventListener;
    }


    public void notifyItemAction(int actionId, T theItem, View view) {
        if (viewEventListener != null) {
            viewEventListener.onViewEvent(actionId, theItem, view);
        }
    }

    public void notifyItemAction(int actionId, View view) {
        notifyItemAction(actionId, item, view);
    }

    public void notifyItemAction(int actionId) {
        notifyItemAction(actionId, item, this);
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
