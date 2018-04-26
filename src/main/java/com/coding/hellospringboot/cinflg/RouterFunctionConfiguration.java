package com.coding.hellospringboot.cinflg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Created by 平凡的世界 on 2018/4/26.
 * 路由器函数配置
 * 等同于是一个maperping
 */
//打上标签后类似于java版的xml
@Configuration
public class RouterFunctionConfiguration {
    /**
     * Servlet
     * 请求接口 ServletRequsest 或者httpServletRequest
     * 响应接口 ServletResponse 或者 HttpServletReponse
     * Sping 5.0 重新定义服务端的请求和响应接口
     * 请求接口 ServerRequest
     * 响应接口 ServerReponse
     * 且对以前的接口保留支持
     * 本例
     * 定义get请求 ，并且返回所有用户对象的URI
     */

    @Bean
    public RouterFunction<ServerResponse>

}
