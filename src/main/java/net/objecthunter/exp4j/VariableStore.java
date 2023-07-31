package net.objecthunter.exp4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VariableStore implements VariableProvider {

    Map<String, Double> values = new HashMap<>();
    List<VariableProvider> delegates = new LinkedList<>();

    public static VariableStore of(String ... variableNames) {
        VariableStore result = new VariableStore();
        for (String variableName : variableNames) {
            result.values.put(variableName, null);
        }
        return result;
    }

    public VariableStore() {
    }

    public VariableStore(VariableProvider delegate) {
        this.delegates.add(delegate);
    }

    @Override
    public Double get(String variableName) {
        if (values.containsKey(variableName)) {
            return values.get(variableName);
        }

        for (VariableProvider delegate : delegates) {
            if (delegate.contains(variableName)) {
                return delegate.get(variableName);
            }
        }

        return null;
    }

    @Override
    public void set(String variableName, Double value) {
        values.put(variableName, value);
    }

    @Override
    public boolean contains(String variableName) {
        if (values.containsKey(variableName)) {
            return true;
        }

        for (VariableProvider delegate : delegates) {
            if (delegate.contains(variableName)) {
                return true;
            }
        }

        return false;
    }

    public List<VariableProvider> delegates() {
        return delegates;
    }
}
