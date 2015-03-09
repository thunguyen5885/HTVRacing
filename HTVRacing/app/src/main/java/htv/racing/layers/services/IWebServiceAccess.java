package htv.racing.layers.services;

import java.util.List;
import java.util.Map;

/**
 * Created by phannguyen on 12/7/14.
 */

public interface IWebServiceAccess<T extends IWebServiceModel> {
    static final String WEBSERVICE_HOST = "https://easycare.vn/api/";
    WSResult<T> executeRequest();
    Map<String, List<String>> getHeaders();
    void setHeaders(Map<String, List<String>> headers);
}
