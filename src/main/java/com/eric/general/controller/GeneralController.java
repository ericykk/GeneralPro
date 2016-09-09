package com.eric.general.controller;

import com.eric.general.common.JsonResult;
import com.eric.general.service.GeneralService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通用控制器
 *
 * @author eric
 * @create 2016-09-08 22:39
 **/
@Controller
@RequestMapping(value = "/general")
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    /**
     * 获取当前时间
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getDate",method = RequestMethod.GET)
    public JsonResult getCurrentDate(){
        Date currentDate = generalService.getGeneralDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new JsonResult(JsonResult.STATUS.OK,sdf.format(currentDate));
    }
}
