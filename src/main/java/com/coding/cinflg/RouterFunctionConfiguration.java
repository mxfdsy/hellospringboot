package com.coding.cinflg;

import com.coding.domain.User;
import com.coding.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * Created by 平凡的世界 on 2018/4/26.
 * 路由器函数配置
 * 等同于是一个maperping
 */
//表示是一个配置对象-打上标签后类似于java版的xml
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
     * 定义get请求 ，并且返回所有用户对象的URI URI:/person/find/all
     * flux  是0到n个对象集合
     * mono 是0-1个对象的集合
     * Reactive中的Flux 或者 Mono 是异步处理(非阻塞)
     * 集合对象基本是同步处理
     */

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindALL(UserRespository userRespository) {
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    //返回素有的用户对象
                    Collection<User> users = userRespository.findAll();

                    Flux<User> userFlux = Flux.fromIterable(users);
                    //这个返回看不懂
                    return ServerResponse.ok().body(userFlux, User.class);
                }
        );
    }

}
