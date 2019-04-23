package com.asm.managment.Dao.Interface;

import com.asm.managment.Model.Guarantee;
import jdk.internal.dynalink.linker.GuardedTypeConversion;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface GuaranteeDao {

    void save(List<Guarantee> guarantee);
    Guarantee findById(Long guaranteeId);
    List<Guarantee> findByDuring(Integer during);
    List<Guarantee> findAllByNameOrderByDuring(String guaranteeName);
    List<Guarantee> findAllOrderByDuring();
    List<Guarantee> findByNameAndDuring(String guaranteeName, Integer duringTime);
    void update(Guarantee guarantee);
    void delete(Long guaranteeId);
    void deleteAll();
}
