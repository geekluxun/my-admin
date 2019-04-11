package com.geekluxun.myadmin.workflow.listener.execute;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-12-19 10:02
 * @Description:
 * @Other:
 */
@Slf4j
public class DefaultExecuteListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution delegateExecution) {
        log.info("当前执行所有信息：" + getExecutionInfo(delegateExecution));
        switch (delegateExecution.getEventName()) {
            case EVENTNAME_START: {
                log.info("======执行开始======" + delegateExecution.getCurrentActivityId());
                break;
            }
            case EVENTNAME_TAKE: {
                log.info("======执行take======" + delegateExecution.getCurrentActivityId());
                break;
            }
            case EVENTNAME_END: {
                log.info("======执行结束======" + delegateExecution.getCurrentActivityId());
                String result = (String) delegateExecution.getVariable("result");
                break;
            }
            default: {
                log.info("======执行其他状态======" + delegateExecution.getCurrentActivityId());
                break;
            }
        }
    }

    /**
     * 获取执行相关信息
     *
     * @param execution
     * @return
     */
    private Map getExecutionInfo(DelegateExecution execution) {
        Map paras = new HashMap(10);
        paras.put("CurrentActivityId", execution.getCurrentActivityId());
        paras.put("ExecutionId:", execution.getId());
        paras.put("CurrentFlowElement", execution.getCurrentFlowElement());
        paras.put("EventName", execution.getEventName());
        paras.put("loadApplyId", execution.getVariable("loadApplyId"));
        return paras;
    }
}
