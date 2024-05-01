package graphs_lab.algs

import graphs_lab.algs.utilits.DisjointSets
import graphs_lab.algs.utilits.PriorityPair
import graphs_lab.algs.utilits.edgeWeight
import graphs_lab.core.edges.Edge
import graphs_lab.core.graphs.Graph
import java.util.PriorityQueue

class MinimumSpanningTree<I, E : Edge<I>, G : Graph<I, E>>(val graph: G) {

	init {
		if (graph.isDirected) throw IllegalArgumentException(
			"Graph ${graph.label} is directed. Can't construct minimum spanning tree for it"
		)
	}

	fun kruskalAlgorithm(): Set<E> {
		val (priorityQueue, verticesComponents, mst) = initKruskalAlgorithm()
		while (priorityQueue.isNotEmpty() && mst.size < graph.size - 1) {
			val edge: E = priorityQueue.poll().value
			if (verticesComponents.isConnected(edge.idSource, edge.idTarget)) continue
			verticesComponents.unionSets(edge.idSource, edge.idTarget)
			mst.add(edge)
		}
		return mst
	}

	private fun initKruskalAlgorithm(): Triple<PriorityQueue<PriorityPair<E>>, DisjointSets<I>, MutableSet<E>> {
		val priorityQueue = PriorityQueue<PriorityPair<E>>()
		for (idVertex in graph.idVertices) {
			graph.vertexEdges(idVertex).forEach() { edge ->
				priorityQueue.add(
					PriorityPair(
						edgeWeight(edge).toLong(),
						edge
					)
				)
			}
		}
		return Triple(priorityQueue, DisjointSets(graph.idVertices), mutableSetOf())
	}

}
