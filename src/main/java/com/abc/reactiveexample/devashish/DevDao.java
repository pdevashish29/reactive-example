package com.abc.reactiveexample.devashish;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class DevDao {


    public boolean sendMessage(String targetPhone, String content, String sourcePhone){
        log.info("DevDao.sendMessage, {} ", targetPhone, content, sourcePhone);
        return  true;
    }
}
