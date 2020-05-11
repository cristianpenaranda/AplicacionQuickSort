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
        this.iteraciones += n.toString()+"\n";
        int i = start;
        int k = end;
        if ((end - start) >= 1) {
            T pivot = n.get(start);
            while (i < k) {
                while (n.get(i).compareTo(pivot) <= 0 && i < end && k > i) {
                    i++;
                }
                while (n.get(k).compareTo(pivot) > 0 && k >= start && k >= i) {
                    k--;
                }
                if (i < k) {
                    intercambiar(n, i, k);
                }
            }
            
            intercambiar(n, start, k);
            sort(n, start, k - 1);
            sort(n, k + 1, end);
        } else {
            return;
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
