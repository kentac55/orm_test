import models.Tables._
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object main extends App {
  val db = Database.forConfig("default")
1
  Await.result(db.run(Film.sortBy(_.filmId).result), Duration.Inf).foreach(film => {
    Await.result(db.run(FilmCategory.filter(_.filmId === film.filmId).result), Duration.Inf).foreach(filmCategory => {
      Await.result(db.run(Category.filter(_.categoryId === filmCategory.categoryId).result), Duration.Inf).foreach(category => {
        println(film.title, "\t", category.name)
      })
    })
  })

  Await.result(db.run(
    Film.join(FilmCategory.join(Category).on(_.categoryId === _.categoryId)).on(_.filmId === _._1.filmId).result
  ), Duration.Inf).foreach(res => {
    println(res._1.title, "\t", res._2._2.name)
  })
}
