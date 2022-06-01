package br.com.silva.store.userservice.query;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import br.com.silva.estore.core.model.PaymentDetails;
import br.com.silva.estore.core.model.User;
import br.com.silva.estore.core.query.FetchUserPaymentDetailsQuery;

@Component
public class UserEventsHandler {

    @QueryHandler
    public User findUserPaymentDetails(FetchUserPaymentDetailsQuery query) {
        
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("4024 0071 1067 6821")
                .cvv("156")
                .name("Rodrigo Vinicius Yuri Santos")
                .validUntilMonth(03)
                .validUntilYear(2023)
                .build();

        User user = User.builder()
                .firstName("Rodrigo")
                .lastName("Santos")
                .userId(query.getUserId())
                .paymentDetails(paymentDetails)
                .build();

        return user;
    }
    
    
}