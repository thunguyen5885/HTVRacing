package htv.racing.layers.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import htv.racing.R;
import htv.racing.layers.ui.activities.HomeActivity;
import htv.racing.layers.ui.components.views.foreground.ForegroundRelativeLayout;

/**
 * Created by ThuNguyen on 12/11/2014.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{
    public interface IHomeItemOnClickListner{
        public void onHomeItemDatingManagementClicked();
        public void onHomeItemCalendarCreatingClicked();
        public void onHomeItemPatientListClicked();
        public void onHomeItemStatisticClicked();
    }
    private View mDatingManagementLayout;
    private View mCalendarCreatingLayout;
    private View mPatientListLayout;
    private View mStatisticLayout;

    public HomeFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        mDatingManagementLayout = v.findViewById(R.id.homeItemDatingManagementLayout);
        mCalendarCreatingLayout = v.findViewById(R.id.homeItemCalendarCreatingLayout);
        mPatientListLayout = v.findViewById(R.id.homeItemPatientListLayout);
        mStatisticLayout = v.findViewById(R.id.homeItemStatisticLayout);

        // Initialize the home item layout
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getActivity() != null){
            ((HomeActivity) getActivity()).hideFooterSeparator();
            ((HomeActivity) getActivity()).hideHeaderBackButton();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
//        if(getActivity() != null){
//            ((HomeActivity) getActivity()).showFooterSeparator();
//            ((HomeActivity) getActivity()).showHeaderBackButton();
//        }
    }

    @Override
    public void onClick(View v) {
        int parentViewId = (Integer) v.getTag();
        switch(parentViewId){
            case R.id.homeItemDatingManagementLayout:
                break;
            case R.id.homeItemCalendarCreatingLayout:
                break;
            case R.id.homeItemPatientListLayout:
                break;
            case R.id.homeItemStatisticLayout:
                break;
        }
    }
    private void initHomeItemLayout(View parentView, int titleId, int posterId){
        View view = parentView.findViewById(R.id.homeItemLayout);
        view.setTag(parentView.getId());
        view.setOnClickListener(this);

        // Title
        TextView tvTitle = (TextView)parentView.findViewById(R.id.tvHomeItemTitle);
        tvTitle.setText(titleId);
        // Poster
        ImageView ivPoster = (ImageView)parentView.findViewById(R.id.ivHomeItemPoster);
        ivPoster.setImageResource(posterId);
    }

    private IHomeItemOnClickListner mHomeItemOnClickListener = new IHomeItemOnClickListner() {
        @Override
        public void onHomeItemDatingManagementClicked() {

        }

        @Override
        public void onHomeItemCalendarCreatingClicked() {

        }

        @Override
        public void onHomeItemPatientListClicked() {

        }

        @Override
        public void onHomeItemStatisticClicked() {
            
        }
    };
}
