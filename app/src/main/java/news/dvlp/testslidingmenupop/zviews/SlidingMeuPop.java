package news.dvlp.testslidingmenupop.zviews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;




import java.util.Map;

import news.dvlp.testslidingmenupop.R;



/**
 * Created by syx on 2018/8/7.
 */
public class SlidingMeuPop extends PopupWindow {

    
    private View conentView;
    private Activity mActivity;
    private WindowManager.LayoutParams params;




    public SlidingMeuPop(Activity mActivity) {
        this.mActivity = mActivity;
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        params = mActivity.getWindow().getAttributes();
        conentView = inflater.inflate(R.layout.activity_sliding_meu, null);
        initView();
    }

    private void initView() {
        this.setContentView(conentView);
        //设置宽度,若没有设置宽度为LayoutParams.WRAP_CONTENT
        this.setWidth(SizeUtils.dp2px(280));
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        setOnDismissListener(new poponDismissListener());
        //设置动画，也可以不设置。不设置则是显示默认的
        this.setAnimationStyle(R.style.sliding);
        backgroundAlpha(0.5f);
        //这里很重要，不设置这个ListView得不到相应
        this.setFocusable(true);
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setOutsideTouchable(true);
        refresh();


    }

    /**
     * 返回刷新数据
     */
    public void refresh() {

    }

    public void showPop() {
        this.showAtLocation(mActivity.getWindow().getDecorView(), 0, 0, 0);
    }


    /**
     * 添加新笔记时弹出的popWin关闭的事件，主要是为了将背景透明度改回来
     *
     * @author cg
     */
    class poponDismissListener implements OnDismissListener {

        @Override
        public void onDismiss() {
            backgroundAlpha(1f);
        }

    }


    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        mActivity.getWindow().setAttributes(lp);
    }












}
