package com.geekluxun.myadmin.workflow.controller;

import io.swagger.annotations.ApiOperation;
import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-04-08 17:56
 * @Description:
 * @Other:
 */
@RestController
@RequestMapping("/activiti/history")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    /**
     * 已完成的工作流
     * @return
     */
    @GetMapping("/completed")
    @ApiOperation(value = "已完成的工作流")
    public Object queryCompleted(){
//        List<HistoricProcessInstance> historyList = historyService.createHistoricProcessInstanceQuery()
//                .finished()
//                .processDefinitionId("myProcess:2:15004")
//                .orderByProcessInstanceDuration().desc()
//                .listPage(0, 10);

        List<HistoricProcessInstance> historyList = historyService.createHistoricProcessInstanceQuery()
            .finished()
            .processDefinitionKey("myProcess")
            .orderByProcessInstanceDuration().desc()
            .listPage(0, 10);
        
        return historyList;
    }

    @GetMapping("/uncompleted")
    @ApiOperation(value = "未完成的工作流")
    public Object queryUnCompleted(){
//        List<HistoricProcessInstance> historyList = historyService.createHistoricProcessInstanceQuery()
//                .unfinished()
//                .processDefinitionId("myProcess:2:15004")
//                .orderByProcessInstanceDuration().desc()
//                .listPage(0, 10);

        List<HistoricProcessInstance> historyList = historyService.createHistoricProcessInstanceQuery()
                .unfinished()
                .processDefinitionKey("myProcess")
                .orderByProcessInstanceDuration().desc()
                .listPage(0, 10);

        return historyList;
    }
}
