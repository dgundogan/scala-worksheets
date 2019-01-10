def pureSquare(x: Int): Int = x * x
val pureExpr = pureSquare(4) + pureSquare(3)

var globalState = 1
def impure(x: Int) : Int = {
  globalState = globalState + x
  globalState
}
val impureExpr = impure(3)


import scala.util.Random
def impureRand(): Int = Random.nextInt;
impureRand()
def pureRand(seed: Int): Int = new Random(seed).nextInt()
pureRand(10)


case class Rectangle(width: Double, height: Double)

def area(r: Rectangle): Double =
  if (r.width > 5 || r.height > 5)
    throw new IllegalArgumentException("too big")
  else
    r.width * r.height


val area1 = area(Rectangle(3,4))
val area2 = area(Rectangle(1,2))



