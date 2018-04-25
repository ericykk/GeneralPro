package com.eric.general.controller;

import com.eric.general.model.JsonResult;
import com.eric.general.service.IVoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 描述:
 * 投票控制器
 *
 * @author eric
 * @create 2018-04-25 下午3:19
 */
@RequestMapping(value = "/vote")
@Controller
public class VoteController extends BaseController {
    @Resource
    private IVoteService voteService;

    @RequestMapping(value = "/getAllVoteUser")
    @ResponseBody
    public JsonResult getAllVoteUser() {
        return ok().put("voteUsers", voteService.getAllVoteUser());
    }
}
