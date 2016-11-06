package pl.rdors.follow_me3;

import android.view.View;

import pl.rdors.follow_me3.view.IMapMovable;
import pl.rdors.follow_me3.view.ViewElements;

import static pl.rdors.follow_me3.view.ViewElements.ANIMATION_TIME;

/**
 * Created by rdors on 2016-11-06.
 */

public class MeetingMap implements ApplicationState {

    private TestActivity activity;
    private ViewElements viewElements;

    public MeetingMap(TestActivity activity, ViewElements viewElements) {
        this.activity = activity;
        this.viewElements = viewElements;
    }

    @Override
    public void init() {
        //hide
        viewElements.buttonNewMeeting.animate()
                .translationY(viewElements.buttonNewMeeting.getHeight() + 20)
                .alpha(0.0f)
                .setDuration(ANIMATION_TIME);
        viewElements.buttonNewMeeting.setVisibility(View.INVISIBLE);

        //show
        viewElements.buttonCheckMark.setVisibility(View.VISIBLE);
        viewElements.buttonCheckMark.animate()
                .translationY(0)
                .alpha(1.0f)
                .setDuration(ANIMATION_TIME);
        viewElements.locationMarkerContainer.setVisibility(View.VISIBLE);

//        mapMovable = new MeetingMapMove(this);
    }

    @Override
    public void animateWhenMapMoveStarted() {
        viewElements.toolbarContainer.animate()
                .translationY(-viewElements.toolbarContainer.getHeight() - 20)
                .alpha(0.0f)
                .setDuration(viewElements.ANIMATION_TIME);
        viewElements.toolbarContainer.setVisibility(View.INVISIBLE);

        viewElements.buttonCheckMark.animate()
                .translationY(viewElements.buttonCheckMark.getHeight() + 20)
                .alpha(0.0f)
                .setDuration(viewElements.ANIMATION_TIME);
        viewElements.buttonCheckMark.setVisibility(View.INVISIBLE);
    }

    @Override
    public void animateWhenMapIdle() {
        viewElements.toolbarContainer.setVisibility(View.VISIBLE);
        viewElements.toolbarContainer.animate()
                .translationY(0)
                .alpha(1.0f)
                .setDuration(viewElements.ANIMATION_TIME);

        viewElements.buttonCheckMark.setVisibility(View.VISIBLE);
        viewElements.buttonCheckMark.animate()
                .translationY(0)
                .alpha(1.0f)
                .setDuration(viewElements.ANIMATION_TIME);
    }
}
