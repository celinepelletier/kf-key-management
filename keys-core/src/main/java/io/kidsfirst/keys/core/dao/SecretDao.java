/*
 * Copyright 2018 Ontario Institute for Cancer Research
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.kidsfirst.keys.core.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import io.kidsfirst.keys.core.manager.DynamoDBManager;
import io.kidsfirst.keys.core.model.Secret;

import java.util.List;

public class SecretDao {

  private static final DynamoDBMapper mapper = DynamoDBManager.mapper();

  private static volatile SecretDao instance;


  private SecretDao() { }

  public static SecretDao instance() {

    if (instance == null) {
      synchronized(SecretDao.class) {
        if (instance == null)
          instance = new SecretDao();
      }
    }
    return instance;
  }

  public List<Secret> findAllSecrets() {
    return mapper.scan(Secret.class, new DynamoDBScanExpression());
  }

  public void saveOrUpdateSecret(Secret secret) {
    mapper.save(secret);
  }

}