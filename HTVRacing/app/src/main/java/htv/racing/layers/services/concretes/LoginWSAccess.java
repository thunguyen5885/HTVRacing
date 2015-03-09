package htv.racing.layers.services.concretes;

import java.net.URI;

import htv.racing.layers.services.AbstractWSAccess;
import htv.racing.layers.services.WSRequest;
import htv.racing.layers.services.models.AuthorizationWSModel;

/**
 * Created by phan on 12/9/2014.
 */
public class LoginWSAccess extends AbstractWSAccess<AuthorizationWSModel> {
    private static final URI LOGIN_URI = URI.create(WEBSERVICE_HOST + "/login");

    @Override
    protected WSRequest buildRequest() {
        return null;
    }

    @Override
    protected AuthorizationWSModel parseResponseBody(String responseBody) throws Exception {
        return null;
    }
}
