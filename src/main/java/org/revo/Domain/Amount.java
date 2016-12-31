package org.revo.Domain;

/**
 * Created by ashraf on 26/12/16.
 */

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FollowAmount.class, name = "FollowAmount"),
        @JsonSubTypes.Type(value = UnFollowAmount.class, name = "UnFollowAmount")})
public abstract class Amount {
}