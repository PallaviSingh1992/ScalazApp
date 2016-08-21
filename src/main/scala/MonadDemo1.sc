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