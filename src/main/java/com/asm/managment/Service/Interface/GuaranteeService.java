package com.asm.managment.Service.Interface;

import com.asm.managment.Model.Guarantee;

import java.util.List;

public interface GuaranteeService {

    void saveGuarantee(Guarantee guarantee);
    Guarantee findGuaranteeById(Long guaranteeId);
    List<Guarantee> findAllGuarantees();
    void updateGuarantee(Guarantee guarantee);
    void deleteGuarantee(Long guaranteeId);
    void deleteAllGuarantees();
}
