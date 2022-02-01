package com.irisi.facturationservice.infra.converter;

import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.infra.entity.FactureEntity;

public class FactureConverter extends AbstractConverter<FacturePojo, FactureEntity> {
    @Override
    public FacturePojo toPojo(FactureEntity dto) {
        if (dto == null) {
            return null;
        } else {
            FacturePojo item = new FacturePojo();
            item.setId(dto.getId());
            item.setReference(dto.getReference());
            item.setDateFacture(dto.getDateFacture());
            item.setStatus(dto.getStatus());
            item.setClientRef(dto.getClientRef());
            item.setProjectRef(dto.getProjectRef());
            item.setTotal(dto.getTotal());
            item.setPdf(dto.getPdf());
            return item;
        }
    }

    @Override
    public FactureEntity toEntity(FacturePojo item) {
        if (item == null) {
            return null;
        } else {
            FactureEntity dto = new FactureEntity();
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
}
