package com.example.foodweb.repository;

import com.example.foodweb.Model.CartItem;
import com.example.foodweb.Model.Customer;
import com.example.foodweb.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findByCartItemCustomer(Customer customer);

    @Modifying
    @Query("UPDATE Payment p SET p.statusPay = 1 WHERE p.idPayment = :idPayment")
    void updatePaymentStatus(@Param("idPayment") Integer idPayment);

}
