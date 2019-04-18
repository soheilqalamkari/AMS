package com.asm.managment.Service.Interface;

import com.asm.managment.Model.Factor;

import java.util.Date;
import java.util.List;

public interface FactorService {
    void save(Factor factor);
    Factor findFactorById(Long factorId);
    List<Factor> findFactors();
    List<Factor> findFactorsByDate(Date date);
    void updateFactor(Factor factor);
    void deleteFactor(Long factor);
    void deleteAllFactors();
}
