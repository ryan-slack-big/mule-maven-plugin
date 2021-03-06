/*
 * Mule ESB Maven Tools
 * <p>
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * <p>
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.tools.model.anypoint;

import org.apache.maven.plugins.annotations.Parameter;
import org.mule.tools.client.core.exception.DeploymentException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.System.getProperty;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class CloudHubDeployment extends AnypointDeployment {

  @Parameter
  protected Integer workers;

  @Parameter
  protected String workerType;

  @Parameter
  protected String region;

  @Parameter
  protected Map<String, String> properties = new HashMap<>();

  /**
   * Region to deploy the application in Cloudhub.
   *
   * @since 2.0
   */
  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  /**
   * Number of workers for the deploymentConfiguration of the application in Cloudhub.
   *
   * @since 2.0
   */
  public Optional<Integer> getWorkers() {
    return Optional.ofNullable(workers);
  }

  public void setWorkers(Integer workers) {
    this.workers = workers;
  }

  /**
   * Type of workers for the deploymentConfiguration of the application in Cloudhub.
   *
   * @since 2.0
   */
  public String getWorkerType() {
    return workerType;
  }

  public void setWorkerType(String workerType) {
    this.workerType = workerType;
  }

  /**
   * CloudHub properties.
   *
   * @since 2.0
   *
   */
  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

  public void setEnvironmentSpecificValues() throws DeploymentException {
    super.setEnvironmentSpecificValues();

    String cloudHubWorkers = getProperty("cloudhub.workers");
    if (isNotBlank(cloudHubWorkers)) {
      setWorkers(Integer.valueOf(cloudHubWorkers));
    }
    if (!getWorkers().isPresent()) {
      setWorkers(Integer.valueOf("1"));
    }

    String cloudHubWorkerType = getProperty("cloudhub.workerType");
    if (isNotBlank(cloudHubWorkerType)) {
      setWorkerType(cloudHubWorkerType);
    }
    if (isBlank(getWorkerType())) {
      setWorkerType("Micro");
    }

  }
}
