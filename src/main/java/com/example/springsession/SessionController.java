package com.example.springsession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * SessionController
 *
 * @version 1.0
 * @author: glmapper@leishu
 * @since: 18/11/3 下午3:16
 **/
@RestController
@RequestMapping(value = "/")
public class SessionController {

    @RequestMapping(value = "/session")
    public Map<String, Object> getSession(HttpServletRequest request) {
        Random random = new Random();
        request.getSession().setAttribute("userName" + random.nextInt(100), "glmapper");
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        return map;
    }

    @RequestMapping(value = "/get")
    public String get(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        return userName;
    }
}