/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author ACER
 */
public class Sort<T extends Comparable<T>> {

    Secuencia<T> n;
    String iteraciones = "";

    public void sort(Secuencia<T> n) {
        sort(n, 0, n.getTamanio() - 1);
    }

    public void sort(Secuencia<T> n, int start, int end) {
        int i = start;
        /**
         * Indice para iniciar la búsqueda desde la izquierda *
         */
        int k = end;
        /**
         * Indice para iniciar la búsqueda desde la derecha *
         */
        if ((end - start) >= 1) {
            T pivot = n.get(start);
            /**
             * Pivote para realizar la comparación, escogemos el primer elemento
             * *
             */
            while (i < k) {
                /**
                 * Mientas el índice izquierdo sea menor al derecho *
                 */
                while (n.get(i).compareTo(pivot) <= 0 && i < end && k > i) {
                    i++;
                    /**
                     * Recorriendo desde la izquierda nos ubicamos hasta
                     * encontrar el primer elemento mayor al pivote *
                     */
                }
                while (n.get(k).compareTo(pivot) > 0 && k >= start && k >= i) {
                    k--;
                    /**
                     * Recorriendo desde la derecha nos ubicamos hasta encontrar
                     * el primer elemento menor al pivote *
                     */
                }
                if (i < k) {
                    /**
                     * Si el índice izquierdo sigue siendo menor, intercambiamos
                     * los elementos *
                     */
                    this.iteraciones += n.toString()+"\n";
                    intercambiar(n, i, k);
                }
            }
            this.iteraciones += n.toString()+"\n";
            intercambiar(n, start, k);
            this.iteraciones += n.toString()+"\n";
            sort(n, start, k - 1);
            this.iteraciones += n.toString()+"\n";
            sort(n, k + 1, end);
            this.iteraciones += n.toString()+"\n";
        } else {
            return;
            /**
             * Cuando solo quede por ordenar un elemento se sale de la función *
             */
        }
    }

    private void intercambiar(Secuencia<T> n, int i, int j) {
        T temp = n.get(i);
        n.set(i, n.get(j));
        n.set(j, temp);
    }

    public String getIteraciones() {
        return iteraciones;
    }
    
}
