package com.irisi.facturationservice.infra.proxy;

import com.irisi.facturationservice.domain.pojo.ProjetMemberPojo;
import com.irisi.facturationservice.domain.pojo.ProjetPojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MS-PROJET")
public interface ProjetProxy {

    @GetMapping("/api/v1/gestion-projet/projets/{refProjet}")
    ProjetPojo findByReference(@PathVariable String refProjet);

    @GetMapping("/api/v1/gestion-projet/projets-members/{refProjet}")
    List<ProjetMemberPojo> findProjetMembersByProject(@PathVariable String refProjet);
}
