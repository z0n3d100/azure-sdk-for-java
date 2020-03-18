/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.knowledge.qnamaker.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Record to track long running operation.
 */
public class Operation {
    /**
     * Operation state. Possible values include: 'Failed', 'NotStarted',
     * 'Running', 'Succeeded'.
     */
    @JsonProperty(value = "operationState")
    private OperationStateType operationState;

    /**
     * Timestamp when the operation was created.
     */
    @JsonProperty(value = "createdTimestamp")
    private String createdTimestamp;

    /**
     * Timestamp when the current state was entered.
     */
    @JsonProperty(value = "lastActionTimestamp")
    private String lastActionTimestamp;

    /**
     * Relative URI to the target resource location for completed resources.
     */
    @JsonProperty(value = "resourceLocation")
    private String resourceLocation;

    /**
     * User Id.
     */
    @JsonProperty(value = "userId")
    private String userId;

    /**
     * Operation Id.
     */
    @JsonProperty(value = "operationId")
    private String operationId;

    /**
     * Error details in case of failures.
     */
    @JsonProperty(value = "errorResponse")
    private ErrorResponse errorResponse;

    /**
     * Get the operationState value.
     *
     * @return the operationState value
     */
    public OperationStateType operationState() {
        return this.operationState;
    }

    /**
     * Set the operationState value.
     *
     * @param operationState the operationState value to set
     * @return the Operation object itself.
     */
    public Operation withOperationState(OperationStateType operationState) {
        this.operationState = operationState;
        return this;
    }

    /**
     * Get the createdTimestamp value.
     *
     * @return the createdTimestamp value
     */
    public String createdTimestamp() {
        return this.createdTimestamp;
    }

    /**
     * Set the createdTimestamp value.
     *
     * @param createdTimestamp the createdTimestamp value to set
     * @return the Operation object itself.
     */
    public Operation withCreatedTimestamp(String createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
        return this;
    }

    /**
     * Get the lastActionTimestamp value.
     *
     * @return the lastActionTimestamp value
     */
    public String lastActionTimestamp() {
        return this.lastActionTimestamp;
    }

    /**
     * Set the lastActionTimestamp value.
     *
     * @param lastActionTimestamp the lastActionTimestamp value to set
     * @return the Operation object itself.
     */
    public Operation withLastActionTimestamp(String lastActionTimestamp) {
        this.lastActionTimestamp = lastActionTimestamp;
        return this;
    }

    /**
     * Get the resourceLocation value.
     *
     * @return the resourceLocation value
     */
    public String resourceLocation() {
        return this.resourceLocation;
    }

    /**
     * Set the resourceLocation value.
     *
     * @param resourceLocation the resourceLocation value to set
     * @return the Operation object itself.
     */
    public Operation withResourceLocation(String resourceLocation) {
        this.resourceLocation = resourceLocation;
        return this;
    }

    /**
     * Get the userId value.
     *
     * @return the userId value
     */
    public String userId() {
        return this.userId;
    }

    /**
     * Set the userId value.
     *
     * @param userId the userId value to set
     * @return the Operation object itself.
     */
    public Operation withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get the operationId value.
     *
     * @return the operationId value
     */
    public String operationId() {
        return this.operationId;
    }

    /**
     * Set the operationId value.
     *
     * @param operationId the operationId value to set
     * @return the Operation object itself.
     */
    public Operation withOperationId(String operationId) {
        this.operationId = operationId;
        return this;
    }

    /**
     * Get the errorResponse value.
     *
     * @return the errorResponse value
     */
    public ErrorResponse errorResponse() {
        return this.errorResponse;
    }

    /**
     * Set the errorResponse value.
     *
     * @param errorResponse the errorResponse value to set
     * @return the Operation object itself.
     */
    public Operation withErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
        return this;
    }

}
