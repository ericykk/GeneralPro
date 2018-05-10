package com.eric.general.test;


import com.eric.general.model.VoteUserPO;
import com.eric.general.service.IVoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 描述:
 *
 * @author eric
 * @create 2018-05-10 下午4:08
 */
public class AopTest {
    private static Logger logger = LoggerFactory.getLogger(AopTest.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IVoteService voteService = (IVoteService) applicationContext.getBean("voteService");
        try {
            List<VoteUserPO> voteUserPOList = voteService.getAllVoteUser();
            System.out.println("投票用户总数：" + voteUserPOList.size());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }
}
