package graphs_lab.algs.utilits

class DisjointSets<T>(elements: Set<T>) {
	private val parents: MutableMap<T, T> = mutableMapOf()
	private val rangs: MutableMap<T, Int> = mutableMapOf()
	private var size = elements.size

	init {
		elements.forEach() { element ->
			parents.putIfAbsent(element, element)
			rangs.putIfAbsent(element, 0)
		}
	}

	fun findRoot(element: T): T {
		if (element !in parents.keys) throw IllegalArgumentException(
			"DisjointSet structure is not contains element $element"
		)

		val root: T = parent(element)
		updateRoot(element, root)
		return root
	}

	fun isConnected(firstElement: T, secondElement: T): Boolean {
		val firstRoot = findRoot(firstElement)
		val secondRoot = findRoot(secondElement)

		return firstRoot==secondRoot
	}

	fun unionSets(firstElement: T, secondElement: T) {
		val firstRoot = findRoot(firstElement)
		val secondRoot = findRoot(secondElement)

		if (firstRoot==secondRoot) return

		val firstRang: Int = rang(firstRoot)
		val secondRang: Int = rang(secondRoot)
		if (firstRang < secondRang) {
			parents[firstRoot] = secondRoot
		} else {
			parents[secondRoot] = firstRoot
			if (firstRang==secondRang) rangs[firstRoot] = firstRang + 1
		}
		size--
	}

	private fun rang(element: T): Int {
		return rangs.getOrDefault(element, 0)
	}

	private fun updateRoot(element: T, root: T) {
		var current: T = element
		while (true) {
			val parent = parent(current)
			if (parent==root) break
			parents[current] = root
			current = parent
		}
	}

	private fun parent(element: T): T {
		var current: T = element
		while (true) {
			val parent: T = parents.getOrDefault(current, current)
			if (parent==current) break
			current = parent
		}
		return current
	}

	override fun toString(): String {
		val builder = StringBuilder()
		for (element in parents.keys) {
			builder.append("($element: ${parent(element)}), ")
		}
		builder.trim()
		return "DisjointSet($builder)"
	}


}