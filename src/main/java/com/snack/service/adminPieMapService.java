package com.snack.service;

import com.snack.model.domain.DoRecord;

import java.util.List;

public interface adminPieMapService {
    List<DoRecord> selectGroupBytype(String startDate, String endDate);
}
