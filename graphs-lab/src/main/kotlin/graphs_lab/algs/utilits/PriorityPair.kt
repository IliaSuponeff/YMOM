package graphs_lab.algs.utilits

data class PriorityPair<I>(val priority: Long, val value: I) : Comparable<PriorityPair<I>> {

	override fun compareTo(other: PriorityPair<I>): Int {
		return priority.compareTo(other.priority)
	}

	override fun toString(): String {
		return "PriorityPair(priority=$priority, value=$value)"
	}

	override fun equals(other: Any?): Boolean {
		if (this===other) return true
		if (javaClass!=other?.javaClass) return false

		other as PriorityPair<*>

		if (priority!=other.priority) return false
		if (value!=other.value) return false

		return true
	}

	override fun hashCode(): Int {
		var result = priority.hashCode()
		result = 31 * result + (value?.hashCode() ?: 0)
		return result
	}

}