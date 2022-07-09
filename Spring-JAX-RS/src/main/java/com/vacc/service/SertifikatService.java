package com.vacc.service;

import com.vacc.dao.SertifikatDAO;
import model.sertifikat.ZeleniSertifikat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SertifikatService {


    private final SertifikatDAO sertifikatDAO;

    public SertifikatService(SertifikatDAO sertifikatDAO) {
        this.sertifikatDAO = sertifikatDAO;
    }

    public void save(ZeleniSertifikat sertifikat) {
        String uniqueID = UUID.randomUUID().toString();
        sertifikat.setId(uniqueID);
        String documentId = "sertifikat-" + uniqueID + "-22.xml";
        sertifikatDAO.save(sertifikatDAO.getFolderPath(), documentId,sertifikat,ZeleniSertifikat.class);
    }

    public List<ZeleniSertifikat> getAllJmbg(String jmbg){
        return sertifikatDAO.getAll(jmbg);
    }
}
