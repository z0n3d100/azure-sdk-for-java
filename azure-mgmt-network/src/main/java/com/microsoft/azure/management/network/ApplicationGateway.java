/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.management.network;

import java.util.Map;

import com.microsoft.azure.management.apigeneration.Fluent;
import com.microsoft.azure.management.apigeneration.Method;
import com.microsoft.azure.management.network.implementation.ApplicationGatewayInner;
import com.microsoft.azure.management.network.model.HasPublicIpAddress;
import com.microsoft.azure.management.resources.fluentcore.arm.models.GroupableResource;
import com.microsoft.azure.management.resources.fluentcore.arm.models.Resource;
import com.microsoft.azure.management.resources.fluentcore.model.Appliable;
import com.microsoft.azure.management.resources.fluentcore.model.Creatable;
import com.microsoft.azure.management.resources.fluentcore.model.Refreshable;
import com.microsoft.azure.management.resources.fluentcore.model.Updatable;
import com.microsoft.azure.management.resources.fluentcore.model.Wrapper;

/**
 * Entry point for application gateway management API in Azure.
 */
@Fluent
public interface ApplicationGateway extends
        GroupableResource,
        Refreshable<ApplicationGateway>,
        Wrapper<ApplicationGatewayInner>,
        Updatable<ApplicationGateway.Update> {

    // Getters

    /**
     * @return the SKU of this application gateway
     */
    ApplicationGatewaySku sku();

    /**
     * @return the operational state of the application gateway
     */
    ApplicationGatewayOperationalState operationalState();

    /**
     * @return the SSL policy for the application gateway
     */
    ApplicationGatewaySslPolicy sslPolicy();

    /**
     * @return IP configurations of this application gateway, indexed by name
     */
    Map<String, ApplicationGatewayIpConfiguration> ipConfigurations();

    /**
     * @return backend address pools of this application gateway, indexed by name
     */
    Map<String, ApplicationGatewayBackend> backends();

    /**
     * @return frontend IP configurations of this application gateway, indexed by name
     */
    Map<String, ApplicationGatewayFrontend> frontends();

    /**
     * @return named frontend ports of this application gateway, indexed by name
     */
    Map<String, Integer> frontendPorts();

    /**
     * @return backend HTTP configurations of this application gateway, indexed by name
     */
    Map<String, ApplicationGatewayBackendHttpConfiguration> backendHttpConfigurations();

    /**
     * @return SSL certificates, indexed by name
     */
    Map<String, ApplicationGatewaySslCertificate> sslCertificates();

    /**
     * @return HTTP listeners, indexed by name
     */
    Map<String, ApplicationGatewayFrontendHttpListener> frontendHttpListeners();

    /**
     * @return request routing rules, indexed by name
     */
    Map<String, ApplicationGatewayRequestRoutingRule> requestRoutingRules();

    /**
     * Returns the name of the existing port, if any, that is associated with the specified port number.
     * @param portNumber a port number
     * @return the existing port name for that port number, or null if none found
     */
    String frontendPortNameFromNumber(int portNumber);

    /**
     * Finds a frontend listener associated with the specified frontend port number, if any.
     * @param portNumber a used port number
     * @return a frontend listener, or null if none found
     */
    ApplicationGatewayFrontendHttpListener getFrontendListenerByPortNumber(int portNumber);

    /**
     * Finds a backend HTTP configuration associated with the specified backend port number, if any.
     * @param portNumber a used port number
     * @return the backend HTTP configuration, or null if none found
     */
    ApplicationGatewayBackendHttpConfiguration getBackendHttpConfigurationByPortNumber(int portNumber);

    /**
     * The entirety of the application gateway definition.
     */
    interface Definition extends
        DefinitionStages.Blank,
        DefinitionStages.WithGroup,
        DefinitionStages.WithCreate,
        DefinitionStages.WithSku,
        DefinitionStages.WithContainingSubnet,
        DefinitionStages.WithPrivateFrontend,
        DefinitionStages.WithPrivateFrontendOptional,
        DefinitionStages.WithPublicFrontend,
        DefinitionStages.WithBackend,
        DefinitionStages.WithBackendOrHttpConfig,
        DefinitionStages.WithBackendHttpConfig,
        DefinitionStages.WithBackendHttpConfigOrRequestRoutingRule,
        DefinitionStages.WithHttpListener,
        DefinitionStages.WithHttpListenerOrBackend,
        DefinitionStages.WithRequestRoutingRule,
        DefinitionStages.WithRequestRoutingRuleOrCreate {
    }

    /**
     * Grouping of application gateway definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of an application gateway definition.
         */
        interface Blank
            extends GroupableResource.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of an application gateway definition allowing to specify the resource group.
         */
        interface WithGroup
            extends GroupableResource.DefinitionStages.WithGroup<WithSku> {
        }

        /**
         * The stage of an application gateway definition allowing to add a public IP address as the default public frontend.
         * @param <ReturnT> the next stage of the definition
         */
        interface WithPublicIpAddress<ReturnT> extends HasPublicIpAddress.DefinitionStages.WithPublicIpAddress<ReturnT> {
        }

        /**
         * The stage of an application gateway definition allowing to define one or more public, or Internet-facing, frontends.
         */
        interface WithPublicFrontend extends WithPublicIpAddress<WithPrivateFrontendOptional> {
            /**
             * Begins the definition of a new public, or Internet-facing, frontend.
             * @param name the name for the frontend
             * @return the first stage of the new frontend definition
             */
            ApplicationGatewayPublicFrontend.DefinitionStages.Blank<WithPrivateFrontendOptional> definePublicFrontend(String name);

            /**
             * Specifies that the application gateway should not be Internet-facing.
             * @return the next stage of the definition
             */
            @Method
            WithPrivateFrontend withoutPublicFrontend();
        }

        /**
         * The stage of an internal application gateway definition allowing to define a private frontend.
         */
        interface WithPrivateFrontend {
            /**
             * Begins the definition of a private, or internal, application gateway frontend IP configuration.
             * @param name the name for the frontend
             * @return the first stage of a private frontend IP configuration definition
             */
            //TODO Multiple frontends are not yet supported by Azure, so this should be revisited when they are
            //TODO ApplicationGatewayPrivateFrontend.DefinitionStages.Blank<WithHttpListener> definePrivateFrontend(String name);

            /**
             * Enables a private default frontend in the subnet containing the application gateway.
             * <p>
             * A frontend with the name "default" will be created if needed.
             * @return the next stage of the definition
             */
            WithHttpListener withPrivateFrontend();

            /**
             * Enables a private frontend in the subnet containing the application gateway.
             * @param frontendName the name for the frontend to create
             * @return the next stage of the definition
             */
            //TODO Multiple frontends are not yet supported by Azure, so this should be revisited when they are
            //TODO WithHttpListener withPrivateFrontend(String frontendName);
        }

        /**
         * The stage of an internal application gateway definition allowing to optionally define a private,
         * or internal, frontend IP configuration.
         */
        interface WithPrivateFrontendOptional extends WithPrivateFrontend {
            /**
             * Specifies that no private, or internal, frontend should be enabled.
             * @return the next stage of the definition
             */
            @Method
            WithHttpListener withoutPrivateFrontend();
        }

        /**
         * The stage of an application gateway definition allowing to add an HTTP listener.
         */
        interface WithHttpListener {
            /**
             * Begins the definition of a new application gateway HTTP listener to be attached to the gateway.
             * @param name a unique name for the HTTP listener
             * @return the first stage of the HTTP listener definition
             */
            ApplicationGatewayFrontendHttpListener.DefinitionStages.Blank<WithHttpListenerOrBackend> defineFrontendHttpListener(String name);

            /**
             * Associates a new frontend HTTP listener with the specified port number and an automatically generated name,
             * if no listener associated with the specified frontend port already exists.
             * @param portNumber an unused frontend port number
             * @return the next stage of the definition
             */
            WithHttpListenerOrBackend withFrontendHttpListenerOnPort(int portNumber);

            /**
             * Associates a new frontend HTTP listener with the specified port number and the specified name,
             * if neither this port number nor name is already taken.
             * @param portNumber a frontend port number
             * @param name the name for the new listener
             * @return the next stage of the definition, or null if there is a name or port number conflict with an existing listener
             */
            WithHttpListenerOrBackend withFrontendHttpListenerOnPort(int portNumber, String name);
        }

        /**
         * The stage of an application gateway definition allowing to add a frontend port.
         */
        interface WithFrontendPort {
            /**
             * Creates a port with an autogenerated name.
             * @param portNumber a port number
             * @return the next stage of the definition
             */
            WithCreate withFrontendPort(int portNumber);

            /**
             * Creates a port.
             * @param portNumber a port number
             * @param name the name to assign to the port
             * @return the next stage of the definition
             */
            WithCreate withFrontendPort(int portNumber, String name);
        }

        /**
         * The stage of an application gateway definition allowing to add an SSL certificate.
         */
        interface WithSslCert {
            /**
             * Begins the definition of a new application gateway SSL certificate to be attached to the gateway.
             * @param name a unique name for the certificate
             * @return the first stage of the certificate definition
             */
            ApplicationGatewaySslCertificate.DefinitionStages.Blank<WithCreate> defineSslCertificate(String name);
        }

        /**
         * The stage of an application gateway definition allowing to add a backend.
         */
        interface WithBackend {
            /**
             * Begins the definition of a new application gateway backend to be attached to the gateway.
             * @param name a unique name for the backend
             * @return the first stage of the backend definition
             */
            ApplicationGatewayBackend.DefinitionStages.Blank<WithBackendOrHttpConfig> defineBackend(String name);

            /**
             * Adds an IP address to the default backend.
             * <p>
             * A backend with the name "default" will be created if needed.
             * @param ipAddress an IP address
             * @return the next stage of the definition
             */
            WithBackendOrHttpConfig withBackendIpAddress(String ipAddress);

            /**
             * Adds an FQDN (fully qualified domain name) to the default backend.
             * <p>
             * A backend with the name "default" will be created if needed.
             * @param fqdn a fully qualified domain name
             * @return the next stage of the definition
             */
            WithBackendOrHttpConfig withBackendFqdn(String fqdn);

            /**
             * Adds an IP address to a backend.
             * @param ipAddress an IP address
             * @param backendName the name for the backend to add the address to
             * @return the next stage of the definition
             */
            WithBackendOrHttpConfig withBackendIpAddress(String ipAddress, String backendName);

            /**
             * Adds an FQDN (fully qualified domain name) to a backend.
             * @param fqdn a fully qualified domain name
             * @param backendName the name for the backend to add the FQDN to
             * @return the next stage of the definition
             */
            WithBackendOrHttpConfig withBackendFqdn(String fqdn, String backendName);
        }

        /**
         * The stage of an application gateway definition allowing to continue adding more backends
         * or start defining backend HTTP configurations.
         */
        interface WithBackendOrHttpConfig extends WithBackend, WithBackendHttpConfig {
        }

        /**
         * The stage of an application gateway definition allowing to add a backend HTTP configuration.
         */
        interface WithBackendHttpConfig {
            /**
             * Begins the definition of a new application gateway backend HTTP configuration to be attached to the gateway.
             * @param name a unique name for the backend HTTP configuration
             * @return the first stage of the backend HTTP configuration definition
             */
            ApplicationGatewayBackendHttpConfiguration.DefinitionStages.Blank<WithBackendHttpConfigOrRequestRoutingRule> defineBackendHttpConfiguration(String name);

            /**
             * Adds a backend HTTP configuration with the specified backend port that the backend will be receiving traffic on and an automatically generated name.
             * @param portNumber the port number for the backend HTTP configuration
             * @return the next stage of the definition
             */
            WithBackendHttpConfigOrRequestRoutingRule withBackendHttpConfigurationOnPort(int portNumber);

            /**
             * Adds a backend HTTP configuration with the specified backend port that the backend will be receiving traffic on
             * and the specified name that can be referenced from request routing rules.
             * @param portNumber the private port number for the backend to listen on
             * @param backendHttpConfigurationName the name for the backend HTTP settings configuration
             * @return the next stage of the definition
             */
            WithBackendHttpConfigOrRequestRoutingRule withBackendHttpConfigurationOnPort(int portNumber, String backendHttpConfigurationName);
        }

        /**
         * The stage of an application gateway definition allowing to continue adding more backend
         * HTTP configurations or start adding request routing rules.
         */
        interface WithBackendHttpConfigOrRequestRoutingRule extends WithBackendHttpConfig, WithRequestRoutingRule {
        }

        /**
         * The stage of an application gateway definition allowing to continue adding more HTTP listeners,
         * or start specifying backends.
         */
        interface WithHttpListenerOrBackend extends WithHttpListener, WithBackend {
        }

        /**
         * The stage of an application gateway definition allowing to add a request routing rule.
         */
        interface WithRequestRoutingRule {
            /**
             * Begins the definition of a new application gateway request routing rule to be attached to the gateway.
             * @param name a unique name for the request routing rule
             * @return the first stage of the request routing rule
             */
            ApplicationGatewayRequestRoutingRule.DefinitionStages.Blank<WithRequestRoutingRuleOrCreate> defineRequestRoutingRule(String name);
        }

        /**
         * The stage of an application gateway definition allowing to continue adding more request routing rules,
         * or start specifying optional settings, or create the resource.
         */
        interface WithRequestRoutingRuleOrCreate extends WithRequestRoutingRule, WithCreate {
        }

        /**
         * The stage of an application gateway definition allowing to specify the SKU.
         */
        interface WithSku {
            /**
             * Specifies the SKU of the application gateway to create.
             * @param skuName an application gateway SKU name
             * @param capacity the capacity of the SKU, between 1 and 10
             * @return the next stage of the definition
             */
            WithContainingSubnet withSku(ApplicationGatewaySkuName skuName, int capacity);
        }

        /**
         * The stage of an application gateway definition allowing to specify the subnet the app gateway is getting
         * its private IP address from.
         */
        interface WithContainingSubnet {
            /**
             * Specifies the default subnet the application gateway gets its private IP address from.
             * <p>
             * This will create an IP configuration named "default".
             * @param subnet an existing subnet
             * @return the next stage of the definition
             */
            WithPublicFrontend withContainingSubnet(Subnet subnet);

            /**
             * Specifies the default subnet the application gateway gets its private IP address from.
             * <p>
             * This will create an IP configuration named "default".
             * @param network the virtual network the subnet is part of
             * @param subnetName the name of a subnet within the selected network
             * @return the next stage of the definition
             */
            WithPublicFrontend withContainingSubnet(Network network, String subnetName);

            /**
             * Specifies the default subnet the application gateway gets its private IP address from.
             * <p>
             * This will create an IP configuration named "default".
             * @param networkResourceId the resource ID of the virtual network the subnet is part of
             * @param subnetName the name of a subnet within the selected network
             * @return the next stage of the definition
             */
            WithPublicFrontend withContainingSubnet(String networkResourceId, String subnetName);

            /**
             * Begins the definition of a new IP configuration to add to this application gateway.
             * @param name a name to assign to the IP configuration
             * @return the first stage of the IP configuration definition
             */
            ApplicationGatewayIpConfiguration.DefinitionStages.Blank<WithPublicFrontend> defineIpConfiguration(String name);
        }

        /**
         * The stage of an application gateway definition containing all the required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allowing
         * for any other optional settings to be specified.
         */
        interface WithCreate extends
            Creatable<ApplicationGateway>,
            Resource.DefinitionWithTags<WithCreate>,
            WithSslCert,
            WithFrontendPort {
        }
    }

    /**
     * Grouping of application gateway update stages.
     */
    interface UpdateStages {
        /**
         * The stage of an application gateway update allowing to modify IP configurations.
         */
        interface WithIpConfig {
            /**
             * Removes the specified IP configuration.
             * <p>
             * Note that removing an IP configuration referenced by other settings may break the application gateway.
             * Also, there must be at least one IP configuration for the application gateway to function.
             * @param ipConfigurationName the name of the IP configuration to remove
             * @return the next stage of the update
             */
            Update withoutIpConfiguration(String ipConfigurationName);

            // TODO Other IP config updates...
        }
        /**
         * The stage of an application gateway update allowing to modify backends.
         */
        interface WithBackend {
            /**
             * Begins the definition of a new application gateway backend to be attached to the gateway.
             * @param name a unique name for the backend
             * @return the first stage of the backend definition
             */
            ApplicationGatewayBackend.UpdateDefinitionStages.Blank<Update> defineBackend(String name);

            /**
             * Adds an IP address to the default backend.
             * <p>
             * A backend with the name "default" will be created if needed.
             * @param ipAddress an IP address
             * @return the next stage of the update
             */
            Update withBackendIpAddress(String ipAddress);

            /**
             * Adds an FQDN (fully qualified domain name) to the default backend.
             * <p>
             * A backend with the name "default" will be created if needed.
             * @param fqdn a fully qualified domain name
             * @return the next stage of the update
             */
            Update withBackendFqdn(String fqdn);

            /**
             * Adds an IP address to a backend.
             * @param ipAddress an IP address
             * @param backendName the name for the backend to add the address to
             * @return the next stage of the update
             */
            Update withBackendIpAddress(String ipAddress, String backendName);

            /**
             * Adds an FQDN (fully qualified domain name) to a backend.
             * @param fqdn a fully qualified domain name
             * @param backendName the name for the backend to add the FQDN to
             * @return the next stage of the update
             */
            Update withBackendFqdn(String fqdn, String backendName);

            /**
             * Ensures the specified fully qualified domain name (FQDN) is not associated with any backend.
             * @param fqdn a fully qualified domain name (FQDN)
             * @return the next stage of the update
             */
            Update withoutBackendFqdn(String fqdn);

            /**
             * Ensures the specified IP address is not associated with any backend.
             * @param ipAddress an IP address
             * @return the next stage of the update
             */
            Update withoutBackendIpAddress(String ipAddress);

            /**
            /**
             * Removes the specified backend.
             * <p>
             * Note that removing a backend referenced by other settings may break the application gateway.
             * @param backendName the name of an existing backend on this application gateway
             * @return the next stage of the update
             */
            Update withoutBackend(String backendName);

            /**
             * Begins the update of an existing backend on this application gateway.
             * @param name the name of the backend
             * @return the first stage of an update of the backend
             */
            ApplicationGatewayBackend.Update updateBackend(String name);
        }

        /**
         * The stage of an application gateway update allowing to modify frontends.
         */
        interface WithFrontend {
            /**
             * Removes the specified frontend IP configuration.
             * <p>
             * Note that removing a frontend referenced by other settings may break the application gateway.
             * @param frontendName the name of the frontend IP configuration to remove
             * @return the next stage of the update
             */
            Update withoutFrontend(String frontendName);

            // TODO Other frontend updates...
        }

        /**
         * The stage of an application gateway definition allowing to modify frontend ports.
         */
        interface WithFrontendPort {
            /**
             * Creates a port with an auto-generated name.
             * @param portNumber a port number
             * @return the next stage of the definition
             */
            Update withFrontendPort(int portNumber);

            /**
             * Creates a port.
             * @param portNumber a port number
             * @param name the name to assign to the port
             * @return the next stage of the definition
             */
            Update withFrontendPort(int portNumber, String name);

            /**
             * Removes the specified frontend port.
             * <p>
             * Note that removing a frontend port referenced by other settings may break the appllication gateway.
             * @param name the name of the frontend port to remove
             * @return the next stage of the update
             */
            Update withoutFrontendPort(String name);

            /**
             * Removes the specified frontend port.
             * <p>
             * Note that removing a frontend port referenced by other settings may break the appllication gateway.
             * @param portNumber the port number of the frontend port to remove
             * @return the next stage of the update
             */
            Update withoutFrontendPort(int portNumber);
        }

        /**
         * The stage of an application gateway update allowing to modify the SKU.
         */
        interface WithSku {
            /**
             * Specifies the SKU of the application gateway.
             * @param skuName an application gateway SKU name
             * @param capacity the capacity of the SKU, between 1 and 10
             * @return the next stage of the update
             */
            Update withSku(ApplicationGatewaySkuName skuName, int capacity);
        }

        /**
         * The stage of an application gateway update allowing to modify SSL certificates.
         */
        interface WithSslCert {
            /**
             * Begins the definition of a new application gateway SSL certificate to be attached to the gateway.
             * @param name a unique name for the certificate
             * @return the first stage of the certificate definition
             */
            ApplicationGatewaySslCertificate.UpdateDefinitionStages.Blank<Update> defineSslCertificate(String name);

            /**
             * Removes the specified SSL certificate from the application gateway.
             * <p>
             * Note that removing a certificate referenced by other settings may break the application gateway
             * @param name the name of the certificate to remove
             * @return the next stage of the update
             */
            Update withoutCertificate(String name);
        }

        /**
         * The stage of an application gateway update allowing to modify HTTP listeners.
         */
        interface WithHttpListener {
            /**
             * Begins the definition of a new application gateway HTTP listener to be attached to the gateway.
             * @param name a unique name for the HTTP listener
             * @return the first stage of the HTTP listener definition
             */
            ApplicationGatewayFrontendHttpListener.UpdateDefinitionStages.Blank<Update> defineFrontendHttpListener(String name);

            /**
             * Associates a new frontend HTTP listener with the specified port number and an automatically generated name,
             * if no listener associated with the specified frontend port already exists.
             * @param portNumber an unused frontend port number
             * @return the next stage of the definition
             */
            Update withFrontendHttpListenerOnPort(int portNumber);

            /**
             * Associates a new frontend HTTP listener with the specified port number and the specified name,
             * if neither this port number nor name is already taken.
             * @param portNumber a frontend port number
             * @param name the name for the new listener
             * @return the next stage of the definition, or null if there is a name or port number conflict with an existing listener
             */
            Update withFrontendHttpListenerOnPort(int portNumber, String name);

            /**
             * Removes a frontend HTTP listener from the application gateway.
             * <p>
             * Note that removing a listener referenced by other settings may break the application gateway.
             * @param name the name of the listener to remove
             * @return the next stage of the update
             */
            Update withoutFrontendHttpListener(String name);
        }

        /**
         * The stage of an application gateway update allowing to modify backend HTTP configurations.
         */
        interface WithBackendHttpConfig {
            /**
             * Adds a backend HTTP configuration with the specified backend port that the backend will be receiving traffic on and an automatically generated name.
             * @param portNumber the port number for the backend HTTP configuration
             * @return the next stage of the update
             */
            Update withBackendHttpConfigurationOnPort(int portNumber);

            /**
             * Adds a backend HTTP configuration with the specified backend port that the backend will be receiving traffic on
             * and the specified name that can be referenced from request routing rules.
             * @param portNumber the private port number for the backend to listen on
             * @param backendHttpConfigurationName the name for the backend HTTP settings configuration
             * @return the next stage of the update
             */
            Update withBackendHttpConfigurationOnPort(int portNumber, String backendHttpConfigurationName);

            /**
             * Begins the definition of a new application gateway backend HTTP configuration to be attached to the gateway.
             * @param name a unique name for the backend HTTP configuration
             * @return the first stage of the backend HTTP configuration definition
             */
            ApplicationGatewayBackendHttpConfiguration.UpdateDefinitionStages.Blank<Update> defineBackendHttpConfiguration(String name);

            /**
             * Removes the specified backend HTTP configuration from this application gateway.
             * @param name the name of an existing HTTP configuration on this application gateway
             * @return the next stage of the update
             */
            Update withoutBackendHttpConfiguration(String name);

            /**
             * Begins the update of a backend HTTP configuration.
             * @param name the name of an existing backend HTTP configuration on this application gateway
             * @return the next stage of the update
             */
            ApplicationGatewayBackendHttpConfiguration.Update updateBackendHttpConfiguration(String name);
        }

        /**
         * The stage of an application gateway update allowing to modify request routing rules.
         */
        interface WithRequestRoutingRule {
            /**
             * Begins the definition of a new application gateway request routing rule to be attached to the gateway.
             * @param name a unique name for the request routing rule
             * @return the first stage of the request routing rule
             */
            ApplicationGatewayRequestRoutingRule.UpdateDefinitionStages.Blank<Update> defineRequestRoutingRule(String name);

            /**
             * Removes a request routing rule from the application gateway.
             * @param name the name of the request routing rule to remove
             * @return the next stage of the update
             */
            Update withoutRequestRoutingRule(String name);
        }
    }

    /**
     * The template for an application gateway update operation, containing all the settings that
     * can be modified.
     * <p>
     * Call {@link Update#apply()} to apply the changes to the resource in Azure.
     */
    interface Update extends
        Appliable<ApplicationGateway>,
        Resource.UpdateWithTags<Update>,
        UpdateStages.WithSku,
        UpdateStages.WithBackend,
        UpdateStages.WithBackendHttpConfig,
        UpdateStages.WithIpConfig,
        UpdateStages.WithFrontend,
        UpdateStages.WithFrontendPort,
        UpdateStages.WithSslCert,
        UpdateStages.WithHttpListener,
        UpdateStages.WithRequestRoutingRule {
    }
}
