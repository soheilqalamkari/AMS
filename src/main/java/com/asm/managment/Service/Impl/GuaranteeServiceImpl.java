package com.asm.managment.Service.Impl;

import com.asm.managment.Dao.Interface.GuaranteeDao;
import com.asm.managment.Model.Guarantee;
import com.asm.managment.Service.Interface.GuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuaranteeServiceImpl implements GuaranteeService {

    @Autowired
    private GuaranteeDao guaranteeDao;

    @Override
    public void saveGuarantee(List<Guarantee> guarantee)
    {
        guaranteeDao.save(guarantee);
    }

    @Override
    public List<Guarantee> findByDuring(Integer during) {
        return guaranteeDao.findByDuring(during);
    }

    @Override
    public List<Guarantee> findAllByNameOrderByDuring(String guaranteeName) {
        return guaranteeDao.findAllByNameOrderByDuring(guaranteeName);
    }

    @Override
    public List<Guarantee> findByNameAndDuring(String guaranteeName, Integer duringTime) {
        return guaranteeDao.findByNameAndDuring(guaranteeName, duringTime);
    }

    @Override
    public Guarantee findGuaranteeById(Long guaranteeId) {
        return guaranteeDao.findById(guaranteeId);
    }

    @Override
    public List<Guarantee> findAllGuaranteesOrderByDuring() {
        return guaranteeDao.findAllOrderByDuring();
    }

    @Override
    public void updateGuarantee(Guarantee guarantee) {
         guaranteeDao.update(guarantee);
    }

    @Override
    public void deleteGuarantee(Long guaranteeId) {
        guaranteeDao.delete(guaranteeId);
    }

    @Override
    public void deleteAllGuarantees() {
        guaranteeDao.deleteAll();
    }
}
