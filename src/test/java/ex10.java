import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ex10 {

    @ParameterizedTest
    @ValueSource(strings = {"qwerty","qwertyqwertyqwertyqwerty"})
    public void CheckShortPhrase(String line){
        assertTrue(line.length()>=15,"Sting is less then 15 symbols");
    }
}
