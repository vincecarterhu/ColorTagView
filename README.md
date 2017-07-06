# ColorTagView
[![](https://jitpack.io/v/vincecarterhu/ColorTagView.svg)](https://jitpack.io/#vincecarterhu/ColorTagView)

一个多种样式的小标签,告别繁多的xml布局
效果如下
![](https://github.com/vincecarterhu/ColorTagView/blob/master/ScreensShots/Screenshot1.png)

使用方法
1.在Project的build.gradle中添加仓库地址
``` gradle
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
2.添加依赖
```
	dependencies {
	        compile 'com.github.vincecarterhu:ColorTagView:1.0'
	}

```

自定义参数介绍
```
  <declare-styleable name="ColorTagView">

        <attr name="tag_bg" format="color"></attr>   <!-- backgroud tagview   背景颜色-->

        <attr name="tag_bg_style" format="enum">     <!-- tag style   显示样式-->
            <enum name="FILL" value="0"></enum>

            <enum name="STROKE" value="1"></enum>
        </attr>

        <attr name="tag_bg_stroke_width" format="dimension"></attr>   <!-- stoke width   -->

        <attr name="tag_text" format="string"></attr>                <!--tag text -->

        <attr name="tag_textSize" format="dimension"></attr>          <!-- tag text size  字体大小-->

        <attr name="tag_textColor" format="color"></attr>             <!-- text color  字体颜色 -->   

        <attr name="tag_radius" format="dimension"></attr>            <!--tag  radius   --> 


    </declare-styleable>
```
 具体用法
```  
     xmlns:vc="http://schemas.android.com/apk/res-auto"

<com.vc.view.colortagview.ColorTagView
       android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        vc:tag_bg="@color/colorAccent"
        vc:tag_radius="30dp"
        vc:tag_textSize="20sp"
        vc:tag_textColor="@color/white"
        vc:tag_text="hello world"
        android:paddingLeft="10dp"
        android:paddingRight="10dp"
        android:layout_marginTop="10dp"
        android:layout_marginLeft="10dp"
    />
 ```  
   
    



