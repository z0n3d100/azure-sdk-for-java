// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmos.fluent.inner;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.cosmos.models.MetricName;
import com.azure.resourcemanager.cosmos.models.UnitType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The Usage model. */
@Immutable
public class UsageInner {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(UsageInner.class);

    /*
     * The unit of the metric.
     */
    @JsonProperty(value = "unit", access = JsonProperty.Access.WRITE_ONLY)
    private UnitType unit;

    /*
     * The name information for the metric.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private MetricName name;

    /*
     * The quota period used to summarize the usage values.
     */
    @JsonProperty(value = "quotaPeriod", access = JsonProperty.Access.WRITE_ONLY)
    private String quotaPeriod;

    /*
     * Maximum value for this metric
     */
    @JsonProperty(value = "limit", access = JsonProperty.Access.WRITE_ONLY)
    private Long limit;

    /*
     * Current value for this metric
     */
    @JsonProperty(value = "currentValue", access = JsonProperty.Access.WRITE_ONLY)
    private Long currentValue;

    /**
     * Get the unit property: The unit of the metric.
     *
     * @return the unit value.
     */
    public UnitType unit() {
        return this.unit;
    }

    /**
     * Get the name property: The name information for the metric.
     *
     * @return the name value.
     */
    public MetricName name() {
        return this.name;
    }

    /**
     * Get the quotaPeriod property: The quota period used to summarize the usage values.
     *
     * @return the quotaPeriod value.
     */
    public String quotaPeriod() {
        return this.quotaPeriod;
    }

    /**
     * Get the limit property: Maximum value for this metric.
     *
     * @return the limit value.
     */
    public Long limit() {
        return this.limit;
    }

    /**
     * Get the currentValue property: Current value for this metric.
     *
     * @return the currentValue value.
     */
    public Long currentValue() {
        return this.currentValue;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() != null) {
            name().validate();
        }
    }
}
