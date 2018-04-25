package com.eric.general.controller;

import com.eric.general.model.BaseEntity;
import com.eric.general.model.JsonResult;

/**
 * Description:基础控制器
 * author: Eric
 * Date: 18/4/25
 */
public class BaseController {


    public String forward(String page) {
        return "forward:" + page;
    }


    public static JsonResult json(BaseEntity value) {
        return (new JsonResult().put(value));
    }

    public static JsonResult json(String message, BaseEntity value) {
        return ok(message).put(value);
    }

    public JsonResult ok() {
        return ok("");
    }

    public static JsonResult ok(String message) {
        return new JsonResult(JsonResult.STATUS.OK, message);
    }

    public static JsonResult ok(BaseEntity value) {
        return ok("", value);
    }

    public static JsonResult ok(String message, BaseEntity value) {
        return ok(message).put(value);
    }

    public static JsonResult ok(String message, String key, Object value) {
        return (new JsonResult(JsonResult.STATUS.OK, message)).put(key, value);
    }

    public static JsonResult fail() {
        return fail("");
    }

    public static JsonResult fail(String message) {
        return new JsonResult(JsonResult.STATUS.FAIL, message);
    }

    public static JsonResult fail(BaseEntity value) {
        return fail("", value);
    }

    public static JsonResult fail(String key, Object value) {
        return fail("", key, value);
    }

    public static JsonResult fail(String message, String key, Object value) {
        return (new JsonResult(JsonResult.STATUS.FAIL, message)).put(key, value);
    }
}
