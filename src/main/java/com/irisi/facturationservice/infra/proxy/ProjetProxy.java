package com.irisi.facturationservice.infra.proxy;

import com.irisi.facturationservice.domain.pojo.ProjetPojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROJET-SERVICE")
public interface ProjetProxy {
    @GetMapping("/api/v1/projet/ref/{ref}")
    ProjetPojo findByReference(@PathVariable String ref);

}
