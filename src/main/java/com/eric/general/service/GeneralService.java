package com.eric.general.service;

import com.eric.general.dao.GeneralDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 通用service
 *
 * @author eric
 * @create 2016-09-08 22:37
 **/
@Service
public class GeneralService {
    @Autowired
    private GeneralDao generalDao;

    public Date getGeneralDate(){
        return generalDao.getGeneralDate();
    }
}
