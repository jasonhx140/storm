/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.storm.mongodb.common;

import com.mongodb.client.model.Filters;

import java.util.List;

import org.apache.storm.tuple.ITuple;
import org.bson.conversions.Bson;

public class SimpleQueryFilterCreator implements QueryFilterCreator {

    private String field;
    
    @Override
    public Bson createFilter(ITuple tuple) {
        return Filters.eq(field, tuple.getValueByField(field));
    }

    @Override
    public Bson createFilterByKeys(List<Object> keys) {
        return Filters.eq("_id", MongoUtils.getId(keys));
    }

    public SimpleQueryFilterCreator withField(String field) {
        this.field = field;
        return this;
    }

}
