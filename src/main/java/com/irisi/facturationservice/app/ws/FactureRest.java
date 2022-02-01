package com.irisi.facturationservice.app.ws;

import com.irisi.facturationservice.app.converter.FactureMapper;
import com.irisi.facturationservice.app.dto.FactureDto;
import com.irisi.facturationservice.domain.core.Result;
import com.irisi.facturationservice.domain.facture.create.FactureCreateInput;
import com.irisi.facturationservice.domain.facture.create.FactureCreateProcess;
import com.irisi.facturationservice.domain.facture.delete.FactureDeleteInput;
import com.irisi.facturationservice.domain.facture.delete.FactureDeleteProcess;
import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.infra.facade.FactureInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/facturation/factures")
public class FactureRest {
    @Autowired
    FactureInfra factureInfra;
    @Autowired
    FactureCreateProcess factureCreateProcess;
    @Autowired
    FactureDeleteProcess factureDeleteProcess;

    @PostMapping("/")
    public Result createFacture(@RequestBody FactureDto factureDto){
        FactureMapper factureMapper = new FactureMapper();
        FacturePojo facture = factureMapper.toPojo(factureDto);
        FactureCreateInput factureCreateInput = new FactureCreateInput();
        factureCreateInput.setFacture(facture);
        return factureCreateProcess.execute(factureCreateInput);
    }

    @Transactional
    @DeleteMapping("/{reference}")
    public Result deleteFacture(@PathVariable String reference){
        FactureDeleteInput factureDeleteInput = new FactureDeleteInput();
        factureDeleteInput.setReference(reference);
        return factureDeleteProcess.execute(factureDeleteInput);
    }
}
