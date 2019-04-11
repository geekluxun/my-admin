package com.geekluxun.myadmin.workflow.service;

import com.geekluxun.myadmin.workflow.dto.BaseRequestDto;
import com.geekluxun.myadmin.workflow.dto.BaseResponsDto;
import org.springframework.stereotype.Service;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-04-11 13:38
 * @Description:
 * @Other:
 */
@Service
public class AntiFraudServiceImpl implements AntiFraudService {
    @Override
    public BaseResponsDto antiFraud(BaseRequestDto requestDto) {
        return new BaseResponsDto();
    }
}
