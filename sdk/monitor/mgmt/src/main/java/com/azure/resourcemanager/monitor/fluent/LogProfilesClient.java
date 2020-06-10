// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.fluent;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.Patch;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.monitor.MonitorClient;
import com.azure.resourcemanager.monitor.fluent.inner.LogProfileCollectionInner;
import com.azure.resourcemanager.monitor.fluent.inner.LogProfileResourceInner;
import com.azure.resourcemanager.monitor.models.LogProfileResourcePatch;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in LogProfiles. */
public final class LogProfilesClient {
    private final ClientLogger logger = new ClientLogger(LogProfilesClient.class);

    /** The proxy service used to perform REST calls. */
    private final LogProfilesService service;

    /** The service client containing this operation class. */
    private final MonitorClient client;

    /**
     * Initializes an instance of LogProfilesClient.
     *
     * @param client the instance of the service client containing this operation class.
     */
    public LogProfilesClient(MonitorClient client) {
        this.service =
            RestProxy.create(LogProfilesService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for MonitorClientLogProfiles to be used by the proxy service to perform
     * REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "MonitorClientLogProf")
    private interface LogProfilesService {
        @Headers({"Accept: application/json;q=0.9", "Content-Type: application/json"})
        @Delete("/subscriptions/{subscriptionId}/providers/microsoft.insights/logprofiles/{logProfileName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<Void>> delete(
            @HostParam("$host") String endpoint,
            @PathParam("logProfileName") String logProfileName,
            @QueryParam("api-version") String apiVersion,
            @PathParam("subscriptionId") String subscriptionId,
            Context context);

        @Headers({"Accept: application/json", "Content-Type: application/json"})
        @Get("/subscriptions/{subscriptionId}/providers/microsoft.insights/logprofiles/{logProfileName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<LogProfileResourceInner>> get(
            @HostParam("$host") String endpoint,
            @PathParam("logProfileName") String logProfileName,
            @QueryParam("api-version") String apiVersion,
            @PathParam("subscriptionId") String subscriptionId,
            Context context);

        @Headers({"Accept: application/json", "Content-Type: application/json"})
        @Put("/subscriptions/{subscriptionId}/providers/microsoft.insights/logprofiles/{logProfileName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<LogProfileResourceInner>> createOrUpdate(
            @HostParam("$host") String endpoint,
            @PathParam("logProfileName") String logProfileName,
            @QueryParam("api-version") String apiVersion,
            @PathParam("subscriptionId") String subscriptionId,
            @BodyParam("application/json") LogProfileResourceInner parameters,
            Context context);

        @Headers({"Accept: application/json", "Content-Type: application/json"})
        @Patch("/subscriptions/{subscriptionId}/providers/microsoft.insights/logprofiles/{logProfileName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<LogProfileResourceInner>> update(
            @HostParam("$host") String endpoint,
            @PathParam("subscriptionId") String subscriptionId,
            @PathParam("logProfileName") String logProfileName,
            @QueryParam("api-version") String apiVersion,
            @BodyParam("application/json") LogProfileResourcePatch logProfilesResource,
            Context context);

        @Headers({"Accept: application/json", "Content-Type: application/json"})
        @Get("/subscriptions/{subscriptionId}/providers/microsoft.insights/logprofiles")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<LogProfileCollectionInner>> list(
            @HostParam("$host") String endpoint,
            @QueryParam("api-version") String apiVersion,
            @PathParam("subscriptionId") String subscriptionId,
            Context context);
    }

    /**
     * Deletes the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteWithResponseAsync(String logProfileName) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (logProfileName == null) {
            return Mono.error(new IllegalArgumentException("Parameter logProfileName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        final String apiVersion = "2016-03-01";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .delete(
                            this.client.getEndpoint(),
                            logProfileName,
                            apiVersion,
                            this.client.getSubscriptionId(),
                            context))
            .subscriberContext(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext())));
    }

    /**
     * Deletes the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteWithResponseAsync(String logProfileName, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (logProfileName == null) {
            return Mono.error(new IllegalArgumentException("Parameter logProfileName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        final String apiVersion = "2016-03-01";
        return service
            .delete(this.client.getEndpoint(), logProfileName, apiVersion, this.client.getSubscriptionId(), context);
    }

    /**
     * Deletes the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteAsync(String logProfileName) {
        return deleteWithResponseAsync(logProfileName).flatMap((Response<Void> res) -> Mono.empty());
    }

    /**
     * Deletes the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteAsync(String logProfileName, Context context) {
        return deleteWithResponseAsync(logProfileName, context).flatMap((Response<Void> res) -> Mono.empty());
    }

    /**
     * Deletes the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void delete(String logProfileName) {
        deleteAsync(logProfileName).block();
    }

    /**
     * Deletes the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void delete(String logProfileName, Context context) {
        deleteAsync(logProfileName, context).block();
    }

    /**
     * Gets the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LogProfileResourceInner>> getWithResponseAsync(String logProfileName) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (logProfileName == null) {
            return Mono.error(new IllegalArgumentException("Parameter logProfileName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        final String apiVersion = "2016-03-01";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .get(
                            this.client.getEndpoint(),
                            logProfileName,
                            apiVersion,
                            this.client.getSubscriptionId(),
                            context))
            .subscriberContext(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext())));
    }

    /**
     * Gets the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LogProfileResourceInner>> getWithResponseAsync(String logProfileName, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (logProfileName == null) {
            return Mono.error(new IllegalArgumentException("Parameter logProfileName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        final String apiVersion = "2016-03-01";
        return service
            .get(this.client.getEndpoint(), logProfileName, apiVersion, this.client.getSubscriptionId(), context);
    }

    /**
     * Gets the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LogProfileResourceInner> getAsync(String logProfileName) {
        return getWithResponseAsync(logProfileName)
            .flatMap(
                (Response<LogProfileResourceInner> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * Gets the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LogProfileResourceInner> getAsync(String logProfileName, Context context) {
        return getWithResponseAsync(logProfileName, context)
            .flatMap(
                (Response<LogProfileResourceInner> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * Gets the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LogProfileResourceInner get(String logProfileName) {
        return getAsync(logProfileName).block();
    }

    /**
     * Gets the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LogProfileResourceInner get(String logProfileName, Context context) {
        return getAsync(logProfileName, context).block();
    }

    /**
     * Create or update a log profile in Azure Monitoring REST API.
     *
     * @param logProfileName The name of the log profile.
     * @param parameters The log profile resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LogProfileResourceInner>> createOrUpdateWithResponseAsync(
        String logProfileName, LogProfileResourceInner parameters) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (logProfileName == null) {
            return Mono.error(new IllegalArgumentException("Parameter logProfileName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (parameters == null) {
            return Mono.error(new IllegalArgumentException("Parameter parameters is required and cannot be null."));
        } else {
            parameters.validate();
        }
        final String apiVersion = "2016-03-01";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .createOrUpdate(
                            this.client.getEndpoint(),
                            logProfileName,
                            apiVersion,
                            this.client.getSubscriptionId(),
                            parameters,
                            context))
            .subscriberContext(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext())));
    }

    /**
     * Create or update a log profile in Azure Monitoring REST API.
     *
     * @param logProfileName The name of the log profile.
     * @param parameters The log profile resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LogProfileResourceInner>> createOrUpdateWithResponseAsync(
        String logProfileName, LogProfileResourceInner parameters, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (logProfileName == null) {
            return Mono.error(new IllegalArgumentException("Parameter logProfileName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (parameters == null) {
            return Mono.error(new IllegalArgumentException("Parameter parameters is required and cannot be null."));
        } else {
            parameters.validate();
        }
        final String apiVersion = "2016-03-01";
        return service
            .createOrUpdate(
                this.client.getEndpoint(),
                logProfileName,
                apiVersion,
                this.client.getSubscriptionId(),
                parameters,
                context);
    }

    /**
     * Create or update a log profile in Azure Monitoring REST API.
     *
     * @param logProfileName The name of the log profile.
     * @param parameters The log profile resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LogProfileResourceInner> createOrUpdateAsync(
        String logProfileName, LogProfileResourceInner parameters) {
        return createOrUpdateWithResponseAsync(logProfileName, parameters)
            .flatMap(
                (Response<LogProfileResourceInner> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * Create or update a log profile in Azure Monitoring REST API.
     *
     * @param logProfileName The name of the log profile.
     * @param parameters The log profile resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LogProfileResourceInner> createOrUpdateAsync(
        String logProfileName, LogProfileResourceInner parameters, Context context) {
        return createOrUpdateWithResponseAsync(logProfileName, parameters, context)
            .flatMap(
                (Response<LogProfileResourceInner> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * Create or update a log profile in Azure Monitoring REST API.
     *
     * @param logProfileName The name of the log profile.
     * @param parameters The log profile resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LogProfileResourceInner createOrUpdate(String logProfileName, LogProfileResourceInner parameters) {
        return createOrUpdateAsync(logProfileName, parameters).block();
    }

    /**
     * Create or update a log profile in Azure Monitoring REST API.
     *
     * @param logProfileName The name of the log profile.
     * @param parameters The log profile resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LogProfileResourceInner createOrUpdate(
        String logProfileName, LogProfileResourceInner parameters, Context context) {
        return createOrUpdateAsync(logProfileName, parameters, context).block();
    }

    /**
     * Updates an existing LogProfilesResource. To update other fields use the CreateOrUpdate method.
     *
     * @param logProfileName The name of the log profile.
     * @param logProfilesResource The log profile resource for patch operations.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LogProfileResourceInner>> updateWithResponseAsync(
        String logProfileName, LogProfileResourcePatch logProfilesResource) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (logProfileName == null) {
            return Mono.error(new IllegalArgumentException("Parameter logProfileName is required and cannot be null."));
        }
        if (logProfilesResource == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter logProfilesResource is required and cannot be null."));
        } else {
            logProfilesResource.validate();
        }
        final String apiVersion = "2016-03-01";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .update(
                            this.client.getEndpoint(),
                            this.client.getSubscriptionId(),
                            logProfileName,
                            apiVersion,
                            logProfilesResource,
                            context))
            .subscriberContext(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext())));
    }

    /**
     * Updates an existing LogProfilesResource. To update other fields use the CreateOrUpdate method.
     *
     * @param logProfileName The name of the log profile.
     * @param logProfilesResource The log profile resource for patch operations.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LogProfileResourceInner>> updateWithResponseAsync(
        String logProfileName, LogProfileResourcePatch logProfilesResource, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (logProfileName == null) {
            return Mono.error(new IllegalArgumentException("Parameter logProfileName is required and cannot be null."));
        }
        if (logProfilesResource == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter logProfilesResource is required and cannot be null."));
        } else {
            logProfilesResource.validate();
        }
        final String apiVersion = "2016-03-01";
        return service
            .update(
                this.client.getEndpoint(),
                this.client.getSubscriptionId(),
                logProfileName,
                apiVersion,
                logProfilesResource,
                context);
    }

    /**
     * Updates an existing LogProfilesResource. To update other fields use the CreateOrUpdate method.
     *
     * @param logProfileName The name of the log profile.
     * @param logProfilesResource The log profile resource for patch operations.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LogProfileResourceInner> updateAsync(
        String logProfileName, LogProfileResourcePatch logProfilesResource) {
        return updateWithResponseAsync(logProfileName, logProfilesResource)
            .flatMap(
                (Response<LogProfileResourceInner> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * Updates an existing LogProfilesResource. To update other fields use the CreateOrUpdate method.
     *
     * @param logProfileName The name of the log profile.
     * @param logProfilesResource The log profile resource for patch operations.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LogProfileResourceInner> updateAsync(
        String logProfileName, LogProfileResourcePatch logProfilesResource, Context context) {
        return updateWithResponseAsync(logProfileName, logProfilesResource, context)
            .flatMap(
                (Response<LogProfileResourceInner> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * Updates an existing LogProfilesResource. To update other fields use the CreateOrUpdate method.
     *
     * @param logProfileName The name of the log profile.
     * @param logProfilesResource The log profile resource for patch operations.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LogProfileResourceInner update(String logProfileName, LogProfileResourcePatch logProfilesResource) {
        return updateAsync(logProfileName, logProfilesResource).block();
    }

    /**
     * Updates an existing LogProfilesResource. To update other fields use the CreateOrUpdate method.
     *
     * @param logProfileName The name of the log profile.
     * @param logProfilesResource The log profile resource for patch operations.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the log profile resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LogProfileResourceInner update(
        String logProfileName, LogProfileResourcePatch logProfilesResource, Context context) {
        return updateAsync(logProfileName, logProfilesResource, context).block();
    }

    /**
     * List the log profiles.
     *
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a collection of log profiles.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<LogProfileResourceInner>> listSinglePageAsync() {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        final String apiVersion = "2016-03-01";
        return FluxUtil
            .withContext(
                context ->
                    service.list(this.client.getEndpoint(), apiVersion, this.client.getSubscriptionId(), context))
            .<PagedResponse<LogProfileResourceInner>>map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(), res.getStatusCode(), res.getHeaders(), res.getValue().value(), null, null))
            .subscriberContext(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext())));
    }

    /**
     * List the log profiles.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a collection of log profiles.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<LogProfileResourceInner>> listSinglePageAsync(Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        final String apiVersion = "2016-03-01";
        return service
            .list(this.client.getEndpoint(), apiVersion, this.client.getSubscriptionId(), context)
            .map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(), res.getStatusCode(), res.getHeaders(), res.getValue().value(), null, null));
    }

    /**
     * List the log profiles.
     *
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a collection of log profiles.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<LogProfileResourceInner> listAsync() {
        return new PagedFlux<>(() -> listSinglePageAsync());
    }

    /**
     * List the log profiles.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a collection of log profiles.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<LogProfileResourceInner> listAsync(Context context) {
        return new PagedFlux<>(() -> listSinglePageAsync(context));
    }

    /**
     * List the log profiles.
     *
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a collection of log profiles.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<LogProfileResourceInner> list() {
        return new PagedIterable<>(listAsync());
    }

    /**
     * List the log profiles.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a collection of log profiles.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<LogProfileResourceInner> list(Context context) {
        return new PagedIterable<>(listAsync(context));
    }
}
