package io.github.tanghuibo.httpdebug;

import io.github.tanghuibo.httpdebug.bean.HttpDebugResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;


/**
 * @author tanghuibo
 * @date 19-12-3上午12:28
 */
@RequestMapping("/")
@RestController
public class HttpDebugController {

    @RequestMapping("/**")
    public HttpDebugResult debug(ServerHttpRequest request) {
        HttpDebugResult httpDebugResult = new HttpDebugResult();
        httpDebugResult.setHeaders(request.getHeaders());
        httpDebugResult.setUrl(request.getURI().toString());
        httpDebugResult.setMethod(Optional.ofNullable(request.getMethod()).map(Enum::name).orElse(null));
        System.out.println(httpDebugResult);
        System.out.println("====================\n\n\n\n");
        return httpDebugResult;
    }
}
