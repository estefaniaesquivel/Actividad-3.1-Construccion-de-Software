package com.bisiesto; 

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalendarioTest {

    @ParameterizedTest
    @ValueSource(ints = {2020, 2024, 1996})
    void esBisiesto_AniosDivisiblesEntre4NoCentenarios_RetornaTrue(int anio) {
        //Arrange(preparar)
        Calendario calendario = new Calendario();
        //Act(actuar)
        boolean resultado = calendario.esBisiesto(anio);
        //Assert(afirmar)
        assertTrue(resultado, "El año " + anio + " debería ser bisiesto");
    }

    @ParameterizedTest
    @ValueSource(ints = {2021, 2023, 1999})
    void esBisiesto_AniosNoDivisiblesEntre4_RetornaFalse(int anio) {
        //Arrange
        Calendario calendario = new Calendario();
        //Act
        boolean resultado = calendario.esBisiesto(anio);
        //Assert
        assertFalse(resultado, "El año " + anio + " no debería ser bisiesto");
    }

    @Test
    void esBisiesto_CentenarioNoDivisibleEntre400_RetornaFalse() {
        //Arrange
        Calendario calendario = new Calendario();
        int anio = 1900;
        //Act
        boolean resultado = calendario.esBisiesto(anio);
        //Assert
        assertFalse(resultado, "El año centenario " + anio + " no debería ser bisiesto");
    }

    @Test
    void esBisiesto_CentenarioDivisibleEntre400_RetornaTrue() {
        //Arrange
        Calendario calendario = new Calendario();
        int anio = 2000;
        //Act
        boolean resultado = calendario.esBisiesto(anio);
        //Assert
        assertTrue(resultado, "El año centenario " + anio + " sí debería ser bisiesto");
    }

    @Test
    void esBisiesto_ReglaGeneralDivisibleEntre4_RetornaTrue() {
        // Arrange
        Calendario calendario = new Calendario();
        int anio = 4;
        // Act
        boolean resultado = calendario.esBisiesto(anio);
        // Assert
        assertTrue(resultado, "El año " + anio + " debería ser bisiesto al cumplir la regla general de divisibilidad entre 4");
    }
}