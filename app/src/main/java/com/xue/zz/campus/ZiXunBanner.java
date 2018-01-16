package com.xue.zz.campus;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.List;

public class ZiXunBanner extends FrameLayout {
    private int count;
    private ImageLoader mImageLoader;
    private List<ImageView> imageViews;
    private Context context;
    private ViewPager vp;
    private boolean isAutoPlay;
    private int currentItem;
    private LinearLayout ll_dot;
    private List<ImageView> iv_dots;
    private Handler handler = new Handler();
//    private List<String> id;
//    public List<String> form;
//    public List<String> date;
//    public List<String> author;
//    public List<String> body;
//    public List<String> title;
//    public List<String> htinfo;
//    private List<String> litpic;

    public ZiXunBanner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        initImageLoader(context);
        initData();
    }

    public ZiXunBanner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZiXunBanner(Context context) {
        this(context, null);
    }

    private void initData() {
        imageViews = new ArrayList<>();
        iv_dots = new ArrayList<>();
    }

    public void setImagesUrl(String[] imagesUrl) {
        initLayout();
        initImgFromNet(imagesUrl);
        showTime();
    }

    private void initLayout() {
        imageViews.clear();
        View view = LayoutInflater.from(context).inflate(R.layout.banner_layout, this, true);
        vp = (ViewPager) view.findViewById(R.id.vp);
        ll_dot = (LinearLayout) view.findViewById(R.id.ll_dot);
        ll_dot.removeAllViews();
    }

    private void initImgFromNet(String[] imagesUrl) {
        count = imagesUrl.length;
        for (int i = 0; i < count; i++) {
            ImageView iv_dot = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 5;
            params.rightMargin = 5;
            iv_dot.setImageResource(R.drawable.shape12);
            ll_dot.addView(iv_dot, params);
            iv_dots.add(iv_dot);
        }
        iv_dots.get(0).setImageResource(R.drawable.shape11);
        for (int i = 0; i <= count + 1; i++) {
            ImageView iv = new ImageView(context);
            iv.setScaleType(ScaleType.FIT_XY);
            //iv.setBackgroundResource(R.mipmap.loading);
            if (i == 0) {
                mImageLoader.displayImage(imagesUrl[count - 1], iv);
            } else if (i == count + 1) {
                mImageLoader.displayImage(imagesUrl[0], iv);
            } else {
                mImageLoader.displayImage(imagesUrl[i - 1], iv);
            }
            imageViews.add(iv);
        }
    }

    private void showTime() {
        vp.setAdapter(new BannerPagerAdapter());
        vp.setFocusable(true);
        vp.setCurrentItem(1);
        currentItem = 1;
        vp.setOnPageChangeListener(new MyOnPageChangeListener());
        startPlay();
    }

    private void startPlay() {
        isAutoPlay = true;
        handler.postDelayed(task, 2000);
    }

    public void initImageLoader(Context context) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs().build();
        ImageLoader.getInstance().init(config);
        mImageLoader = ImageLoader.getInstance();
    }

    private final Runnable task = new Runnable() {
        @Override
        public void run() {
            if (isAutoPlay) {
                currentItem = currentItem % (count + 1) + 1;
                if (currentItem == 1) {
                    vp.setCurrentItem(currentItem, false);
                    handler.post(task);
                } else {
                    vp.setCurrentItem(currentItem);
                    handler.postDelayed(task, 2000);
                }
            } else {
                handler.postDelayed(task, 5000);
            }
        }
    };

    class BannerPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            container.addView(imageViews.get(position));
            imageViews.get(position).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(getContext(), ZiXunDetails.class);
//                    intent.putExtra("id", id.get(position - 1));
//                    intent.putExtra("form", form.get(position - 1));
//                    intent.putExtra("date", date.get(position - 1));
//                    intent.putExtra("author", author.get(position - 1));
//                    intent.putExtra("body", body.get(position - 1));
//                    intent.putExtra("title", title.get(position - 1));
//                    intent.putExtra("htinfo", htinfo.get(position - 1));
//                    intent.putExtra("iconURL", litpic.get(position - 1));
//                    context.startActivity(intent);
                }
            });
            return imageViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));
        }
    }

    class MyOnPageChangeListener implements OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < iv_dots.size(); i++) {
                if (i == position - 1) {
                    iv_dots.get(i).setImageResource(R.drawable.shape11);
                } else {
                    iv_dots.get(i).setImageResource(R.drawable.shape12);
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
                case 1:
                    isAutoPlay = false;
                    break;
                case 2:
                    isAutoPlay = true;
                    break;
                case 0:
                    if (vp.getCurrentItem() == 0) {
                        vp.setCurrentItem(count, false);
                    } else if (vp.getCurrentItem() == count + 1) {
                        vp.setCurrentItem(1, false);
                    }
                    currentItem = vp.getCurrentItem();
                    isAutoPlay = true;
                    break;
            }
        }
    }

//    public void id(List<String> id) {
//        this.id = id;
//    }
//
//    public void settitle(List<String> title) {
//        this.title = title;
//
//    }
//
//    public void sethtinfo(List<String> htinfo) {
//        this.htinfo = htinfo;
//
//    }
//
//    public void setauthor(List<String> author) {
//        this.author = author;
//
//    }
//
//    public void setform(List<String> form) {
//        this.form = form;
//
//    }
//
//    public void setlitpic(List<String> litpic) {
//        this.litpic = litpic;
//
//    }
//
//    public void setdate(List<String> date) {
//        this.date = date;
//
//    }
//
//    public void setbody(List<String> body) {
//        this.body = body;
//
//    }


}
