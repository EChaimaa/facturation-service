package com.irisi.facturationservice.app.converter;

import com.irisi.facturationservice.app.dto.FactureDto;
import com.irisi.facturationservice.domain.pojo.FacturePojo;

public class FactureMapper extends AbstractMapper<FacturePojo, FactureDto> {

    @Override
    public FacturePojo toPojo(FactureDto dto) {
        if (dto == null) {
            return null;
        } else {
            FacturePojo item = new FacturePojo();
            item.setId(dto.getId());
            item.setReference(dto.getReference());
            item.setDateFacture(dto.getDateFacture());
            item.setStatus(dto.getStatus());
            item.setProjectRef(dto.getProjectRef());
            item.setClientRef(dto.getClientRef());
            item.setTotal(dto.getTotal());
            item.setPdf(dto.getPdf());
            return item;
        }
    }

    @Override
    public FactureDto toDto(FacturePojo item) {
        if(item == null){
            return null;
        }
        FactureDto dto = new FactureDto();
        dto.setId(item.getId());
        dto.setReference(item.getReference());
        dto.setDateFacture(item.getDateFacture());
        dto.setStatus(item.getStatus());
        dto.setClientRef(item.getClientRef());
        dto.setProjectRef(item.getProjectRef());
        dto.setTotal(item.getTotal());
        dto.setPdf(item.getPdf());
        return dto;
    }
}
