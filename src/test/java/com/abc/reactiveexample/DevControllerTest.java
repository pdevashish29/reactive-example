package com.abc.reactiveexample;

import com.abc.reactiveexample.devashish.DevController;
import com.abc.reactiveexample.devashish.DevService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DevControllerTest {

    @InjectMocks
    DevController devController;

    @Mock
    DevService devService;

    @Test
    void testSendwhatsappSuccess(){
        Mockito.when(devService.sendWhatsapp(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(true);
        boolean flag= devController.sendwhatsapp("97979797", "How are you?" ,"24824");
        Assertions.assertTrue(flag);
    }

    @Test
    void testSendwhatsappFailed(){
        Mockito.when(devService.sendWhatsapp(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(false);
        boolean flag= devController.sendwhatsapp("97979797", "How are you?" ,"24824");
        Assertions.assertFalse(flag);
    }



}
