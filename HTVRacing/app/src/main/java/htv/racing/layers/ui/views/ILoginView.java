package htv.racing.layers.ui.views;

import htv.racing.layers.ui.views.base.IBaseView;

/**
 * Created by phannguyen on 12/7/14.
 */
public interface ILoginView extends IBaseView {
    void LoginOK(String message);
    void LoginFail(String message);
    void ShowIncorrectAccountInfoMessage(String errorMessage);
}
