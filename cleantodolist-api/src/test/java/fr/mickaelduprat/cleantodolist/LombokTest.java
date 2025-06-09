package fr.mickaelduprat.cleantodolist;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Getter
@Setter
public class LombokTest {
    private String test;

    @Nested
    class LombokTestUnitTest {

        @Test
        void testGetterAndSetter() {
            LombokTest lombokTest = new LombokTest();

            String testValue = "Valeur de test";
            lombokTest.setTest(testValue);

            assertEquals(testValue, lombokTest.getTest(), "Le getter doit retourner la valeur définie par le setter.");
        }

        @Test
        void testDefaultConstructor() {
            LombokTest lombokTest = new LombokTest();

            assertNull(lombokTest.getTest(), "Le champ test doit être null par défaut.");
        }
    }
}
