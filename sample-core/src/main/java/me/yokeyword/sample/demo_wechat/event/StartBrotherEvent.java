package me.yokeyword.sample.demo_wechat.event;


import org.ayo.fragmentation.SupportFragment;

/**
 * Created by YoKeyword on 16/6/30.
 */
public class StartBrotherEvent {
    public SupportFragment targetFragment;

    public StartBrotherEvent(SupportFragment targetFragment) {
        this.targetFragment = targetFragment;
    }
}
