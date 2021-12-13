package com.irisi.facturationservice.app.ws;

import com.irisi.facturationservice.infra.facade.PaiementInfra;
import com.irisi.facturationservice.infra.entity.PaiementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@Api("Gestion de paiement")
@RestController
@RequestMapping("/api/v1/paiement")
public class PaiementRest {
    @Autowired
    PaiementInfra paiementInfra;

    //@ApiOperation(("Enregistrer un nouveau paiement"))
    @PostMapping("/")
    public int save(@RequestBody PaiementEntity paiement) {
        return paiementInfra.save(paiement);
    }

    //@ApiOperation(("Modifier un paiement existant"))
    @PutMapping("/")
    public int update(@RequestBody PaiementEntity paiement) {
        return paiementInfra.update(paiement);
    }

    //@ApiOperation(("Supprimer un paiement existant"))
    @DeleteMapping("/paiementRef/{paiementRef}")
    int deleteByReference(@PathVariable String paiementRef) {
        return paiementInfra.deleteByReference(paiementRef);
    }

    //@ApiOperation(("Récupérer l'ensemble des paiements"))
    @GetMapping("/")
    public List<PaiementEntity> findAll() {
        return paiementInfra.findAll();
    }
}

