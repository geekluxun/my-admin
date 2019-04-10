package com.geekluxun.myadmin.workflow.controller;

import io.swagger.annotations.ApiOperation;
import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.task.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
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


    @GetMapping("/userTaskByProcessInstanceId")
    @ApiOperation(value = "所有某个流程实例的所有人工节点")
    public Object queryProcessInstanceTrace(@RequestParam("processInstanceId") String processInstanceId){

        List<HistoricActivityInstance> historyList = historyService.createHistoricActivityInstanceQuery().activityType("userTask").processInstanceId(processInstanceId).list();
        return historyList;
    }

    @GetMapping("/byProcessInstanceId")
    @ApiOperation(value = "所有某个流程实例的所有节点")
    public Object queryProcessInstanceTrace2(@RequestParam("processInstanceId") String processInstanceId){
        List<HistoricActivityInstance> historyList = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).orderByHistoricActivityInstanceStartTime().desc().list();
        return historyList;
    }
    
    
    @GetMapping("/byTaskId")
    @ApiOperation(value = "查询某个任务")
    public Object queryTask(@RequestParam("taskId") String taskId){
        TaskInfo taskInfo = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
        return  taskInfo;
    }

    
    @GetMapping("/ActivityByUserId")
    @ApiOperation(value = "查询分配给某人的所有活动")
    public Object queryActivityByUserId(@RequestParam("userId") String userId){
        List<HistoricActivityInstance> activityInstances = historyService.createHistoricActivityInstanceQuery().taskAssignee(userId).list();
        return  activityInstances;
    }
    
}
