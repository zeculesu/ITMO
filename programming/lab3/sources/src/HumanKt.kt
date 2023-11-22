import io.github.zeculesu.itmo.programming.lab3.Mood

class HumanKt(val name: IntArray,
              val mood: Mood,
              val height: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is HumanKt) return false
        if (this.name != other.name) return false
        if (this.mood != other.mood) return false
        if (this.height != other.height) return false
        return true
    }
}