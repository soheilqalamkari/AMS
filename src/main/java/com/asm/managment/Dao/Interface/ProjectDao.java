package com.asm.managment.Dao.Interface;

import com.asm.managment.Model.Project;


import java.util.Date;
import java.util.List;

public interface ProjectDao {

    void save(Project project);
    void update(Project project);
    void delete(Long ProjectId);
    void deleteAll();
    Project findById(Long projectId);
    List<Project> findAllOrderByBeginDate();
    List<Project> findAllOrderByEndDate();
    Project findByName(String projectName);
    List<Project> findByBeginDate(Date beginDate);
    List<Project> findByEndDate(Date beginDate);
    Project findByNameAndBeginDateAndEndDate(String ProjectName,Date beginDate,Date endDate);
}
