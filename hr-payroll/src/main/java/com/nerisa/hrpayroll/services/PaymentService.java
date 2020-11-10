package com.nerisa.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.nerisa.hrpayroll.entities.Payment;
import com.nerisa.hrpayroll.entities.Worker;
import com.nerisa.hrpayroll.feignclients.WorkerFeignClients;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WorkerFeignClients workerFeignClients;

    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClients.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
