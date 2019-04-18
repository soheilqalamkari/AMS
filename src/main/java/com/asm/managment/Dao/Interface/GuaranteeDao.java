package com.asm.managment.Dao.Interface;

import com.asm.managment.Model.Guarantee;
import jdk.internal.dynalink.linker.GuardedTypeConversion;

import java.util.List;

public interface GuaranteeDao {

    void save(Guarantee guarantee);
    Guarantee findById(Long guaranteeId);
    List<Guarantee> findAll();
    void update(Guarantee guarantee);
    void delete(Long guaranteeId);
    void deleteAll();
}
