import java.util.*;
public class Deque{
   public static final int ALLOC = 100;
   private Object[] _deque;
   private int _front;
   private int _back;
   private int _size;
   private Scanner kb = new Scanner(System.in);
   public Deque() {
      _deque = new Object[ALLOC];
      _front = 2;
      _back = 2;
      _size = 0;
   }
   
   public void insertOnFront(Object in) {
      if(_size >= _deque.length)
          allocateMoreSpaceFromFront();
      _deque[_front] = in;
      if(_front < _deque.length - 1)
         _front++;
      else
         _front = 0;
      _size++;
   }
   
   public Object deleteFromFront() {
      if(!isEmpty()){
         if(_front > 0){
            _front--;
            _size--;
            return _deque[_front];
         }
         else{
            _front = _deque.length - 1;
            _size--;
            return _deque[_front];
         }
      }
      else 
         return null;
   }  
       
   public void insertOnBack(Object in) {
      if(_size >= _deque.length)
         allocateMoreSpaceFromBack();
      _size++;
      _back--;
      if(_back < 0)
         _back = _deque.length - 1;
      _deque[_back] = in;
   }
   
   public Object deleteFromBack() {
      if(!isEmpty()){
         if(_back < _deque.length - 1) {
            _back++;
            _size--;
            return _deque[_back + 1];
         }
         else {
            _back = 0;
            _size--;
            return _deque[_deque.length - 1];
         }
      }
      else
         return null;
   }
   
   public boolean isEmpty() {
      return (_size == 0);
   }
   
   public String toString() {
      String str = "";
      int c = _front - 1;
      if(!isEmpty()) {
         for(int i = 0; i < _size; ++i, --c) {
            if(c < 0)
               c = _deque.length - 1;
            str += _deque[c] + " ";
         }
      }
      return str;
   }
   public String toStore() {
      String str = "";
      if(!isEmpty()) {
         for(int i = 0; i < _deque.length; i++) {
            str = str + " " + _deque[i];
         }
      }
      return str;
   }
   
   public void allocateMoreSpaceFromFront() {
      Object[] temp = new Object[_deque.length + ALLOC];
      int c = _front ;
      for(int i = 0; i <= _size; i++, c++) {
         if(c >= _deque.length)
            c = 0;
         temp[i] = _deque[c];
      }
       _front = _deque.length;
       _back = _size;
      _deque = temp;
   }
   
   public void allocateMoreSpaceFromBack() {
      Object[] temp = new Object[_deque.length + ALLOC];
      int c = _front - 1;
      int k = 0;
      for(int i = temp.length - 1; k < _size && i > 0; i--, c--, k++) {
         if(c < 0)
            c = _size - 1;
         temp[i] = _deque[c];
      }
      _front = temp.length;
      _back = _size;
      _deque = temp;
      
   }

}