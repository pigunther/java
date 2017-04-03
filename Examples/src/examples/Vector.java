package examples;
import java.util.*;
//import java.io.Serializable;
/**
 *
 * @author natasha
 */
public class Vector implements ArrayVector, Comparable<ArrayVector>{
    protected int length = 0;
    protected double[] elements = new double[0];

    public Vector(double[] elements) {
        if (elements != null) {
            this.elements = new double[elements.length];
            System.arraycopy(elements, 0, this.elements, 0, elements.length);
            this.length = elements.length;   
        }
    }

    private Vector() {
    }
   
    
    @Override
    public void set(double[] elements) {
        if (elements != null) {
            this.elements = new double[elements.length];
            System.arraycopy(elements, 0, this.elements, 0, elements.length);
            this.length = elements.length;   
        }
    }
    @Override
    public double[] get() {
        return elements;
    }
    @Override
    public ArrayVector clon(){
        ArrayVector clone = new Vector();
        //double[] arr = {1, 2};
        clone.set(this.elements);
        return clone;
            
    }

    @Override
    public int getSize() {
        return length;
    }

    @Override
    public void set(int index, double value) {
        if (index >= 0 && index < length) {
            elements[index] = value;
        } else if (index >= length) {
            double[] more_elements = new double[index+1];
            System.arraycopy(elements, 0, more_elements, 0, length);
            more_elements[index] = value;
            elements = more_elements;
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= 0 && index < length) {
            return elements[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("ERROR IN GET DOUBLE ELEMENT IN "+ index + " POSITION");
        }
        
    }

    @Override
    public double getMax() {
        if (elements != null && length != 0) {
            double max = elements[0];
            for (double e: elements) {
                if (e > max) 
                    max = e;
            }
            return max;
        }
        return 1/(-0.0);
    }

    @Override
    public double getMin() {
        if (elements != null && length != 0) {
            double min = elements[0];
            for (double e: elements) {
                if (e < min) 
                    min = e;
            }
            return min;
        }
        return 1/(0.0);
    }

    @Override
    public void sortAscending() {
        Arrays.sort(elements);
    }

    @Override
    public void mult(double factor) {
        for(int i = 0; i < length; i++) {
            elements[i] *= factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        for (int i = 0; i < Math.min(length, anotherVector.getSize()); i++) {
            elements[i] += anotherVector.get(i);
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double return_value = 0;
        for (int i = 0; i < Math.min(length, anotherVector.getSize()); i++) {
            return_value += elements[i]*anotherVector.get(i);
        }
        return return_value;
    }
    @Override
    public double getNorm() {
        return Math.sqrt(scalarMult(this));
    }
    
    @Override
    public int compareTo(ArrayVector A) {
        return (int)(this.getNorm()-A.getNorm());
    }
    
}
