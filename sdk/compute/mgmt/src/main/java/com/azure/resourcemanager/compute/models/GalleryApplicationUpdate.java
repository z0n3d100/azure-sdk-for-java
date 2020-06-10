// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** The GalleryApplicationUpdate model. */
@JsonFlatten
@Fluent
public class GalleryApplicationUpdate extends UpdateResourceAutoGenerated {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(GalleryApplicationUpdate.class);

    /*
     * The description of this gallery Application Definition resource. This
     * property is updatable.
     */
    @JsonProperty(value = "properties.description")
    private String description;

    /*
     * The Eula agreement for the gallery Application Definition.
     */
    @JsonProperty(value = "properties.eula")
    private String eula;

    /*
     * The privacy statement uri.
     */
    @JsonProperty(value = "properties.privacyStatementUri")
    private String privacyStatementUri;

    /*
     * The release note uri.
     */
    @JsonProperty(value = "properties.releaseNoteUri")
    private String releaseNoteUri;

    /*
     * The end of life date of the gallery Application Definition. This
     * property can be used for decommissioning purposes. This property is
     * updatable.
     */
    @JsonProperty(value = "properties.endOfLifeDate")
    private OffsetDateTime endOfLifeDate;

    /*
     * This property allows you to specify the supported type of the OS that
     * application is built for. <br><br> Possible values are: <br><br>
     * **Windows** <br><br> **Linux**
     */
    @JsonProperty(value = "properties.supportedOSType")
    private OperatingSystemTypes supportedOSType;

    /**
     * Get the description property: The description of this gallery Application Definition resource. This property is
     * updatable.
     *
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: The description of this gallery Application Definition resource. This property is
     * updatable.
     *
     * @param description the description value to set.
     * @return the GalleryApplicationUpdate object itself.
     */
    public GalleryApplicationUpdate withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the eula property: The Eula agreement for the gallery Application Definition.
     *
     * @return the eula value.
     */
    public String eula() {
        return this.eula;
    }

    /**
     * Set the eula property: The Eula agreement for the gallery Application Definition.
     *
     * @param eula the eula value to set.
     * @return the GalleryApplicationUpdate object itself.
     */
    public GalleryApplicationUpdate withEula(String eula) {
        this.eula = eula;
        return this;
    }

    /**
     * Get the privacyStatementUri property: The privacy statement uri.
     *
     * @return the privacyStatementUri value.
     */
    public String privacyStatementUri() {
        return this.privacyStatementUri;
    }

    /**
     * Set the privacyStatementUri property: The privacy statement uri.
     *
     * @param privacyStatementUri the privacyStatementUri value to set.
     * @return the GalleryApplicationUpdate object itself.
     */
    public GalleryApplicationUpdate withPrivacyStatementUri(String privacyStatementUri) {
        this.privacyStatementUri = privacyStatementUri;
        return this;
    }

    /**
     * Get the releaseNoteUri property: The release note uri.
     *
     * @return the releaseNoteUri value.
     */
    public String releaseNoteUri() {
        return this.releaseNoteUri;
    }

    /**
     * Set the releaseNoteUri property: The release note uri.
     *
     * @param releaseNoteUri the releaseNoteUri value to set.
     * @return the GalleryApplicationUpdate object itself.
     */
    public GalleryApplicationUpdate withReleaseNoteUri(String releaseNoteUri) {
        this.releaseNoteUri = releaseNoteUri;
        return this;
    }

    /**
     * Get the endOfLifeDate property: The end of life date of the gallery Application Definition. This property can be
     * used for decommissioning purposes. This property is updatable.
     *
     * @return the endOfLifeDate value.
     */
    public OffsetDateTime endOfLifeDate() {
        return this.endOfLifeDate;
    }

    /**
     * Set the endOfLifeDate property: The end of life date of the gallery Application Definition. This property can be
     * used for decommissioning purposes. This property is updatable.
     *
     * @param endOfLifeDate the endOfLifeDate value to set.
     * @return the GalleryApplicationUpdate object itself.
     */
    public GalleryApplicationUpdate withEndOfLifeDate(OffsetDateTime endOfLifeDate) {
        this.endOfLifeDate = endOfLifeDate;
        return this;
    }

    /**
     * Get the supportedOSType property: This property allows you to specify the supported type of the OS that
     * application is built for. &lt;br&gt;&lt;br&gt; Possible values are: &lt;br&gt;&lt;br&gt; **Windows**
     * &lt;br&gt;&lt;br&gt; **Linux**.
     *
     * @return the supportedOSType value.
     */
    public OperatingSystemTypes supportedOSType() {
        return this.supportedOSType;
    }

    /**
     * Set the supportedOSType property: This property allows you to specify the supported type of the OS that
     * application is built for. &lt;br&gt;&lt;br&gt; Possible values are: &lt;br&gt;&lt;br&gt; **Windows**
     * &lt;br&gt;&lt;br&gt; **Linux**.
     *
     * @param supportedOSType the supportedOSType value to set.
     * @return the GalleryApplicationUpdate object itself.
     */
    public GalleryApplicationUpdate withSupportedOSType(OperatingSystemTypes supportedOSType) {
        this.supportedOSType = supportedOSType;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
