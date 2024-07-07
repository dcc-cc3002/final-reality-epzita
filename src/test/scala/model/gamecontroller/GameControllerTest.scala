package model.gamecontroller

import model.armory.Staff
import model.character.specializations.WhiteMage
import model.state.GameController
import model.state.PreGame
import munit.FunSuite

class GameControllerTest extends FunSuite{
  var gameController: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    gameController = new GameController()
  }
  test("A game controller must start in the PreGame State"){
    assert(gameController.state.isInstanceOf[PreGame], true)
  }
}
