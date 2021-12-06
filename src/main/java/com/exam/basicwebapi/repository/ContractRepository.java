package com.exam.basicwebapi.repository;

import com.exam.basicwebapi.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

    List<Contract> findByCountryIdAndCompanyId(Integer countryId, Integer companyId);
    List<Contract> findByCountryIdOrCompanyId(Integer countryId, Integer companyId);
}