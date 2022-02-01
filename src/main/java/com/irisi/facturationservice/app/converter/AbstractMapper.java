package com.irisi.facturationservice.app.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMapper<K, V> {

    public abstract K toPojo(V dto);

    public abstract V toDto(K entity);

    public List<K> toItems(List<V> dtos) {
        if (dtos == null || dtos.isEmpty()) {
            return null;
        } else {
            List<K> items = new ArrayList();
            for (V dto : dtos) {
                items.add(toPojo(dto));
            }
            return items;
        }
    }

    public List<V> toDtos(List<K> entites) {
        if (entites == null || entites.isEmpty()) {
            return null;
        } else {
            List<V> dtos = new ArrayList();
            for (K item : entites) {
                dtos.add(toDto(item));
            }
            return dtos;
        }
    }
}
