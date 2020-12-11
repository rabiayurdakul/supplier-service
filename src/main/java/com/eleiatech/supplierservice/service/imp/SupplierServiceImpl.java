package com.eleiatech.supplierservice.service.imp;

import com.eleiatech.supplierservice.exception.exceptions.DataAlreadyDeletedException;
import com.eleiatech.supplierservice.exception.exceptions.DataNotFoundException;
import com.eleiatech.supplierservice.repository.SupplierRepository;
import com.eleiatech.supplierservice.repository.entity.Supplier;
import com.eleiatech.supplierservice.request.SupplierCreateRequest;
import com.eleiatech.supplierservice.request.SupplierUpdateRequest;
import com.eleiatech.supplierservice.service.ISupplierRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements ISupplierRepositoryService {

    private  final SupplierRepository supplierRepository;

    @Override
    public Supplier createSupplier(SupplierCreateRequest supplierCreateRequest) {
        Supplier supplier = Supplier.builder()
                .companyId(supplierCreateRequest.getCompanyId())
                .supplierName(supplierCreateRequest.getSupplierName())
                .supplierAddress(supplierCreateRequest.getSupplierAddress())
                .supplierTown(supplierCreateRequest.getSupplierTown())
                .supplierCounty(supplierCreateRequest.getSupplierCounty())
                .supplierCity(supplierCreateRequest.getSupplierCity())
                .supplierCountry(supplierCreateRequest.getSupplierCountry())
                .supplierPostCode(supplierCreateRequest.getSupplierPostCode())
                .supplierPhone(supplierCreateRequest.getSupplierPhone())
                .supplierPhoneSecond(supplierCreateRequest.getSupplierPhoneSecond())
                .supplierEmail(supplierCreateRequest.getSupplierEmail())
                .supplierFax(supplierCreateRequest.getSupplierFax())
                .createdDate(new Date())
                .updatedDate(new Date())
                .build();
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier updateSupplier(long supplierId, SupplierUpdateRequest supplierUpdateRequest) {
        Supplier supplier = getSupplier(supplierId);
        supplier.setCompanyId(supplierUpdateRequest.getCompanyId());
        supplier.setSupplierName(supplierUpdateRequest.getSupplierName());
        supplier.setSupplierAddress(supplierUpdateRequest.getSupplierAddress());
        supplier.setSupplierTown(supplierUpdateRequest.getSupplierTown());
        supplier.setSupplierCounty(supplierUpdateRequest.getSupplierCounty());
        supplier.setSupplierCity(supplierUpdateRequest.getSupplierCity());
        supplier.setSupplierCountry(supplierUpdateRequest.getSupplierCountry());
        supplier.setSupplierPostCode(supplierUpdateRequest.getSupplierPostCode());
        supplier.setSupplierPhone(supplierUpdateRequest.getSupplierPhone());
        supplier.setSupplierPhoneSecond(supplierUpdateRequest.getSupplierPhoneSecond());
        supplier.setSupplierEmail(supplierUpdateRequest.getSupplierEmail());
        supplier.setSupplierFax(supplierUpdateRequest.getSupplierFax());
        supplier.setUpdatedDate(new Date());

        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplier(long supplierId) {
        Supplier supplier = supplierRepository.getBySupplierIdAndDeletedFalse(supplierId);

        if(Objects.isNull(supplier)){
            throw new DataNotFoundException("Supplier ","Supplier Id : " + supplierId);
        }
        return supplier;
    }

    @Override
    public List<Supplier> getSuppliersWithCompany(long companyId) {
        List<Supplier> suppliers = supplierRepository.getByCompanyIdAndDeletedFalse(companyId);

        if(suppliers.isEmpty()){
            throw new DataNotFoundException("Company ","Company Id: " + companyId);
        }

        return suppliers;
    }

    @Override
    public List<Supplier> getAllSupplier() {
        List<Supplier> suppliers = supplierRepository.getAllByDeletedFalse();

        if(suppliers.isEmpty()){
            throw new DataNotFoundException("Company ","");
        }

        return suppliers;
    }

    @Override
    public Supplier deleteSupplier(long supplierId) {
       Supplier supplier = getSupplier(supplierId);
       supplier.setUpdatedDate(new Date());
       supplier.setDeleted(true);
        return supplierRepository.save(supplier);
    }

    @Override
    public void deleteSuppliersWithCompany(long companyId) {
        List<Supplier> suppliers;
        try {
            suppliers = getSuppliersWithCompany(companyId);
        }catch (DataNotFoundException dataNotFoundException){
            throw new DataAlreadyDeletedException("Company ", "Company Id: "+companyId);
        }
        suppliers.forEach(args->args.setUpdatedDate(new Date()));
        suppliers.forEach(args->args.setDeleted(true));
        supplierRepository.saveAll(suppliers);


    }
}
