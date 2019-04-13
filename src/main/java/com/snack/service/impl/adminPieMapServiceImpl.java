package com.snack.service.impl;

import com.snack.mapper.RecordMapper;
import com.snack.model.domain.DoRecord;
import com.snack.service.adminPieMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class adminPieMapServiceImpl implements adminPieMapService {

    @Autowired
    private RecordMapper recordDao;

    @Override
    public List<DoRecord> selectGroupBytype(String startDate, String endDate) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        return recordDao.selectGroupBytype(map);
    }

}
