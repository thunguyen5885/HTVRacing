package htv.racing.layers.ui.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.view.Window;

import htv.racing.R;
import htv.racing.layers.ui.base.BaseActivity;
import htv.racing.layers.ui.components.CommonFooter;
import htv.racing.layers.ui.components.CommonHeader;
import htv.racing.layers.ui.fragments.HomeFragment;
import htv.racing.layers.ui.fragments.MenuFragment;

/**
 * Created by ThuNguyen on 12/8/2014.
 */
public class HomeActivity extends BaseActivity implements CommonHeader.IOnHeaderClickListener{
    // For object
    private CommonHeader mCommonHeader;
    private CommonFooter mCommonFooter;

    // For layout, control, view
    private MenuFragment mMenuFragment;
    private View mMainContent;
    private SlidingPaneLayout mSlidingPanelLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        // Initialize layout here
        View headerView = findViewById(R.id.header);
        mCommonHeader = new CommonHeader(headerView);
        mCommonHeader.setOnHeaderClickListener(this);

        View footerView = findViewById(R.id.footer);
        mCommonFooter = new CommonFooter(footerView);

        mMenuFragment = (MenuFragment) getFragmentManager().findFragmentById(R.id.menuFragment);

        mSlidingPanelLayout = (SlidingPaneLayout) findViewById(R.id.slidingPanelLayout);
        mSlidingPanelLayout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View view, float v) {

            }

            @Override
            public void onPanelOpened(View view) {
            }

            @Override
            public void onPanelClosed(View view) {
            }
        });
        mMenuFragment.setSlidingLayout(mSlidingPanelLayout);
        // Show home fragment as default
        mSlidingPanelLayout.closePane();
        HomeFragment homeFragment = new HomeFragment();
        showFragmentFromMenu(homeFragment);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public void showFragment(Fragment frag) {
        // Alway close pane layout
        if(mSlidingPanelLayout != null) {
            mSlidingPanelLayout.closePane();
        }

        FragmentManager fragmentManager = getFragmentManager();
        String backStateName = frag.getClass().getName();

        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.animator.fragment_slide_left_enter,
                R.animator.fragment_slide_left_exit,
                R.animator.fragment_slide_right_enter,
                R.animator.fragment_slide_right_exit);

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.flRightContent, frag);
        fragmentTransaction.commit();
    }

    /**
     * Show fragment from left menu
     *
     * @param frag
     */
    public void showFragmentFromMenu(Fragment frag) {
        // Alway close pane layout
        if(mSlidingPanelLayout != null) {
            mSlidingPanelLayout.closePane();
        }
        FragmentManager fragmentManager = getFragmentManager();
        String backStateName = frag.getClass().getName();

        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.setCustomAnimations(0, 0,
                R.animator.fragment_slide_right_enter,
                R.animator.fragment_slide_right_exit);
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(
                backStateName, 0);

        if (!fragmentPopped
                && fragmentManager.findFragmentByTag(backStateName) == null) {
            fragmentTransaction.replace(R.id.flRightContent, frag,
                    backStateName);
            fragmentTransaction.addToBackStack(backStateName);
        } else {
            Fragment currFrag = (Fragment) fragmentManager
                    .findFragmentByTag(backStateName);
            fragmentTransaction.show(currFrag);
        }

        fragmentTransaction.commit();
    }

    /**
     * Hide the separator on footer
     */
    public void hideFooterSeparator(){
        if(mCommonFooter != null){
            mCommonFooter.hideIndicator();
        }
    }

    /**
     * Show the separator on footer
     */
    public void showFooterSeparator(){
        if(mCommonFooter != null){
            mCommonFooter.showIndicator();
        }
    }
    public void showHeaderBackButton(){
        if(mCommonHeader != null){
            mCommonHeader.showBackButton();
        }
    }
    public void hideHeaderBackButton(){
        if(mCommonHeader != null){
            mCommonHeader.hideBackButton();
        }
    }
    @Override
    public void onMenuClicked() {
        if(mSlidingPanelLayout != null){
            if(mSlidingPanelLayout.isOpen()){
                mSlidingPanelLayout.closePane();
            }else{
                mSlidingPanelLayout.openPane();
            }
        }
    }

    @Override
    public void onBack() {
        onBackPressed();
    }
}
