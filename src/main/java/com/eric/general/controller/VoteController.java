package com.eric.general.controller;

import com.eric.general.core.annotation.SystemLog;
import com.eric.general.model.JsonResult;
import com.eric.general.service.IVoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/getAllVoteUser", method = RequestMethod.GET)
    public String getAllVoteUser(HttpSession session) {
        session.setAttribute("user", voteService.getAllVoteUser().get(0));
        return "redirect:/vote/getVoteUser";
    }

    @SystemLog(description = "查询投票用户信息")
    @RequestMapping(value = "/getVoteUser", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getVoteUser(HttpSession session) {
        return ok().put("user", session.getAttribute("user"));
    }
}
