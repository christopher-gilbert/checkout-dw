package com.chrisgilbert.checkoutdw.api;

import java.util.List;

record Basket(String id, Customer owner, List<Item> items) {
}
