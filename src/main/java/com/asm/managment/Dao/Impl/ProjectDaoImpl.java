package com.asm.managment.Dao.Impl;

import com.asm.managment.Dao.Interface.ProjectDao;
import com.asm.managment.Model.Project;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
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
    public void delete(Long projectId) {
        try {
            entityManager.remove(findById(projectId));
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public void deleteAll() {
        try {
            Query query = entityManager.createQuery("delete from Project");
            query.executeUpdate();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public Project findById(Long projectId) {
        try {
           return entityManager.find(Project.class, projectId);
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Project> findAllOrderByBeginDate() {
        try {
             Query query = entityManager.createQuery("select p from Project p order by p.beginDate desc",Project.class);
             return query.getResultList();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public List<Project> findAllOrderByEndDate() {
        try {
            Query query = entityManager.createQuery("select p from Project p order by p.endDate desc",Project.class);
            return query.getResultList();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Project findByName(String projectName) {
        try {
            Project project = entityManager.createQuery("select p from Project p where p.projectName=:projectName", Project.class)
                    .setParameter("projectName", projectName)
                    .getSingleResult();
            return project;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public List<Project> findByBeginDate(Date beginDate) {
        try {
            Query query = entityManager.createQuery("select p from Project p where p.beginDate=:beginDate",Project.class)
                    .setParameter("beginDate",beginDate);
            return query.getResultList();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public List<Project> findByEndDate(Date endDate) {
        try {
            Query query = entityManager.createQuery("select p from Project p where p.endDate=:endDate",Project.class)
                    .setParameter("endDate",endDate);
            return query.getResultList();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Project findByNameAndBeginDateAndEndDate(String projectName, Date beginDate, Date endDate) {
        try {
            Project project = entityManager.createQuery("select p from Project p where p.projectName=:projectName and p.beginDate=:beginDate and p.endDate=:endDate", Project.class)
                    .setParameter("projectName", projectName)
                    .setParameter("beginDate",beginDate)
                    .setParameter("endDate",endDate)
                    .getSingleResult();
            return project;
        }catch (NoResultException e){
            return null;
        }
    }
}
