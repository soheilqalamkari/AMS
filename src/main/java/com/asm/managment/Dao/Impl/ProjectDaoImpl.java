package com.asm.managment.Dao.Impl;

import com.asm.managment.Dao.Interface.ProjectDao;
import com.asm.managment.Model.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.RollbackException;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Project project)  {
        try {
            entityManager.persist(project);
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

    @Override
    public void update(Project project) {
        try {
            Project currentProject = findById(project.getProjectId());
            currentProject.setName(project.getName());
            currentProject.setBeginDate(project.getBeginDate());
            currentProject.setEndDate(project.getEndDate());
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

    @Override
    public void delete(Long ProjectId) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Project findById(Long projectId) {
        return null;
    }

    @Override
    public List<Project> findAllOrderByBeginDate() {
        return null;
    }

    @Override
    public List<Project> findAllOrderByEndDate() {
        return null;
    }

    @Override
    public Project findByName(String projectName) {
        return null;
    }

    @Override
    public List<Project> findByBeginDate(Date beginDate) {
        return null;
    }

    @Override
    public List<Project> findByEndDate(Date beginDate) {
        return null;
    }

    @Override
    public Project findByNameAndBeginDateAndEndDate(String ProjectName, Date beginDate, Date endDate) {
        return null;
    }
}
