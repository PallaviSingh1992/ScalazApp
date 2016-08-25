class MyContainer[T](val value: T) {

  def flatMap[A, B](func: A => MyContainer[B]): MyContainer[A] => MyContainer[B] = {
    (a: MyContainer[A]) => func(a.value)
  }
}

val stringContainer: MyContainer[String] = new MyContainer("Knoldus Software LLP")

def lengthOf(str: String) = new MyContainer(str.length)

val transformedLength = stringContainer.flatMap(lengthOf)

val result: MyContainer[Int] = transformedLength(stringContainer)

result.value


//Treat generic monad as interface and concrete monad as implementation

trait M[A] {
  def flatMap[B](f: A => M[B]): M[B]
  //	def flatMap[A,B](f:A =>M[B]):M[A]=>M[B]
}


























/*
Unit performs the wrapping part, defined it outside because we don't want to
invoke it upon existing monadic object. So create it as standalone static
method
 */
//def unit[A](x: A): M[A]
//val f=(i:Int)=>List("prev="+(i-1),"curr="+i,"fwd="+(i+1))
//val list=List(9,10,11)
//list.flatMap(f)