package com.anlu.springmvc.controller;

import com.alibaba.fastjson.JSONObject;
import com.anlu.springmvc.model.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class JsonController {

    private static final Log logger = LogFactory.getLog(JsonController.class);

    @RequestMapping(value = "/index")
    public String toView(){
        return "index";
    }

    // @RequestBody根据json数据，转换成对应的Object
    @RequestMapping(value = "/testRequestBody")
    public void setJson(@RequestBody Book book,
                        HttpServletResponse response) throws Exception {
        // JSONObject-lib包是一个beans,collections,maps,java arrays和xml和JSON互相转换的包。
        // 使用JSONObject将book对象转换成json输出
        logger.info(JSONObject.toJSONString(book));
        book.setAuthor("肖文吉");
        response.setContentType("text/html;charset=UTF-8");
        // 将book对象转换成json写出到客户端
        response.getWriter().println(JSONObject.toJSONString(book));
    }



    @RequestMapping(value = "/getjson")
    @ResponseBody
    public Map getjson() {
        Book book = new Book();
        book.setAuthor("anlu");
        book.setName("dd");
        Map map = new HashMap();
        map.put("book",book);
        return map;
    }
}

