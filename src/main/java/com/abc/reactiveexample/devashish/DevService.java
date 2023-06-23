package com.abc.reactiveexample.devashish;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DevService {

    @Autowired
    private DevDao devDao;
    public  boolean sendWhatsapp(String targetPhone, String content, String sourcePhone){
        log.info("DevService.sendWhatsapp, {} ", targetPhone, content, sourcePhone);
        return devDao.sendMessage(targetPhone,content,sourcePhone);
    }
}
