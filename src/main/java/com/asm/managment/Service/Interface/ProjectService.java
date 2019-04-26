package com.asm.managment.Service.Interface;

import com.asm.managment.Model.Project;

import java.util.Date;
import java.util.List;

public interface  ProjectService {
    void save(Project project);
    void update(Project project);
    void delete(Long projectId);
    void deleteAll();
    Project findById(Long projectId);
    List<Project> findAll();
    List<Project> findAllOrderByBeginDate();
    List<Project> findAllOrderByEndDate();
    Project findByName(String projectName);
    List<Project> findByBeginDate(Date beginDate);
    List<Project> findByEndDate(Date endDate);
    Project findByNameAndBeginDateAndEndDate(String projectName,Date beginDate,Date endDate);
}
