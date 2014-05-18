package io.nlopez.toolkit.utils;

import android.content.Context;

import java.lang.reflect.Method;

import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 18/05/14.
 */
public class AABindableLayoutBuilder<T, Q extends BindableLayout<T>> implements BindableLayoutBuilder<T, Q> {

    private Class viewClass;

    public AABindableLayoutBuilder(Class viewClass) {
        this.viewClass = viewClass;
    }

    @Override
    public Q build(Context context, T item, int position) {
        try {
            Method method = viewClass.getMethod("build", Context.class);
            return (Q) method.invoke(null, context);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong creating the views", e);
        }
    }
}
