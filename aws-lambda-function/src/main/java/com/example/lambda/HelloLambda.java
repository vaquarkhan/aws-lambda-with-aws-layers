package com.example.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import static com.example.common.Utilities.logMessage;


public class HelloLambda implements RequestStreamHandler {
    JSONParser parser = new JSONParser();

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        LambdaLogger logger = context.getLogger();

        logMessage(logger, " LAMBDA LAYER, STARTING FUNCTION");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();
        JSONObject responseBody = new JSONObject();

        try {
            logMessage(logger, " LAMBDA LAYER, PARSING MESSAGE....");
            JSONObject data = (JSONObject) parser.parse(reader);
            String messageBody = (String) data.get("body");
            responseBody.put("response", messageBody);

        } catch (ParseException pex) {
            logMessage(logger, "Cannot parse Input data " + pex.getMessage().toString());
            responseBody.put("response", pex.getMessage());

        }

        logMessage(logger, " LAMBDA LAYER, PREPARING RESPONSE...");

        responseJson.put("isBase64Encoded", false);
        responseJson.put("statusCode", 200);
        responseJson.put("body", responseBody.toString());

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
        logMessage(logger, " LAMBDA LAYER, COMPLETED..." + responseJson.toString());

    }
}