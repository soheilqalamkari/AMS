package com.asm.managment.Service.Interface;

import com.asm.managment.Model.Guarantee;

import java.util.List;

public interface GuaranteeService {

    void saveGuarantee(List<Guarantee> guarantee);
    Guarantee findGuaranteeById(Long guaranteeId);
    List<Guarantee> findAllGuaranteesOrderByDuring();
    List<Guarantee> findByDuring(Integer during);
    List<Guarantee> findAllByNameOrderByDuring(String guaranteeName);
    List<Guarantee> findByNameAndDuring(String guaranteeName, Integer duringTime);
    void updateGuarantee(Guarantee guarantee);
    void deleteGuarantee(Long guaranteeId);
    void deleteAllGuarantees();
}
