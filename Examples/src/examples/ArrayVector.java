/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

/**
 *
 * @author natasha
 */
public interface ArrayVector {
    /**
     * Задает все элементы вектора (определяет длину вектора).
     * Передаваемый массив не клонируется.
     * @param elements Не равен null
     */
    void set(double... elements);
    /**
     * Возвращает все элементы вектора. Массив не клонируется.
     */
    double[] get();
    /**
     * Возвращает копию вектора (такую, изменение элементов 
     *  в которой не приводит к изменению элементов данного вектора).<br/>
     * Рекомендуется вызвать метод clone() у самого массива или использовать
     *   {@link System#arraycopy(Object, int, Object, int, int)}.
     * @return 
     */
    ArrayVector clon();
    /**
     * Возвращает число элементов вектора.
     * @return 
     */
    int getSize();
 
    /**
     * Изменяет элемент по индексу. 
     * @param index В случае выхода индекса за пределы массива:<br/>
     *  а) если index<0, ничего не происходит;<br/>
     *  б) если index>=0, размер массива увеличивается так, чтобы index стал последним.
     */
    void set(int index, double value);
    /**
     * Возвращает элемент по индексу.
     * @param index В случае выхода индекса за пределы массива 
     *   должно генерироваться ArrayIndexOutOfBoundsException
     */
    double get(int index) throws ArrayIndexOutOfBoundsException;
 
    /**
     * Возвращает максимальный элемент вектора.
     */
    double getMax();
    /**
     * Возвращает минимальный элемент вектора.
     */
    double getMin();
    /**
     * Сортирует элементы вектора в порядке возрастания.
     */
    void sortAscending();
 
    /**
     * Умножает вектор на число.<br/>
     * Замечание: не пытайтесь использовать безиндексный цикл foreach: 
     *  для изменения элемента массива нужно знать его индекс. 
     * @param factor
     */
    void mult(double factor);
    /**
     * Складывает вектор с другим вектором, результат запоминает в элементах данного вектора.<br/>
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются<br/>
     *  (если данный вектор - больший, его размер менять не надо, просто не меняйте последние элементы).
     * @param anotherVector Не равен null
     * @return Ссылка на себя (результат сложения)
     */
    ArrayVector sum(ArrayVector anotherVector);
    /**
     * Возвращает скалярное произведение двух векторов.<br/>
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются.
     * @param anotherVector Не равен null
     */
    double scalarMult(ArrayVector anotherVector);  
    /**
     * Возвращает евклидову норму вектора (длину вектора 
     *  в n-мерном евклидовом пространстве, n={@link #getSize()}).
     * Квадрат нормы вектора равен скалярному произведению вектора на себя.
     */
    double getNorm();
}
