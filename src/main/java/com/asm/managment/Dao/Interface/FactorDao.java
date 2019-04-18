package com.asm.managment.Dao.Interface;

import com.asm.managment.Model.Factor;

import java.util.Date;
import java.util.List;

public interface FactorDao {

    void save(Factor factor);
    Factor findFactorById(Long factorId);
    List<Factor> findFactors();
    List<Factor> findFactorsByDate(Date date);
    void update(Factor factor);
    void delete(Long factor);
    void deleteAll();

}
