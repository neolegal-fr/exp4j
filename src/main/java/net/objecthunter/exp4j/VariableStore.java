package net.objecthunter.exp4j;

import java.util.HashMap;
import java.util.Map;

public class VariableStore implements VariableProvider {

    Map<String, Double> variables = new HashMap<>();

    public static VariableStore of(String ... variableNames) {
        VariableStore result = new VariableStore();
        for (String variableName : variableNames) {
            result.variables.put(variableName, null);
        }
        return result;
    }

    @Override
    public Double get(String variableName) {
        return variables.get(variableName);
    }

    @Override
    public void set(String variableName, Double value) {
        variables.put(variableName, value);
    }

    @Override
    public boolean contains(String name) {
        return variables.containsKey(name);
    }
}
