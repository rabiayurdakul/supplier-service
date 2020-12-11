package com.eleiatech.supplierservice.controller;

import com.eleiatech.supplierservice.repository.entity.Supplier;
import com.eleiatech.supplierservice.request.SupplierCreateRequest;
import com.eleiatech.supplierservice.request.SupplierUpdateRequest;
import com.eleiatech.supplierservice.response.InternalApiResponse;
import com.eleiatech.supplierservice.response.SupplierResponse;
import com.eleiatech.supplierservice.service.ISupplierRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final ISupplierRepositoryService supplierRepositoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create")
    public InternalApiResponse<SupplierResponse> createSupplier(@RequestBody SupplierCreateRequest supplierCreateRequest){
        Supplier supplier = supplierRepositoryService.createSupplier(supplierCreateRequest);

        SupplierResponse supplierResponse = SupplierResponse.builder()
                .companyId(supplier.getCompanyId())
                .supplierName(supplier.getSupplierName())
                .supplierAddress(supplier.getSupplierAddress())
                .supplierTown(supplier.getSupplierTown())
                .supplierCounty(supplier.getSupplierCounty())
                .supplierCity(supplier.getSupplierCity())
                .supplierCountry(supplier.getSupplierCountry())
                .supplierPostCode(supplier.getSupplierPostCode())
                .supplierPhone(supplier.getSupplierPhone())
                .supplierPhoneSecond(supplier.getSupplierPhoneSecond())
                .supplierEmail(supplier.getSupplierEmail())
                .supplierFax(supplier.getSupplierFax())
                .createdDate(supplier.getCreatedDate())
                .updatedDate(supplier.getUpdatedDate())
                .build();
        return InternalApiResponse.<SupplierResponse>builder()
                .hasError(false)
                .httpStatus(HttpStatus.CREATED)
                .payload(supplierResponse)
                .build();

    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/update/{supplierId}")
    public InternalApiResponse<SupplierResponse> updateSupplier(@PathVariable("supplierId") long supplierId, @RequestBody SupplierUpdateRequest supplierUpdateRequest){
        Supplier supplier = supplierRepositoryService.updateSupplier(supplierId,supplierUpdateRequest);

        SupplierResponse supplierResponse = SupplierResponse.builder()
                .companyId(supplier.getCompanyId())
                .supplierName(supplier.getSupplierName())
                .supplierAddress(supplier.getSupplierAddress())
                .supplierTown(supplier.getSupplierTown())
                .supplierCounty(supplier.getSupplierCounty())
                .supplierCity(supplier.getSupplierCity())
                .supplierCountry(supplier.getSupplierCountry())
                .supplierPostCode(supplier.getSupplierPostCode())
                .supplierPhone(supplier.getSupplierPhone())
                .supplierPhoneSecond(supplier.getSupplierPhoneSecond())
                .supplierEmail(supplier.getSupplierEmail())
                .supplierFax(supplier.getSupplierFax())
                .createdDate(supplier.getCreatedDate())
                .updatedDate(supplier.getUpdatedDate())
                .build();

        return InternalApiResponse.<SupplierResponse>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload(supplierResponse)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/get/{supplierId}")
    public InternalApiResponse<SupplierResponse> getSupplier(@PathVariable("supplierId") long supplierId){
        Supplier supplier = supplierRepositoryService.getSupplier(supplierId);

        SupplierResponse supplierResponse = SupplierResponse.builder()
                .companyId(supplier.getCompanyId())
                .supplierName(supplier.getSupplierName())
                .supplierAddress(supplier.getSupplierAddress())
                .supplierTown(supplier.getSupplierTown())
                .supplierCounty(supplier.getSupplierCounty())
                .supplierCity(supplier.getSupplierCity())
                .supplierCountry(supplier.getSupplierCountry())
                .supplierPostCode(supplier.getSupplierPostCode())
                .supplierPhone(supplier.getSupplierPhone())
                .supplierPhoneSecond(supplier.getSupplierPhoneSecond())
                .supplierEmail(supplier.getSupplierEmail())
                .supplierFax(supplier.getSupplierFax())
                .createdDate(supplier.getCreatedDate())
                .updatedDate(supplier.getUpdatedDate())
                .build();

        return InternalApiResponse.<SupplierResponse>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload(supplierResponse)
                .build();

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getAll")
    public InternalApiResponse<List<SupplierResponse>> getAllSuppliers(){
        List<Supplier> supplierList = supplierRepositoryService.getAllSupplier();

        List<SupplierResponse> supplierResponses = supplierList.stream()
                .map(arg-> SupplierResponse.builder()
                        .companyId(arg.getCompanyId())
                        .supplierName(arg.getSupplierName())
                        .supplierAddress(arg.getSupplierAddress())
                        .supplierTown(arg.getSupplierTown())
                        .supplierCounty(arg.getSupplierCounty())
                        .supplierCity(arg.getSupplierCity())
                        .supplierCountry(arg.getSupplierCountry())
                        .supplierPostCode(arg.getSupplierPostCode())
                        .supplierPhone(arg.getSupplierPhone())
                        .supplierPhoneSecond(arg.getSupplierPhoneSecond())
                        .supplierEmail(arg.getSupplierEmail())
                        .supplierFax(arg.getSupplierFax())
                        .createdDate(arg.getCreatedDate())
                        .updatedDate(arg.getUpdatedDate())
                        .build())
                .collect(Collectors.toList());
        return InternalApiResponse.<List<SupplierResponse>>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload(supplierResponses)
                .build();

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/get/{companyId}/company")
    public InternalApiResponse<List<SupplierResponse>> getSuppliersWithCompany(@PathVariable("companyId") long companyId){
        List<Supplier> supplierList = supplierRepositoryService.getSuppliersWithCompany(companyId);

        List<SupplierResponse> supplierResponses = supplierList.stream()
                .map(arg-> SupplierResponse.builder()
                        .companyId(arg.getCompanyId())
                        .supplierName(arg.getSupplierName())
                        .supplierAddress(arg.getSupplierAddress())
                        .supplierTown(arg.getSupplierTown())
                        .supplierCounty(arg.getSupplierCounty())
                        .supplierCity(arg.getSupplierCity())
                        .supplierCountry(arg.getSupplierCountry())
                        .supplierPostCode(arg.getSupplierPostCode())
                        .supplierPhone(arg.getSupplierPhone())
                        .supplierPhoneSecond(arg.getSupplierPhoneSecond())
                        .supplierEmail(arg.getSupplierEmail())
                        .supplierFax(arg.getSupplierFax())
                        .createdDate(arg.getCreatedDate())
                        .updatedDate(arg.getUpdatedDate())
                        .build())
                .collect(Collectors.toList());
        return InternalApiResponse.<List<SupplierResponse>>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload(supplierResponses)
                .build();

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/delete/{supplierId}/supplier")
    public InternalApiResponse<SupplierResponse> deleteSupplier(@PathVariable("supplierId") long supplierId){
        Supplier supplier = supplierRepositoryService.deleteSupplier(supplierId);

        SupplierResponse supplierResponse = SupplierResponse.builder()
                .companyId(supplier.getCompanyId())
                .supplierName(supplier.getSupplierName())
                .supplierAddress(supplier.getSupplierAddress())
                .supplierTown(supplier.getSupplierTown())
                .supplierCounty(supplier.getSupplierCounty())
                .supplierCity(supplier.getSupplierCity())
                .supplierCountry(supplier.getSupplierCountry())
                .supplierPostCode(supplier.getSupplierPostCode())
                .supplierPhone(supplier.getSupplierPhone())
                .supplierPhoneSecond(supplier.getSupplierPhoneSecond())
                .supplierEmail(supplier.getSupplierEmail())
                .supplierFax(supplier.getSupplierFax())
                .createdDate(supplier.getCreatedDate())
                .updatedDate(supplier.getUpdatedDate())
                .build();

        return InternalApiResponse.<SupplierResponse>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload(supplierResponse)
                .build();

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/delete/{companyId}/company")
    public InternalApiResponse<String> deleteSupplierWithCompany(@PathVariable("companyId") long companyId){
        supplierRepositoryService.deleteSuppliersWithCompany(companyId);

        return InternalApiResponse.<String>builder()
                .hasError(false)
                .httpStatus(HttpStatus.OK)
                .payload("Deleted")
                .build();

    }

}
