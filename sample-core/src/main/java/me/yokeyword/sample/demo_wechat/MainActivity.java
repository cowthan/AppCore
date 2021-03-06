package me.yokeyword.sample.demo_wechat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import org.ayo.component.sample.R;
import org.ayo.fragmentation.SupportActivity;
import org.ayo.fragmentation.SupportFragment;
import org.ayo.fragmentation.anim.DefaultHorizontalAnimator;
import org.ayo.fragmentation.anim.FragmentAnimator;
import org.ayo.fragmentation.helper.FragmentLifecycleCallbacks;

import me.yokeyword.sample.demo_wechat.ui.fragment.MainFragment;

/**
 * 仿微信交互方式Demo   tip: 多使用右上角的"查看栈视图"
 * Created by YoKeyword on 16/6/30.
 */
public class MainActivity extends SupportActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_activity_main);

        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance());
        }

        // 可以监听该Activity下的所有Fragment的18个 生命周期方法
        registerFragmentLifecycleCallbacks(new FragmentLifecycleCallbacks() {

            @Override
            public void onFragmentSupportVisible(SupportFragment fragment) {
                Log.i("PermissionMainActivity", "onFragmentSupportVisible--来了->" + fragment.getClass().getSimpleName());
            }

            @Override
            public void onFragmentSupportInvisible(SupportFragment fragment) {
                Log.i("PermissionMainActivity", "onFragmentSupportInvisible--走了->" + fragment.getClass().getSimpleName());
            }

            @Override
            public void onFragmentCreated(SupportFragment fragment, Bundle savedInstanceState) {
                Log.i("PermissionMainActivity", "onFragmentCreated--create了->" + fragment.getClass().getSimpleName());
            }

            @Override
            public void onFragmentDestroyed(SupportFragment fragment) {
                Log.i("PermissionMainActivity", "onFragmentDestroyed--destroy了->" + fragment.getClass().getSimpleName());
            }

            // 省略其余生命周期方法
        });
    }

    @Override
    public void onExceptionAfterOnSaveInstanceState(Exception e) {
        // TODO: 16/12/7 在此可以监听到警告： Can not perform this action after onSaveInstanceState!
        // 建议在线上包中，此处上传到异常检测服务器（eg. 自家异常检测系统或Bugtags等崩溃检测第三方），来监控该异常
    }

    @Override
    public void onBackPressedSupport() {
        // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
        super.onBackPressedSupport();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
    }
}
