package com.irisi.facturationservice.app.util;

import com.irisi.facturationservice.domain.facture.create.FactureCreateProcess;
import com.irisi.facturationservice.domain.facture.create.FactureCreateProcessImpl;
import com.irisi.facturationservice.domain.facture.delete.FactureDeleteProcess;
import com.irisi.facturationservice.domain.facture.delete.FactureDeleteProcessImpl;
import com.irisi.facturationservice.infra.facade.FactureInfra;
import com.irisi.facturationservice.infra.impl.MailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processinjection {
    @Bean
    public FactureCreateProcess factureCreateProcess(FactureInfra factureInfra, MailSender mailSender){
        return new FactureCreateProcessImpl(factureInfra, mailSender);
    }

    @Bean
    public FactureDeleteProcess factureDeleteProcess(FactureInfra factureInfra) {
        return new FactureDeleteProcessImpl(factureInfra);
    }
}

