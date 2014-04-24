/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.webbeans.portable;

import java.util.Collections;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.EventMetadata;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.Producer;

import org.apache.webbeans.context.creational.CreationalContextImpl;

public class EventMetadataProducer implements Producer<EventMetadata>
{
    @Override
    public EventMetadata produce(CreationalContext<EventMetadata> creationalContext)
    {
        if (!(creationalContext instanceof CreationalContextImpl))
        {
            // TODO What to do here?
            throw new IllegalStateException("EventMetadataProducer does work only with CreationalContextImpl");
        }
        CreationalContextImpl<EventMetadata> contextImpl = (CreationalContextImpl<EventMetadata>)creationalContext;
        return contextImpl.getEventMetadata();
    }

    @Override
    public Set<InjectionPoint> getInjectionPoints()
    {
        return Collections.emptySet();
    }
    
    @Override
    public void dispose(EventMetadata event)
    {
    }
}