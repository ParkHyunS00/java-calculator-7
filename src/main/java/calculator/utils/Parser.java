package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final String userInput;
    private final List<String> numbers = new ArrayList<>();

    public Parser(String userInput) {
        this.userInput = userInput;
    }

    private List<String> parseWithDefaultDelimiter() {
        String defaultDelimiter = "[,:]";
        String[] tokens = userInput.split(defaultDelimiter);

        for (String token : tokens) {
            numbers.add(token);
        }

        return numbers;
    }

    private String getDelimiter() {
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(userInput);
        String delimiter = "[,:]";

        if (matcher.find()) {
            delimiter = matcher.group(1);
        }

        return delimiter;
    }

    private boolean isCustomDelimiter() {
        return userInput.startsWith("//") && userInput.startsWith("\\n", 3);
    }
}
