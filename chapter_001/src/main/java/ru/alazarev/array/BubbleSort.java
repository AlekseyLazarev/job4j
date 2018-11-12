package ru.alazarev.array;

public class BubbleSort {
    public int[] sort(int[] array) {
        for (int outindex = 0; outindex < array.length - 1; outindex++) {
            for (int index = 0; index < array.length - outindex - 1; index++) {
                int temp;
                if (array[index + 1] < array[index]) {
                    temp = array[index + 1];
                    array[index + 1] = array[index];
                    array[index] = temp;
                }
            }
        }
        return array;
    }
}
