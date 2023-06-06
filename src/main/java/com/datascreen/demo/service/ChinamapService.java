package com.datascreen.demo.service;

import com.datascreen.demo.domain.ChinaMap;
import com.datascreen.demo.mapper.ChinamapMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChinamapService {

        @Resource
        private ChinamapMapper chinamapMapper;
        public List<ChinaMap> list(){
            return  chinamapMapper.list();
        }
    }

