/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.elasticjob.lite.lifecycle.api;

import io.elasticjob.lite.lifecycle.domain.JobSettings;

/**
 * Job settings API.
 */
public interface JobSettingsAPI {
    
    /**
     * get job settings.
     *
     * @param jobName job name
     * @return job settings
     */
    JobSettings getJobSettings(String jobName);
    
    /**
     * Update job settings.
     *
     * @param jobSettings job settings
     */
    void updateJobSettings(JobSettings jobSettings);
    
    /**
     * Remove job settings.
     *
     * @param jobName job name
     */
    void removeJobSettings(String jobName);
}
