package io.github.tanghuibo.httpdebug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * @author tanghuibo
 * @date 19-12-3上午12:28
 */
@RequestMapping("/")
@RestController
public class HttpDebugController {

    Logger log = LoggerFactory.getLogger(HttpDebugController.class);

    @RequestMapping("/**")
    public Mono<HttpDebugResult> debug(ServerHttpRequest request) {
        return request.getBody()
                .map(dataBuffer -> dataBuffer.toString(StandardCharsets.UTF_8))
                .defaultIfEmpty("")
                .reduce((a, b) -> a + b)
                .map(body -> {
                    HttpDebugResult httpDebugResult = new HttpDebugResult();
                    httpDebugResult.setHeaders(request.getHeaders());
                    httpDebugResult.setUrl(request.getURI().toString());
                    httpDebugResult.setMethod(Optional.ofNullable(request.getMethod()).map(Enum::name).orElse(null));
                    httpDebugResult.setBody(body);
                    log.info("receive request:\n==========================================\n{}\n==========================================", httpDebugResult);
                    return httpDebugResult;
                });
    }

    public static class HttpDebugResult {

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

        /**
         * 请求体
         */
        private String body;

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
            return  "url    =====> " + url + '\n' +
                    "method =====> " + method + '\n' +
                    "headers ====> " + headers;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }
}
