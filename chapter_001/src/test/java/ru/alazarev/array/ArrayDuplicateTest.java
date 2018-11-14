package ru.alazarev.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Aleksey Lazarev
 * @version 0.1
 * @since 13.11.2018
 */
public class ArrayDuplicateTest {
    /**
     * Test remove method.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] beforeRemoveArray = {"Привет", "Мир", "Привет", "Привет", "Привет", "Супер", "Мир", "Соль", "Пароль", "Контора", "Соль"};
        String[] result = ad.remove(beforeRemoveArray);
        String[] expect = {"Привет", "Мир", "Супер", "Соль", "Пароль", "Контора"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}