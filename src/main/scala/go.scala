import doobie.imports._
import cats._, cats.data._, cats.implicits._
import fs2.interop.cats._

object go extends App{

  val xa = DriverManagerTransactor[IOLite](
    "org.postgresql.Driver", "jdbc:postgresql:world", "postgres", "password"
  )

  def maker[A](a:ConnectionIO[A]): Unit = {
    println(a.transact(xa).unsafePerformIO)
  }
  val p1: ConnectionIO[Int] = 42.pure[ConnectionIO]
  maker(p1)

  val p2: ConnectionIO[Int] = sql"SELECT 42".query[Int].unique
  maker(p2)

  val p3:ConnectionIO[(Int,Double)] =
    for {
      a <- sql"Select 43".query[Int].unique
      b <- sql"SELECT random()".query[Double].unique
    } yield (a, b)
  maker(p3)

}
