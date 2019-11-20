/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.servicebus.v2017_04_01;

import com.microsoft.azure.arm.collection.SupportsCreating;
import rx.Completable;
import rx.Observable;
import com.microsoft.azure.management.servicebus.v2017_04_01.implementation.DisasterRecoveryConfigsInner;
import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.servicebus.v2017_04_01.DisasterRecoveryConfigNamespaceSBAuthorizationRule;

/**
 * Type representing DisasterRecoveryConfigs.
 */
public interface DisasterRecoveryConfigs extends SupportsCreating<ArmDisasterRecovery.DefinitionStages.Blank>, HasInner<DisasterRecoveryConfigsInner> {
    /**
     * Check the give namespace name availability.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param namespaceName The namespace name
     * @param name The Name to check the namespace name availability and The namespace name can contain only letters, numbers, and hyphens. The namespace must start with a letter, and it must end with a letter or number.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<CheckNameAvailabilityResult> checkNameAvailabilityMethodAsync(String resourceGroupName, String namespaceName, String name);

    /**
     * This operation disables the Disaster Recovery and stops replicating changes from primary to secondary namespaces.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param namespaceName The namespace name
     * @param alias The Disaster Recovery configuration name
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable breakPairingAsync(String resourceGroupName, String namespaceName, String alias);

    /**
     * Invokes GEO DR failover and reconfigure the alias to point to the secondary namespace.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param namespaceName The namespace name
     * @param alias The Disaster Recovery configuration name
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable failOverAsync(String resourceGroupName, String namespaceName, String alias);

    /**
     * Retrieves Alias(Disaster Recovery configuration) for primary or secondary namespace.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param namespaceName The namespace name
     * @param alias The Disaster Recovery configuration name
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ArmDisasterRecovery> getAsync(String resourceGroupName, String namespaceName, String alias);

    /**
     * Gets all Alias(Disaster Recovery configurations).
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param namespaceName The namespace name
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ArmDisasterRecovery> listAsync(final String resourceGroupName, final String namespaceName);

    /**
     * Deletes an Alias(Disaster Recovery configuration).
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param namespaceName The namespace name
     * @param alias The Disaster Recovery configuration name
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable deleteAsync(String resourceGroupName, String namespaceName, String alias);

    /**
     * Gets an authorization rule for a namespace by rule name.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param namespaceName The namespace name
     * @param alias The Disaster Recovery configuration name
     * @param authorizationRuleName The authorization rule name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<DisasterRecoveryConfigNamespaceSBAuthorizationRule> getAuthorizationRuleAsync(String resourceGroupName, String namespaceName, String alias, String authorizationRuleName);

    /**
     * Gets the authorization rules for a namespace.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param namespaceName The namespace name
     * @param alias The Disaster Recovery configuration name
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<DisasterRecoveryConfigNamespaceSBAuthorizationRule> listAuthorizationRulesAsync(final String resourceGroupName, final String namespaceName, final String alias);

    /**
     * Gets the primary and secondary connection strings for the namespace.
     *
     * @param resourceGroupName Name of the Resource group within the Azure subscription.
     * @param namespaceName The namespace name
     * @param alias The Disaster Recovery configuration name
     * @param authorizationRuleName The authorization rule name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<AccessKeys> listKeysAsync(String resourceGroupName, String namespaceName, String alias, String authorizationRuleName);

}