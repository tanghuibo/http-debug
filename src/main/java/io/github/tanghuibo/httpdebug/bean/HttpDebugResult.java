package io.github.tanghuibo.httpdebug.bean;

import java.util.List;
import java.util.Map;

/**
 * @author tanghuibo
 * @date 19-12-3上午12:44
 */
public class HttpDebugResult {

    /**
     * 地址
     */
    private String url;

    /**
     * 头信息
     */
    private Map<String, List<String>> headers;

    /**
     * 方法
     */
    private String method;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return  "url========> " + url + '\n' +
                "method=====> " + method + '\n' +
                "headers====> " + headers;
    }
}
