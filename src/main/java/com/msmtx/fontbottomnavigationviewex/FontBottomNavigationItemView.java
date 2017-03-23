package com.msmtx.fontbottomnavigationviewex;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.innovattic.font.FontTextView;
import com.innovattic.font.TypefaceManager;

import java.lang.reflect.Field;

/**
 * Created by kmkraiker on 20/03/2017.
 */

public class FontBottomNavigationItemView extends BottomNavigationItemView {

    private final FontTextView mSmallLabel;
    private final FontTextView mLargeLabel;

    public FontBottomNavigationItemView(@NonNull Context context) {
        this(context, null);
    }

    public FontBottomNavigationItemView(@NonNull Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontBottomNavigationItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mSmallLabel = new FontTextView(context);
        mSmallLabel.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, context.getResources().getDisplayMetrics()));
        mSmallLabel.setDuplicateParentStateEnabled(true);
        mSmallLabel.setId(R.id.smallLabel);
        setField(getClass().getSuperclass(), this, "mSmallLabel", mSmallLabel);

        mLargeLabel = new FontTextView(context);
        mLargeLabel.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, context.getResources().getDisplayMetrics()));
        mLargeLabel.setDuplicateParentStateEnabled(true);
        mLargeLabel.setId(R.id.largeLabel);
        setField(getClass().getSuperclass(), this, "mLargeLabel", mLargeLabel);
    }

    /**
     * change the field value
     *
     * @param targetClass
     * @param instance    the filed owner
     * @param fieldName
     * @param value
     */
    private void setField(Class targetClass, Object instance, String fieldName, Object value) {
        try {
            Field field = targetClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void setTextFont(String textFont) {
        TypefaceManager manager = TypefaceManager.getInstance();
        manager.setTypeface(mSmallLabel, textFont);
        manager.setTypeface(mLargeLabel, textFont);
    }

}
