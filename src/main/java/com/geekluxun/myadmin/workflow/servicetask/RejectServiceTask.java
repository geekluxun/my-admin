package com.geekluxun.myadmin.workflow.servicetask;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-04-09 15:31
 * @Description:
 * @Other:
 */
@Slf4j
public class RejectServiceTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        log.info("执行工单拒绝....");
    }
}
