package com.eleiatech.supplierservice.service;

import com.eleiatech.supplierservice.repository.entity.Supplier;
import com.eleiatech.supplierservice.request.SupplierCreateRequest;
import com.eleiatech.supplierservice.request.SupplierUpdateRequest;

import java.util.List;

public interface ISupplierRepositoryService {

    Supplier createSupplier(SupplierCreateRequest supplierCreateRequest);

    Supplier updateSupplier(long supplierId, SupplierUpdateRequest supplierUpdateRequest);

    Supplier getSupplier(long supplierId);

    List<Supplier> getSuppliersWithCompany(long companyId);

    List<Supplier> getAllSupplier();

    Supplier deleteSupplier(long supplierId);

    void deleteSuppliersWithCompany(long companyId);

}
