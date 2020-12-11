package com.eleiatech.supplierservice.repository;

import com.eleiatech.supplierservice.repository.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {

    Supplier getBySupplierIdAndDeletedFalse(long supplierId);

    List<Supplier> getAllByDeletedFalse();

    List<Supplier> getByCompanyIdAndDeletedFalse(long companyId);
}
