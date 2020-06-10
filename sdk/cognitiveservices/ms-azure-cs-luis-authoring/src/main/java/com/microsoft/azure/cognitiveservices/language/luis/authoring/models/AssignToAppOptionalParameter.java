/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.language.luis.authoring.models;


/**
 * The AssignToAppOptionalParameter model.
 */
public class AssignToAppOptionalParameter {
    /**
     * The Azure account information object.
     */
    private AzureAccountInfoObject azureAccountInfoObject;

    /**
     * Gets or sets the preferred language for the response.
     */
    private String thisclientacceptLanguage;

    /**
     * Get the azureAccountInfoObject value.
     *
     * @return the azureAccountInfoObject value
     */
    public AzureAccountInfoObject azureAccountInfoObject() {
        return this.azureAccountInfoObject;
    }

    /**
     * Set the azureAccountInfoObject value.
     *
     * @param azureAccountInfoObject the azureAccountInfoObject value to set
     * @return the AssignToAppOptionalParameter object itself.
     */
    public AssignToAppOptionalParameter withAzureAccountInfoObject(AzureAccountInfoObject azureAccountInfoObject) {
        this.azureAccountInfoObject = azureAccountInfoObject;
        return this;
    }

    /**
     * Get the thisclientacceptLanguage value.
     *
     * @return the thisclientacceptLanguage value
     */
    public String thisclientacceptLanguage() {
        return this.thisclientacceptLanguage;
    }

    /**
     * Set the thisclientacceptLanguage value.
     *
     * @param thisclientacceptLanguage the thisclientacceptLanguage value to set
     * @return the AssignToAppOptionalParameter object itself.
     */
    public AssignToAppOptionalParameter withThisclientacceptLanguage(String thisclientacceptLanguage) {
        this.thisclientacceptLanguage = thisclientacceptLanguage;
        return this;
    }

}
