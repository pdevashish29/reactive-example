package com.abc.reactiveexample.devashish;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DevController {

    @Autowired
    private DevService devService;

   @GetMapping("api/sendwhatsapp")
    public boolean sendwhatsapp(@RequestParam("targetPhone") String targetPhone,@RequestParam("content") String content,@RequestParam("sourcePhone") String sourcePhone ){
       try{
           log.info("DevService.sendWhatsapp, {} ", targetPhone+"+\t"+content+"\t"+ sourcePhone);
           return devService.sendWhatsapp(targetPhone,content,sourcePhone);
       }catch (Exception e){
          return  false;
       }
   }
}
