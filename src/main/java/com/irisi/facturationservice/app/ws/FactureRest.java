package com.irisi.facturationservice.app.ws;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.irisi.facturationservice.app.dto.FactureDto;
import com.irisi.facturationservice.domain.core.Result;
import com.irisi.facturationservice.domain.facture.delete.FactureDeleteInput;
import com.irisi.facturationservice.domain.facture.delete.FactureDeleteProcess;
import com.irisi.facturationservice.domain.facture.paiement.FacturePaiementInput;
import com.irisi.facturationservice.domain.facture.paiement.FacturePaiementProcess;
import com.irisi.facturationservice.infra.facade.FactureInfra;
import com.irisi.facturationservice.infra.entity.FactureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/facture")
@Api("Cette classe permet de tester les process de la facture : delete et payer")
public class FactureRest {
    @Autowired
    FactureInfra factureInfra;
    FacturePaiementProcess facturePaiementProcess;
    FactureDeleteProcess factureDeleteProcess;

    @ApiOperation(("Payer une facture"))
    @PutMapping("/payer")
    public Result payer(@RequestBody FactureDto factureDto){
        FacturePaiementInput facturePaiementInput = FactureDto.toFacturePaiementInput(factureDto);
        return facturePaiementProcess.execute(facturePaiementInput);
    }

    @ApiOperation(("Supprimer une facture"))
    @DeleteMapping("/")
    public Result delete(@RequestBody FactureDto factureDto){
        FactureDeleteInput factureDeleteInput = FactureDto.toFactureDeleteInput(factureDto);
        return factureDeleteProcess.execute(factureDeleteInput);
    }

    @ApiOperation(("Enregistrer une nouvelle facture"))
    @PostMapping("/")
    public int save(@RequestBody FactureEntity facture) {
        return factureInfra.save(facture);
    }

    @ApiOperation(("Modifier une facture existante"))
    @PutMapping("/")
    public int update(@RequestBody FactureEntity facture) {
        return factureInfra.update(facture);
    }

    @ApiOperation(("Récupérer l'ensemble des factures"))
    @GetMapping("/")
    public List<FactureEntity> findAll() {
        return factureInfra.findAll();
    }
}
