package com.nerisa.hrpayroll.services;

import com.nerisa.hrpayroll.entities.Payment;
import com.nerisa.hrpayroll.entities.Worker;
import com.nerisa.hrpayroll.feignclients.WorkerFeignClients;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WorkerFeignClients workerFeignClients;

    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClients.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
