package com.asm.managment.Service.Impl;

import com.asm.managment.Dao.Interface.ProjectDao;
import com.asm.managment.Model.Project;
import com.asm.managment.Service.Interface.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public void save(Project project) {
        projectDao.save(project);
    }

    @Override
    public void update(Project project) {
        projectDao.update(project);
    }

    @Override
    public void delete(Long projectId) {
        projectDao.delete(projectId);
    }

    @Override
    public void deleteAll() {
        projectDao.deleteAll();
    }

    @Override
    public Project findById(Long projectId) {

        return projectDao.findById(projectId);
    }

    @Override
    public List<Project> findAllOrderByBeginDate() {
        return projectDao.findAllOrderByBeginDate();
    }

    @Override
    public List<Project> findAllOrderByEndDate() {
        return projectDao.findAllOrderByEndDate();
    }

    @Override
    public Project findByName(String projectName) {
        return projectDao.findByName(projectName);
    }

    @Override
    public List<Project> findByBeginDate(Date beginDate) {
        return projectDao.findByBeginDate(beginDate);
    }

    @Override
    public List<Project> findByEndDate(Date endDate) {
        return projectDao.findByEndDate(endDate);
    }

    @Override
    public Project findByNameAndBeginDateAndEndDate(String projectName, Date beginDate, Date endDate) {
        return projectDao.findByNameAndBeginDateAndEndDate(projectName,beginDate,endDate);
    }
}
