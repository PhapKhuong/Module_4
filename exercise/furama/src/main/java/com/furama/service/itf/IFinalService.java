package com.furama.service.itf;

import com.furama.model.*;

import java.util.List;

public interface IFinalService {
    List<CustomerType> findCustomerTypeList();
    List<Division> findDivisionList();
    List<EducationDegree> findEducationDegreeList();
    List<Position> findPositionList();
    List<RentType> findRentTypeList();
    List<Role> findRoleList();
    List<ServiceType> findServiceTypeList();
}
