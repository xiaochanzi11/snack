package com.snack.service.impl;

import com.snack.mapper.SnackinfoMapper;
import com.snack.mapper.UserinfoMapper;
import com.snack.model.Snackinfo;
import com.snack.model.Userinfo;
import com.snack.model.domain.DoSnack;
import com.snack.service.shopService;
import com.snack.utils.DateUtil;
import com.snack.utils.PageHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class shopServiceImpl implements shopService {

    @Autowired
    private SnackinfoMapper snackinfoDao;

    @Autowired
    private UserinfoMapper userinfoDao;

    //查询热销商品
    @Override
    public List<Snackinfo> getHotSnack() {
        Map<String, String> map = new HashMap<String, String>();
        Calendar cal = Calendar.getInstance();
        Date firstDayOfMonth = DateUtil.getFirstDayOfMonth(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
        Date lastDayOfMonth = DateUtil.getLastDayOfMonth(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
        map.put("dateone", DateUtil.getDateString(firstDayOfMonth));
        map.put("datetwo", DateUtil.getDateString(lastDayOfMonth));
        List<Snackinfo> hotList = snackinfoDao.selectHot(map);
        return hotList;
    }

    //查询最新商品
    @Override
    public List<Snackinfo> getNewSnack() {
        List<Snackinfo> newlist = snackinfoDao.selectNew();
        return newlist;
    }

    @Override
    public Userinfo userLogin(Userinfo userinfo) {
        return userinfoDao.selectUserLogin(userinfo);
    }

    @Override
    public Snackinfo selectById(Snackinfo snackinfo) {
        return snackinfoDao.selectByPrimaryKey(snackinfo.getsId());
    }

    @Override
    public PageHelp<DoSnack> selectOrderSnack(Map<Object, Object> map) {
        PageHelp<DoSnack> pageUtil = new PageHelp<DoSnack>();
        List<DoSnack> selectOrderSnack = snackinfoDao.selectOrderSnack(map);
        pageUtil.setList(selectOrderSnack);
        pageUtil.setRecord(selectOrderSnack.size());
        return pageUtil;
    }

    @Override
    public List<Snackinfo> selectPuffing(int type, String snackName) {
        Map<String, String> map = new HashMap<String, String>();
        if (type == 1) {
            map.put("typeName", "膨化类");
        } else if (type == 2) {
            map.put("typeName", "肉制类");
        } else if (type == 3) {
            map.put("typeName", "饮料类");
        } else if (type == 4) {
            map.put("typeName", "其他");
        } else if (type == 5) {
            map.put("typeName", null);
        } else if (type == 6) {
            map.put("sImported", "1");
        }
        map.put("snackName", snackName);
        return snackinfoDao.selectPuffing(map);
    }

}
