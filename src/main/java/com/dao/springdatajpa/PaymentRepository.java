/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.springdatajpa;


import com.domain.Account;
import com.domain.Payment;
import com.domain.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 201244055
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    public Payment findTopByAccountOrderByIdDesc(Account account);
    public List<Payment> findByInvoice_ScheduleAndAccount_Address_Brgy(Schedule sched, String brgy);
    public List<Payment> findByInvoice_Schedule(Schedule sched);
    public List<Payment> findTop3ByAccountOrderByIdDesc(Account account);
}
