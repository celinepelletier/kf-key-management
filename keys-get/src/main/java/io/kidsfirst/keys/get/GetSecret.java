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

package io.kidsfirst.keys.get;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class GetSecret implements RequestStreamHandler {

  private static JSONParser parser = new JSONParser();

  public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

    JSONObject responseJson;

    try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8")) {

      JSONObject event = (JSONObject)parser.parse(reader);
      // TODO: Implement

    } catch (ParseException p) {
      responseJson = new JSONObject();
      responseJson.put("statusCode", "400");
      responseJson.put("exception", p);
    }

  }

}
