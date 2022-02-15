package com.chrisgilbert.checkoutdw.resources;

import com.chrisgilbert.checkoutdw.api.Customer;
import com.codahale.metrics.annotation.ResponseMetered;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.UUID;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/customers")
@Produces(APPLICATION_JSON)
public class CustomerResource {

    @Inject
    private Provider<HttpServletRequest> requestProvider;

    @POST
    @Timed
    @ResponseMetered
    public Customer createCustomer(@NotNull @Valid Customer newCustomer) {
        System.out.println(String.format("I have created a customer from %s", requestProvider.get().getRemoteAddr()));
        return new Customer(UUID.randomUUID().toString(), newCustomer.firstName(), newCustomer.lastName());
    }
}
