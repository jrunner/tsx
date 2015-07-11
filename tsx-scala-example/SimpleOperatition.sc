(x:Int) => x + 1

val add = (x:Int) => x + 1

add(1)

val list = List(1,2,3,6,9)

list.map(add)

class Book[T,C](val t:T,val c:C){

}

val book = new Book[String,Int]("a",1)
book.t
book.c


class Book1[T](val t:T,val c:T){

}

def sum[T](t:T,op:Int): Unit ={
  println(t+","+op)
}
sum[Int](2,2)
