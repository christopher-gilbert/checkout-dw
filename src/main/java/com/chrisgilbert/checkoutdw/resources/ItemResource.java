package com.chrisgilbert.checkoutdw.resources;

import com.chrisgilbert.checkoutdw.api.Item;
import com.chrisgilbert.checkoutdw.db.ItemDao;
import com.codahale.metrics.annotation.ResponseMetered;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;

import static java.util.UUID.randomUUID;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/items")
@Produces(APPLICATION_JSON)
public class ItemResource {

    @Inject
    private ItemDao itemDao;

    @POST
    @Timed
    @ResponseMetered
    public Item createItem(@NotNull @Valid Item newItem) {
        final var itemId = randomUUID().toString();
        itemDao.insert(itemId, newItem.sku(), newItem.description(), newItem.unitPrice());
        return getItem(newItem.sku());
    }

    @GET
    @Path("/{sku}")
    @Timed
    @ResponseMetered
    public Item getItem(@NotNull @Valid @PathParam("sku") String sku) {
        return itemDao.findBySku(sku);
    }
}
