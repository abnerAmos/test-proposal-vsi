package com.test.proposal_vsi.question_two;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Adaptador para a biblioteca de JSON
 */
public class JsonAdapter implements DataParser {
    private final JsonLibrary jsonLibrary;

    public JsonAdapter(JsonLibrary jsonLibrary) {
        this.jsonLibrary = jsonLibrary;
    }

    @Override
    public void parseData(String data) {
        String regex = "\"(.*?)\":\\s*\"(.*?)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);

        if (matcher.find()) {
            String key = matcher.group(1);
            String content = matcher.group(2);

            jsonLibrary.parseJson(key + ": " + content);
        }
    }
}
