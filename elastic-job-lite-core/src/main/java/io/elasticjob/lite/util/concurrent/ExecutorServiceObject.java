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

package io.elasticjob.lite.util.concurrent;

import com.google.common.base.Joiner;
import com.google.common.util.concurrent.MoreExecutors;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池执行服务对象.
 */
public final class ExecutorServiceObject {
    
    private final ThreadPoolExecutor threadPoolExecutor;
    
    private final BlockingQueue<Runnable> workQueue;
    
    public ExecutorServiceObject(final String namingPattern, final int threadSize) {
        workQueue = new LinkedBlockingQueue<>();
        threadPoolExecutor = new ThreadPoolExecutor(threadSize, threadSize, 5L, TimeUnit.MINUTES, workQueue, 
                new BasicThreadFactory.Builder().namingPattern(Joiner.on("-").join(namingPattern, "%s")).build());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }
    
    /**
     * 创建线程池服务对象.
     *
     * @return 线程池服务对象
     */
    public ExecutorService createExecutorService() {
        return MoreExecutors.listeningDecorator(MoreExecutors.getExitingExecutorService(threadPoolExecutor));
    }

    /**
     * Whether the threadPoolExecutor has been shut down.
     *
     * @return Whether the threadPoolExecutor has been shut down
     */
    public boolean isShutdown() {
        return threadPoolExecutor.isShutdown();
    }
    
    /**
     * 获取当前活跃的线程数.
     *
     * @return 当前活跃的线程数
     */
    public int getActiveThreadCount() {
        return threadPoolExecutor.getActiveCount();
    }
    
    /**
     * 获取待执行任务数量.
     *
     * @return 待执行任务数量
     */
    public int getWorkQueueSize() {
        return workQueue.size();
    }
}
