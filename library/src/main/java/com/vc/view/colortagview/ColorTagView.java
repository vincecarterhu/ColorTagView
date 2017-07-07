package com.vc.view.colortagview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by vc on 2017/7/5.
 */

public class ColorTagView extends View {

    private int width;

    private int height;

    private int mTagRadius;

    private int mTagBgColor;

    private String mTagText;

    private int mTagTextSize;

    private int mTagTextColor;



    public static final int FILL =0;

    public static final int STROKE= 1;

    private int mTagBgStyle;

    private int mTagBgStrokeWidth;
    RectF rectF;

    Paint  paint  =new Paint(Paint.ANTI_ALIAS_FLAG);

    private Paint mTextPaint =new Paint(Paint.ANTI_ALIAS_FLAG);;

    public ColorTagView(Context context) {
        this(context,null);
    }

    public ColorTagView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ColorTagView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.ColorTagView);

        mTagRadius = array.getDimensionPixelSize(R.styleable.ColorTagView_tag_radius,dp2px(20));

        mTagBgColor = array.getColor(R.styleable.ColorTagView_tag_bg,Color.WHITE);

        mTagBgStyle = array.getInt(R.styleable.ColorTagView_tag_bg_style,FILL);

        mTagBgStrokeWidth  =array.getDimensionPixelSize(R.styleable.ColorTagView_tag_bg_stroke_width,dp2px(1));

        mTagText  = array.getString(R.styleable.ColorTagView_tag_text);

        mTagTextSize = array.getDimensionPixelSize(R.styleable.ColorTagView_tag_textSize,sp2px(14));

        mTagTextColor = array.getColor(R.styleable.ColorTagView_tag_textColor,Color.BLACK);




        array.recycle();



        mTextPaint.setTextSize(mTagTextSize);



    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode= MeasureSpec.getMode(heightMeasureSpec);


        if(widthMode ==MeasureSpec.EXACTLY ){

              width = MeasureSpec.getSize(widthMeasureSpec);

        }else if(widthMode ==MeasureSpec.AT_MOST || widthMode ==MeasureSpec.UNSPECIFIED) {


              width = (int) mTextPaint.measureText(mTagText) + getPaddingLeft() +getPaddingRight();
        }


        if(heightMode ==MeasureSpec.EXACTLY){

            height = MeasureSpec.getSize(heightMeasureSpec);

        }else  if(heightMode ==MeasureSpec.AT_MOST || heightMode ==MeasureSpec.UNSPECIFIED) {


            Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();

            height  = (int) (fontMetrics.bottom - fontMetrics.top) + getPaddingTop() + getPaddingBottom();

        }

        setMeasuredDimension(width,height);


    }






    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(mTagBgColor);
        if(mTagBgStyle == FILL){
            paint.setStyle(Paint.Style.FILL);
        }else {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(mTagBgStrokeWidth);
        }


        if(mTagBgStyle == STROKE){
            rectF =new RectF(mTagBgStrokeWidth,mTagBgStrokeWidth,getMeasuredWidth() -mTagBgStrokeWidth,getMeasuredHeight()-mTagBgStrokeWidth );

            canvas.drawRoundRect(rectF,mTagRadius,mTagRadius,paint);
        }else {
            rectF =new RectF(0,0,getMeasuredWidth(),getMeasuredHeight());


            canvas.drawRoundRect(rectF,mTagRadius,mTagRadius,paint);
        }



        mTextPaint.setColor(mTagTextColor);


        // 计算绘制文本的高度
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();

        int textHeight = (int) (getMeasuredHeight() / 2 - fontMetrics.descent + (fontMetrics.bottom - fontMetrics.top) / 2);


        canvas.drawText(mTagText,getPaddingLeft(),textHeight,mTextPaint);



    }

    public int getTagRadius() {
        return mTagRadius;
    }

    public void setTagRadius(int tagRadius) {
        mTagRadius = dp2px(tagRadius);
    }

    public int getTagBgColor() {
        return mTagBgColor;
    }

    public void setTagBgColor(int tagBgColor) {
        mTagBgColor = tagBgColor;
    }

    public String getTagText() {
        return mTagText;
    }

    public void setTagText(String tagText) {
        mTagText = tagText;
    }

    public int getTagTextSize() {
        return mTagTextSize;
    }

    public void setTagTextSize(int tagTextSize) {
        mTagTextSize = tagTextSize;
    }

    public int getTagTextColor() {
        return mTagTextColor;
    }

    public void setTagTextColor(int tagTextColor) {
        mTagTextColor = tagTextColor;
    }

    public int getTagBgStyle() {
        return mTagBgStyle;
    }

    public void setTagBgStyle(int tagBgStyle) {
        mTagBgStyle = tagBgStyle;
    }

    public int getTagBgStrokeWidth() {
        return mTagBgStrokeWidth;
    }

    public void setTagBgStrokeWidth(int tagBgStrokeWidth) {
        mTagBgStrokeWidth = tagBgStrokeWidth;
        paint.setStrokeWidth(dp2px(mTagBgStrokeWidth));
        invalidate();

    }

    public int sp2px(int spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, getResources().getDisplayMetrics());
    }

    public int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, getResources().getDisplayMetrics());

    }



}
