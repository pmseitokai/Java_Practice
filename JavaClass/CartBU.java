/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JavaClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author INT303
 */
public class CartBU implements Serializable {
    private List<LineItem> items = null ;
    public int getSize() {
        int count = 0;
        for(LineItem lit : items) {
            count = count + lit.getQuantity() ;
        }
        return count ;
    }
    public List<LineItem> getItems() {
        return items;
    }

    public CartBU() {
        items = new ArrayList<>();
    }
    
    public void add(Book b, int qty) {
        LineItem tmp = new LineItem();
        tmp.setB(b);
        tmp.setQuantity(qty);
        int x = items.indexOf(tmp);
        if (x<0) {
            items.add(tmp);
        } else {
            LineItem lt = items.get(x);
            lt.setQuantity(qty+ lt.getQuantity());
        }
    }
    
    public void remove(Book b) {
        LineItem tmp = new LineItem();
        tmp.setB(b);
        items.remove(tmp);
    }

    public void replace(Book b, int qty) {
        LineItem tmp = new LineItem();
        tmp.setB(b);
        int index = items.indexOf(tmp) ;
        if (index>=0) {
            items.get(index).quantity = qty ;
        }
    }

    
    public class LineItem implements Serializable, Comparable<LineItem> {
        private Book b ;
        private int quantity;

        @Override
        public int hashCode() {
            int hash = 5;
            return hash;
        }

        @Override
        public boolean equals(Object objs) {
            if (objs == null) {
                return false;
            }
            if (getClass() != objs.getClass()) {
                return false;
            }
            final LineItem other = (LineItem)objs;

            if (b.getBookId().equalsIgnoreCase(other.getB().getBookId())) {
                return true;
            }else{
                return false;
            }
        }

        @Override
        public int compareTo(LineItem other) { 
            return 0;
        } 
        
        public Book getB() {
            return b;
        }

        public void setB(Book p) {
            this.b = b;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
