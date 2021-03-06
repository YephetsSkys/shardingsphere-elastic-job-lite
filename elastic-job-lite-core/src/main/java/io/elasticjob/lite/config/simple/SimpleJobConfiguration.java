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

package io.elasticjob.lite.config.simple;

import io.elasticjob.lite.api.JobType;
import io.elasticjob.lite.config.JobCoreConfiguration;
import io.elasticjob.lite.config.JobTypeConfiguration;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 简单作业配置.
 */
@RequiredArgsConstructor
@Getter
public final class SimpleJobConfiguration implements JobTypeConfiguration {
    
    private final JobCoreConfiguration coreConfig;
    
    private final JobType jobType = JobType.SIMPLE;
    
    private final String jobClass;
}
