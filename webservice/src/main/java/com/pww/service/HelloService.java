package com.pww.service;

import javax.jws.WebService;

/**
 * 对外发布服务的接口
 */
@WebService
public interface HelloService {
    String sayHello(String hello);

}
