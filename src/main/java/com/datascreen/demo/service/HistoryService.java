package com.datascreen.demo.service;

import com.datascreen.demo.domain.History;
import com.datascreen.demo.mapper.HistoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HistoryService {
    @Resource
    private HistoryMapper historyMapper;
    public List<History> list(){
        return historyMapper.list();
    }
}
