package com.challenge.desafio;

import java.math.BigDecimal;
import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;
import java.lang.reflect.Field;


public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object o) {

        return this.calcularValores(o, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object o) {

        return calcularValores(o, Subtrair.class).abs();
    }

    @Override
    public BigDecimal totalizar(Object o) {

        return somar(o).subtract(subtrair(o));

    }

    private BigDecimal calcularValores(Object o, Class annotation) {
        
        BigDecimal total = BigDecimal.ZERO;
        Field[] classe = o.getClass().getDeclaredFields();

        for (Field field : classe) {
            if(field.getType().equals(BigDecimal.class) && field.isAnnotationPresent(annotation)){
                field.setAccessible(true);
                try {
                    if(annotation.equals(Somar.class)){
                        total = total.add((BigDecimal) field.get(o));
                        continue;
                    }else if(annotation.equals(Subtrair.class)){
                        total = total.subtract((BigDecimal) field.get(o));
                    }
                    
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return total;
      
    }
  
}