# HTTP DEBUG
http调试工具,使用 `webflux`

## 功能
从服务器视角看请求；服务器收到请求后，返回本次请求的`url`, `header`, `method`，并且会记录日志。

## demo
浏览器访问 http://127.0.0.1:8080/test

收到响应:
```json
{
	"url": "http://127.0.0.1:8080/test",	
	"method": "GET",
	"headers": {
		"Host": ["127.0.0.1:8080"],
		"Connection": ["keep-alive"],
		"Cache-Control": ["max-age=0"],
		"Upgrade-Insecure-Requests": ["1"],
		"User-Agent": ["Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"],
		"Accept": ["text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"],
		"Accept-Encoding": ["gzip, deflate, br"],
		"Accept-Language": ["zh-CN,zh;q=0.9"]
	}
}
```