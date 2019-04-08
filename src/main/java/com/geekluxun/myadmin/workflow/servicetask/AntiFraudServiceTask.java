package com.geekluxun.myadmin.workflow.servicetask;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-04-08 15:15
 * @Description:
 * @Other:
 */
@Slf4j
public class AntiFraudServiceTask implements JavaDelegate {
    
    @Override
    public void execute(DelegateExecution delegateExecution) {
        log.info("开始执行反欺诈....");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("执行反欺诈完成....");
        delegateExecution.setVariable("result", "true");
    }
}
