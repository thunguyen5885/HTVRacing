package htv.racing.layers.services;

/**
 * Created by phan on 12/9/2014.
 */
import java.util.List;
import java.util.Map;

public class WSResponse {
    /**
     * The HTTP status code
     */
    public int status;

    /**
     * The HTTP headers received in the response
     */
    public  Map<String, List<String>> headers;

    /**
     * The response body, if any
     */
    public byte[] body;

    protected WSResponse(int status,  Map<String, List<String>> headers, byte[] body) {
        this.status = status;
        this.headers = headers;
        this.body = body;
    }
}
