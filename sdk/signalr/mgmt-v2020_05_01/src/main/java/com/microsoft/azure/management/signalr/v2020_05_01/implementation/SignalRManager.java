/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.signalr.v2020_05_01.implementation;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.AzureResponseBuilder;
import com.microsoft.azure.credentials.AzureTokenCredentials;
import com.microsoft.azure.management.apigeneration.Beta;
import com.microsoft.azure.management.apigeneration.Beta.SinceVersion;
import com.microsoft.azure.arm.resources.AzureConfigurable;
import com.microsoft.azure.serializer.AzureJacksonAdapter;
import com.microsoft.rest.RestClient;
import com.microsoft.azure.management.signalr.v2020_05_01.Operations;
import com.microsoft.azure.management.signalr.v2020_05_01.SignalRs;
import com.microsoft.azure.management.signalr.v2020_05_01.SignalRPrivateEndpointConnections;
import com.microsoft.azure.management.signalr.v2020_05_01.SignalRPrivateLinkResources;
import com.microsoft.azure.management.signalr.v2020_05_01.Usages;
import com.microsoft.azure.arm.resources.implementation.AzureConfigurableCoreImpl;
import com.microsoft.azure.arm.resources.implementation.ManagerCore;

/**
 * Entry point to Azure SignalRService resource management.
 */
public final class SignalRManager extends ManagerCore<SignalRManager, SignalRManagementClientImpl> {
    private Operations operations;
    private SignalRs signalRs;
    private SignalRPrivateEndpointConnections signalRPrivateEndpointConnections;
    private SignalRPrivateLinkResources signalRPrivateLinkResources;
    private Usages usages;
    /**
    * Get a Configurable instance that can be used to create SignalRManager with optional configuration.
    *
    * @return the instance allowing configurations
    */
    public static Configurable configure() {
        return new SignalRManager.ConfigurableImpl();
    }
    /**
    * Creates an instance of SignalRManager that exposes SignalRService resource management API entry points.
    *
    * @param credentials the credentials to use
    * @param subscriptionId the subscription UUID
    * @return the SignalRManager
    */
    public static SignalRManager authenticate(AzureTokenCredentials credentials, String subscriptionId) {
        return new SignalRManager(new RestClient.Builder()
            .withBaseUrl(credentials.environment(), AzureEnvironment.Endpoint.RESOURCE_MANAGER)
            .withCredentials(credentials)
            .withSerializerAdapter(new AzureJacksonAdapter())
            .withResponseBuilderFactory(new AzureResponseBuilder.Factory())
            .build(), subscriptionId);
    }
    /**
    * Creates an instance of SignalRManager that exposes SignalRService resource management API entry points.
    *
    * @param restClient the RestClient to be used for API calls.
    * @param subscriptionId the subscription UUID
    * @return the SignalRManager
    */
    public static SignalRManager authenticate(RestClient restClient, String subscriptionId) {
        return new SignalRManager(restClient, subscriptionId);
    }
    /**
    * The interface allowing configurations to be set.
    */
    public interface Configurable extends AzureConfigurable<Configurable> {
        /**
        * Creates an instance of SignalRManager that exposes SignalRService management API entry points.
        *
        * @param credentials the credentials to use
        * @param subscriptionId the subscription UUID
        * @return the interface exposing SignalRService management API entry points that work across subscriptions
        */
        SignalRManager authenticate(AzureTokenCredentials credentials, String subscriptionId);
    }

    /**
     * @return Entry point to manage Operations.
     */
    public Operations operations() {
        if (this.operations == null) {
            this.operations = new OperationsImpl(this);
        }
        return this.operations;
    }

    /**
     * @return Entry point to manage SignalRs.
     */
    public SignalRs signalRs() {
        if (this.signalRs == null) {
            this.signalRs = new SignalRsImpl(this);
        }
        return this.signalRs;
    }

    /**
     * @return Entry point to manage SignalRPrivateEndpointConnections.
     */
    public SignalRPrivateEndpointConnections signalRPrivateEndpointConnections() {
        if (this.signalRPrivateEndpointConnections == null) {
            this.signalRPrivateEndpointConnections = new SignalRPrivateEndpointConnectionsImpl(this);
        }
        return this.signalRPrivateEndpointConnections;
    }

    /**
     * @return Entry point to manage SignalRPrivateLinkResources.
     */
    public SignalRPrivateLinkResources signalRPrivateLinkResources() {
        if (this.signalRPrivateLinkResources == null) {
            this.signalRPrivateLinkResources = new SignalRPrivateLinkResourcesImpl(this);
        }
        return this.signalRPrivateLinkResources;
    }

    /**
     * @return Entry point to manage Usages.
     */
    public Usages usages() {
        if (this.usages == null) {
            this.usages = new UsagesImpl(this);
        }
        return this.usages;
    }

    /**
    * The implementation for Configurable interface.
    */
    private static final class ConfigurableImpl extends AzureConfigurableCoreImpl<Configurable> implements Configurable {
        public SignalRManager authenticate(AzureTokenCredentials credentials, String subscriptionId) {
           return SignalRManager.authenticate(buildRestClient(credentials), subscriptionId);
        }
     }
    private SignalRManager(RestClient restClient, String subscriptionId) {
        super(
            restClient,
            subscriptionId,
            new SignalRManagementClientImpl(restClient).withSubscriptionId(subscriptionId));
    }
}
