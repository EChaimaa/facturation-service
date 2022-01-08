package com.irisi.facturationservice.app.util;

import com.irisi.facturationservice.domain.facture.delete.FactureDeleteProcess;
import com.irisi.facturationservice.domain.facture.delete.FactureDeleteProcessImpl;
import com.irisi.facturationservice.domain.facture.paiement.FacturePaiementProcess;
import com.irisi.facturationservice.domain.facture.paiement.FacturePaimentProcessImpl;
import com.irisi.facturationservice.infra.facade.FactureInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processinjection {

    @Bean
    public FacturePaiementProcess facturePaiementProcess(FactureInfra factureInfra) {
        return new FacturePaimentProcessImpl(factureInfra);
    }

    @Bean
    public FactureDeleteProcess factureDeleteProcess(FactureInfra factureInfra) {
        return new FactureDeleteProcessImpl(factureInfra);
    }
}

