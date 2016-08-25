//FUNCTOR
class MyContainer[T](val value: T) {
  def map[A, B](rawFunc: A => B): MyContainer[A] => MyContainer[B] = {
    (a: MyContainer[A]) => new MyContainer(rawFunc(a.value))
  }
}

/*
Apply Some Transformation on the value type in the Container
without leaving the Container. Some other type shall also be in Container.
Eg.
MyContainer[String]=>MyContainer[Int]

We need :
def lengthOfString(str:MyContainer[String]):MyContainer[Int]
*/

//Application 1
def rawLengthOfString(str: String): Int = str.length
val stringContainer: MyContainer[String] = new MyContainer("Knoldus Software LLP")
val transformedLength = stringContainer.map(rawLengthOfString)
val result: MyContainer[Int] = transformedLength(stringContainer)
result.value

//Application 2
def rawIntConversion(num:Int):String=num.toString
val intContainer:MyContainer[Int]= new MyContainer(100)
val transformedInt=intContainer.map(rawIntConversion)
val res:MyContainer[String]=transformedInt(intContainer)
res.value.length

//Application 3
class Book(bookName:String,bookPrice:Double,bookAuthor:String){
  var name:String=bookName
  var price:Double=bookPrice
  var author:String=bookAuthor
}
class LibraryBook(bookName:String,bookPrice:Double,bookAuthor:String){
  var name:String=bookName
  var price:Double=bookPrice
  var author:String=bookAuthor
  var ispn:Option[String]=None

  def ispn(cat:String): String ={
    val generatedIspn=cat+"-"+this.author+"-"+scala.util.Random.nextInt()
    ispn=Some(generatedIspn)
    generatedIspn
  }
}
val userContainer:MyContainer[Book]=new MyContainer(new Book("Scala",2000.12,"Martin Odersky"))
def conversion(book:Book):LibraryBook= {
  val generateBook=new LibraryBook(book.name,book.price,book.author)
  generateBook.ispn("Fiction")
  generateBook
}
val transformation=userContainer.map(conversion)
val transformedResult=transformation(userContainer)

val newBook=transformedResult.value.ispn






