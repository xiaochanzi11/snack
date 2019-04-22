package com.snack.web;

import com.snack.model.domain.DoRecord;
import com.snack.service.adminPieMapService;
import com.snack.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/map/")
public class adminMapController {

    @Autowired
    private adminPieMapService adminPieMapService;

    @Autowired
    private userService userService;

    //goto图形页面
    @RequestMapping("mainToPieMap")
    public String gotoUserLogin() {
        return "admin/table/pieMap";
    }

    //饼图
    @RequestMapping("adminPieMapList")
    @ResponseBody
    public List<DoRecord> adminPieMapList(String startDate, String endDate) {
        return adminPieMapService.selectGroupBytype(startDate, endDate);
    }

    //柱状图
    @RequestMapping("mainToBar")
    public String gotoEcharts() {
        return "admin/table/echarts";
    }

    @RequestMapping("echarts")
    @ResponseBody
    public List<Integer> echarts() {
        List<Integer> list = userService.echarts();
        return list;
    }


    //china地图分布

    @RequestMapping("mainToChina")
    public String gotoChina() {
        return "admin/table/china";
    }

    @RequestMapping("china")
    @ResponseBody
    public Map china() {
        return userService.UserCount();
    }
}
