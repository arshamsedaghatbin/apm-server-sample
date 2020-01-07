package com.javainuse;

import co.elastic.apm.api.CaptureSpan;
import co.elastic.apm.api.CaptureTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ServiceTest {

    Logger LOG = Logger.getLogger(ELKController.class.getName());

    @CaptureSpan(value = "ServiceTest.test",type = "db",subtype = "mysql")
    public void test(){
        String response = "Welcome to javainuse" + new Date();
        Test test=new Test();
        test.setName("arsham");
        test.setFatherName("test");
        try {
            LOG.error(new ObjectMapper().writeValueAsString(test));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
