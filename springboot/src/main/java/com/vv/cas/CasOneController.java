package com.vv.cas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CasOneController {
    @RequestMapping("/casone")
    public String hello() {
        return "cas one";
    }
}
