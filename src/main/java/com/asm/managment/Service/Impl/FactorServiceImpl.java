package com.asm.managment.Service.Impl;

import com.asm.managment.Dao.Interface.FactorDao;
import com.asm.managment.Model.Factor;
import com.asm.managment.Service.Interface.FactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FactorServiceImpl implements FactorService {

    @Autowired
    private FactorDao factorDao;

    @Override
    public void save(Factor factor) {
        factorDao.save(factor);
    }

    @Override
    public Factor findFactorById(Long factorId) {
        return factorDao.findFactorById(factorId);
    }

    @Override
    public List<Factor> findFactorsBySupplier(Long supplierId) {
        return factorDao.findFactorsBySupplier(supplierId);
    }

    @Override
    public List<Factor> findFactors() {
        return factorDao.findFactors();
    }

    @Override
    public List<Factor> findFactorsByDate(Date date) {
        return factorDao.findFactorsByDate(date);
    }

    @Override
    public void updateFactor(Factor factor) {
         factorDao.update(factor);
    }

    @Override
    public void deleteFactor(Long factorId) {
        factorDao.delete(factorId);
    }

    @Override
    public void deleteAllFactors() {
        factorDao.deleteAll();
    }
}
