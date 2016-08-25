class MyContainer[T](val value: T) {

  def apply[A, B](b: MyContainer[A => B]): MyContainer[A] => MyContainer[B] = {
    (a: MyContainer[A]) => new MyContainer[B](b.value(a.value))
  }
}

val stringContainer: MyContainer[String] = new MyContainer("Knoldus Software LLP")

def rawLengthOfString(str: String): Int = str.length

val lengthOf: MyContainer[String => Int] = new MyContainer(rawLengthOfString _)

def transformedLength = stringContainer.apply(lengthOf)

val result: MyContainer[Int] = transformedLength(stringContainer)

result.value



























/*
trait Applicative[F[_]] {
  def apply[A, B](f: F[A => B]): F[A] => F[B]
}

 */