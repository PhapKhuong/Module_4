package com.furama.service.impl;

import com.furama.model.*;
import com.furama.repository.*;
import com.furama.service.itf.IFinalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalService implements IFinalService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Autowired
    private IDivisionRepository divisionRepository;
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;
    @Autowired
    private IPositionRepository positionRepository;
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<CustomerType> findCustomerTypeList() {
        return customerTypeRepository.findAll();
    }

    @Override
    public List<Division> findDivisionList() {
        return divisionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findEducationDegreeList() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public List<Position> findPositionList() {
        return positionRepository.findAll();
    }

    @Override
    public List<RentType> findRentTypeList() {
        return rentTypeRepository.findAll();
    }

    @Override
    public List<Role> findRoleList() {
        return roleRepository.findAll();
    }

    @Override
    public List<ServiceType> findServiceTypeList() {
        return serviceTypeRepository.findAll();
    }
}
