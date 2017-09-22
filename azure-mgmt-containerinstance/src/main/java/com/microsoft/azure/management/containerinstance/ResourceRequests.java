/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerinstance;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The resource requests.
 */
public class ResourceRequests {
    /**
     * The memory request in GB of this container.
     */
    @JsonProperty(value = "memoryInGB", required = true)
    private double memoryInGB;

    /**
     * The CPU request of this container.
     */
    @JsonProperty(value = "cpu", required = true)
    private double cpu;

    /**
     * Get the memoryInGB value.
     *
     * @return the memoryInGB value
     */
    public double memoryInGB() {
        return this.memoryInGB;
    }

    /**
     * Set the memoryInGB value.
     *
     * @param memoryInGB the memoryInGB value to set
     * @return the ResourceRequests object itself.
     */
    public ResourceRequests withMemoryInGB(double memoryInGB) {
        this.memoryInGB = memoryInGB;
        return this;
    }

    /**
     * Get the cpu value.
     *
     * @return the cpu value
     */
    public double cpu() {
        return this.cpu;
    }

    /**
     * Set the cpu value.
     *
     * @param cpu the cpu value to set
     * @return the ResourceRequests object itself.
     */
    public ResourceRequests withCpu(double cpu) {
        this.cpu = cpu;
        return this;
    }

}
