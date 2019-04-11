package com.geekluxun.myadmin.workflow.service;

import com.geekluxun.myadmin.workflow.dto.BaseRequestDto;
import com.geekluxun.myadmin.workflow.dto.BaseResponsDto;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-04-11 13:37
 * @Description:
 * @Other:
 */
public interface AntiFraudService {
    /**
     * 示例
     *
     * @param requestDto
     * @return
     */
    BaseResponsDto antiFraud(BaseRequestDto requestDto);
}
