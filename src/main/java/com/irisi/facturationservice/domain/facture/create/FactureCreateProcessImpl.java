package com.irisi.facturationservice.domain.facture.create;

import com.irisi.facturationservice.app.dto.MailParameter;
import com.irisi.facturationservice.domain.core.AbstractProcessImpl;
import com.irisi.facturationservice.domain.core.Result;
import com.irisi.facturationservice.domain.pojo.FacturePojo;
import com.irisi.facturationservice.domain.pojo.ProjetMemberPojo;
import com.irisi.facturationservice.infra.facade.FactureInfra;
import com.irisi.facturationservice.infra.impl.MailSender;
import com.irisi.facturationservice.utils.PdfUtils;

import java.util.List;

public class FactureCreateProcessImpl extends AbstractProcessImpl<FactureCreateInput> implements FactureCreateProcess {
    FactureInfra factureInfra;
    MailSender mailSender;

    public FactureCreateProcessImpl(FactureInfra factureInfra, MailSender mailSender) {
        this.factureInfra = factureInfra;
        this.mailSender = mailSender;
    }

    @Override
    public void validate(FactureCreateInput abstractProcessInput, Result result) {
        FacturePojo facture = factureInfra.findByReference(abstractProcessInput.getFacture().getReference());
        if (facture != null && facture.getId() != null) {
            result.addErrorMessage("facture.create.facture_already_exists");
        }
    }

    @Override
    public void run(FactureCreateInput abstractProcessInput, Result result) {
        FacturePojo facture = abstractProcessInput.getFacture();
        double total = factureInfra.calculTotalFacture(facture);
        facture.setTotal(total);
        List<ProjetMemberPojo> projetMembers = factureInfra.findProjetMembers(facture);
        facture.setPdf(PdfUtils.generatePdf(facture, projetMembers));
        FacturePojo savedFacture = factureInfra.save(facture);
        mailSender.sendKafkaMessage(new MailParameter("ezaghabchaimaa@gmail.com", "Facture", "Votre facture est: "+savedFacture));
        result.addInfoMessage("facture.create.facture_created_successfully");
        result.setOutput(savedFacture);
    }
}
