package net.objecthunter.exp4j;

public interface VariableProvider {
    Double get(String variable);
    void set(String variable, Double value);
    boolean contains(String name);
}
