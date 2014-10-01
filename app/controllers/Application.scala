package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import play.api.libs.json.Json
import play.api.libs.functional.syntax._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def receive = Action { implicit request =>
    val data = request.body.asFormUrlEncoded.get
    val ms1:List[String] = data.get("text1").get.toList
    val ms2:List[String] = data.get("text2").get.toList
    val sendMsg = "{" + ms2.head + ":"  + ms1.head + "}"
    val json = Json.toJson(sendMsg)

    Ok(json)
  }
}
