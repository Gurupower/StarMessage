class Star(var posX: Int, var posY:Int, val speedX:Int, val speedY:Int) {

    fun getPosX(steps: Int):Int {
        return posX + speedX*steps
    }

    fun getPosY(steps: Int):Int {
        return posY + speedY * steps
    }

    fun move(steps: Int) : Unit  {
        posX += speedX*steps
        posY += speedY*steps
    }
}