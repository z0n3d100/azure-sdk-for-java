// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.fluent.inner;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.compute.models.InstanceViewStatus;
import com.azure.resourcemanager.compute.models.VirtualMachineScaleSetInstanceViewStatusesSummary;
import com.azure.resourcemanager.compute.models.VirtualMachineScaleSetVMExtensionsSummary;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The VirtualMachineScaleSetInstanceView model. */
@Fluent
public final class VirtualMachineScaleSetInstanceViewInner {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(VirtualMachineScaleSetInstanceViewInner.class);

    /*
     * The instance view status summary for the virtual machine scale set.
     */
    @JsonProperty(value = "virtualMachine", access = JsonProperty.Access.WRITE_ONLY)
    private VirtualMachineScaleSetInstanceViewStatusesSummary virtualMachine;

    /*
     * The extensions information.
     */
    @JsonProperty(value = "extensions", access = JsonProperty.Access.WRITE_ONLY)
    private List<VirtualMachineScaleSetVMExtensionsSummary> extensions;

    /*
     * The resource status information.
     */
    @JsonProperty(value = "statuses")
    private List<InstanceViewStatus> statuses;

    /**
     * Get the virtualMachine property: The instance view status summary for the virtual machine scale set.
     *
     * @return the virtualMachine value.
     */
    public VirtualMachineScaleSetInstanceViewStatusesSummary virtualMachine() {
        return this.virtualMachine;
    }

    /**
     * Get the extensions property: The extensions information.
     *
     * @return the extensions value.
     */
    public List<VirtualMachineScaleSetVMExtensionsSummary> extensions() {
        return this.extensions;
    }

    /**
     * Get the statuses property: The resource status information.
     *
     * @return the statuses value.
     */
    public List<InstanceViewStatus> statuses() {
        return this.statuses;
    }

    /**
     * Set the statuses property: The resource status information.
     *
     * @param statuses the statuses value to set.
     * @return the VirtualMachineScaleSetInstanceViewInner object itself.
     */
    public VirtualMachineScaleSetInstanceViewInner withStatuses(List<InstanceViewStatus> statuses) {
        this.statuses = statuses;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (virtualMachine() != null) {
            virtualMachine().validate();
        }
        if (extensions() != null) {
            extensions().forEach(e -> e.validate());
        }
        if (statuses() != null) {
            statuses().forEach(e -> e.validate());
        }
    }
}
