package com.chrisgilbert.checkoutdw.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotEmpty;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

/**
 * A {@link Customer}
 */
@JsonAutoDetect(fieldVisibility = ANY)
@JsonSerialize
public record Customer(
        String id,
        @NotEmpty String firstName,
        @NotEmpty String lastName
) {
}
