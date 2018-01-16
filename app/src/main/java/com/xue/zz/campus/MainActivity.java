package com.xue.zz.campus;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.xue.zz.campus.fragment.FragmentFour;
import com.xue.zz.campus.fragment.FragmentOne;
import com.xue.zz.campus.fragment.FragmentThree;
import com.xue.zz.campus.fragment.FragmentTwo;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;
    private FragmentThree mFragmentThree;
    private FragmentFour mFragmentFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
//      mBottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
//      mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
//      mBottomNavigationBar.setBarBackgroundColor(R.color.blue);//设置导航栏的背景颜色
//      mBottomNavigationBar.setInActiveColor(R.color.white);//没有图标的颜色
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.icon_one, R.string.tab_one).setActiveColorResource(R.color.green))
                .addItem(new BottomNavigationItem(R.drawable.icon_two, R.string.tab_two).setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.icon_three, R.string.tab_three).setActiveColorResource(R.color.lime))
                .addItem(new BottomNavigationItem(R.drawable.icon_four, R.string.tab_four))
                .setFirstSelectedPosition(0)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }
    /**
     * 默认为第一个显示
     */
    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        mFragmentOne = new FragmentOne();
        transaction.replace(R.id.ll_content, mFragmentOne).commit();
    }
    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                mFragmentOne = new FragmentOne();
                transaction.replace(R.id.ll_content, mFragmentOne);
                break;
            case 1:
                mFragmentTwo = new FragmentTwo();
                transaction.replace(R.id.ll_content, mFragmentTwo);
                break;
            case 2:
                mFragmentThree = new FragmentThree();
                transaction.replace(R.id.ll_content, mFragmentThree);
                break;
            case 3:
                mFragmentFour = new FragmentFour();
                transaction.replace(R.id.ll_content, mFragmentFour);
                break;
            default:
                mFragmentOne = new FragmentOne();
                transaction.replace(R.id.ll_content, mFragmentOne);
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
