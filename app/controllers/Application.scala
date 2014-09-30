package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import play.api.libs.json.Json
import play.api.libs.functional.syntax._

case class ReceiveWord (
  wordData: String
)

object Application extends Controller {

  implicit val jsonReads = Json.format[ReceiveWord]

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def receive = Action { implicit request =>
    val data = request.body.asFormUrlEncoded
    val sendMsg = """{ status: """ + data.get + """ } """
    val json = Json.toJson(sendMsg)

    Ok(json)
  }
}
