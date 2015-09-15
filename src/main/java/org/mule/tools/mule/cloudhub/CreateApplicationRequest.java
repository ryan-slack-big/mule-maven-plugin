/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.mule.cloudhub;

public class CreateApplicationRequest
{
    public String domain;
    public String region;
    public String muleVersion;
    public Integer workers;
    public String workerType;

    // TODO: ask Dan
    public boolean persistentQueues;
    public boolean monitoringAutoRestart = true;

    public CreateApplicationRequest()
    {
    }

    public CreateApplicationRequest(String domain, String region, String muleVersion, Integer workers, String workerType)
    {
        this.domain = domain;
        this.region = region;
        this.muleVersion = muleVersion;
        this.workers = workers;
        this.workerType = workerType;
    }
}
