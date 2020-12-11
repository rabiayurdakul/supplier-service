package com.eleiatech.supplierservice.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponse {

    private long supplierId;
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
    private Date createdDate;
    private Date updatedDate;
}
