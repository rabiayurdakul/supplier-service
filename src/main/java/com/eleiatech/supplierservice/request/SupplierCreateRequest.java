package com.eleiatech.supplierservice.request;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class SupplierCreateRequest {

    private long companyId;
    private String supplierName;
    private String supplierAddress;
    private String supplierTown;
    private String supplierCounty;
    private String supplierCity;
    private String supplierCountry;
    private String supplierPostCode;
    private String supplierPhone;
    private String supplierPhoneSecond;
    private String supplierEmail;
    private String supplierFax;
}
