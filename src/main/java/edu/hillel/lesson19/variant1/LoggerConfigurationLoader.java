package edu.hillel.lesson19.variant1;

public interface LoggerConfigurationLoader <T extends LoggerConfiguration>{
     T load(String fileName);
}
